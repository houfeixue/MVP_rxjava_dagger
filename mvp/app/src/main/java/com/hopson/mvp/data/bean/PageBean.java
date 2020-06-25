package com.hopson.mvp.data.bean;

import com.google.gson.Gson;

import java.util.List;

public class PageBean<T> {


    /**
     * count : 22
     * pageCount : 2
     * page : 1
     * list : []
     */

    private String count;
    private int pageCount;
    private int page;
    private List<T> list;

    public static PageBean objectFromData(String str) {

        return new Gson().fromJson(str, PageBean.class);
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
