package com.hopson.mvp.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.hopson.mvp.R;
import com.hopson.mvp.common.utils.DeviceUtils;
import com.hopson.mvp.di.component.AppCompenent;
import com.tbruyelle.rxpermissions2.RxPermissions;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    public static final int READ_PHONE_STATE_CODE = 1000;

    @BindView(R.id.btn)
    Button btn;

    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void setupActivityCommponent(AppCompenent appCompenent) {

    }

    @Override
    public void init() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {

        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.READ_PHONE_STATE)
                .subscribe(granted -> {
                    if (granted) { // Always true pre-M
                        // I can control the camera now
                        String imei =  DeviceUtils.getIMEI(this);
                Toast.makeText(this,imei,Toast.LENGTH_LONG).show();
                    } else {
                        // Oups permission denied
                        Toast.makeText(this,"IMEI授权失败",Toast.LENGTH_LONG).show();
                    }
                });

//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED)
//        {
//            //没有授权读取手机状态
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE},READ_PHONE_STATE_CODE);
//
//        }else {
//            //授权成功
//            String imei =  DeviceUtils.getIMEI(this);
//            Toast.makeText(this,imei,Toast.LENGTH_LONG).show();
//        }
    }

//    //处理权限的回调
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        if (requestCode == READ_PHONE_STATE_CODE){
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                //授权成功
////                模拟器拿不到手机唯一序列
//              String imei =  DeviceUtils.getIMEI(this);
//                Toast.makeText(this,imei,Toast.LENGTH_LONG).show();
//            }else {
//                Toast.makeText(this,"IMEI授权失败",Toast.LENGTH_LONG).show();
//
//            }
//        }
//    }
}
