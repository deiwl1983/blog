package com.example.demo.vo;

import java.util.List;

/**
 * Created by wdg on 2018/5/29.
 */
public class PageBean<T> {

    List<T>  data;
    Long recordsTotal;
    Long recordsFiltered;
    int draw;


    public PageBean() {
    }

    public PageBean(List<T> data, Long recordsTotal) {
        this.data = data;
        this.recordsTotal = recordsTotal;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getDraw() {
        return draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setLength(int length) {
        this.length = length;
    }
    private int start;
    private  int length=10;

    public int getLength() {
        return length;
    }

    public int getStart() {
        return start;
    }
    // recordsTotal=21, pageNum=1  ,start=0,length=10   ; pageNum=2,start =10,length=10, pageNum=3,start=20,length=10,(1)
    //===>totalPages..
    public int getPageNum(){
        if(length==0) return 0;
        return ((int)start/length)+1;
    }

    public  int getTotalPages(){
        if(length==0) return 0;
        return ((int)((recordsTotal-1)/length))+1;
    }

}
