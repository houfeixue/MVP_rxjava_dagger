package com.hopson.mvp.common.http;

import android.content.Context;

import com.google.gson.Gson;
import com.hopson.mvp.common.constant.Constants;
import com.hopson.mvp.common.utils.DeviceUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

public class CommonParamsInterceptor implements Interceptor {


    public  static final MediaType JSON  = MediaType.parse("application/json; charset=utf-8");
    private Gson mGson;
    private Context mContext;



    public CommonParamsInterceptor(Context context,Gson mGson) {
        this.mGson = mGson;
        this.mContext = context;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //判断请求方式
        String method = request.method();
        HashMap<String,Object>commonParamsMap = new HashMap<>();
//        commonParamsMap.put(Constants.IMEI, DeviceUtils.getIMEI(mContext));

        if (method.equals("GET")){
          HttpUrl httpUrl = request.url();
            HashMap<String , Object> rootMap = new HashMap<>();

            Set<String> paramNames = httpUrl.queryParameterNames();
            for (String key:paramNames) {
                if (Constants.PNAME.equals(key)){
                    String oldParams = httpUrl.queryParameter(Constants.PNAME);

                    if (oldParams != null){
                        rootMap = mGson.fromJson(oldParams,HashMap.class);

                    }
                }else {
                    rootMap.put(key,httpUrl.queryParameter(key));
                }
            }

//           jaon Gson 转化 map
            rootMap.put("publicParams",commonParamsMap);

            String newJson = mGson.toJson(rootMap);

            String url = httpUrl.toString();
            int index = url.indexOf("?");
            if (index>0){
                url = url.substring(0,url.indexOf("?")) + "?" + Constants.PNAME + "=" + newJson;

            }else {
                url = url + "?" + Constants.PNAME + "=" + newJson;
            }
            //从新构建请求
            request = request.newBuilder().url(url).build();





        }else if(method.equals("POST")){
            HashMap<String , Object> rootMap = new HashMap<>();
            RequestBody body = request.body();
            if (body instanceof FormBody){
                for (int i = 0; i < ((FormBody)body).size(); i++) {
                    rootMap.put(((FormBody)body).encodedName(i),((FormBody) body).encodedValue(i));

                }

            }else{
//                okio.Buffer buffer = new Buffer();
//                body.writeTo(buffer);
//                String oldParma = buffer.readUtf8();
//                rootMap = mGson.fromJson(oldParma,HashMap.class);
//                rootMap.put("publicParams",commonParamsMap);
//                String newJson = mGson.toJson(rootMap);
//
//                request= request.newBuilder().post(RequestBody.create(JSON,newJson)).build();

            }

        }

        return chain.proceed(request);
    }
}
