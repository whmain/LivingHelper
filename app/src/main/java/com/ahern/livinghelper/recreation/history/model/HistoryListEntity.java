package com.ahern.livinghelper.recreation.history.model;

import com.google.gson.annotations.SerializedName;

/**
 * @auther: WangHao on 2017/9/7 16:47
 * @email：Ahern.h.wang@emore-smart.com
 */

public class HistoryListEntity {

    /**
     * _id : 10850101
     * title : 司马光主持编撰的《资治通鉴》成书
     * pic : http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200911/30/0F02714956.jpg
     * year : 1085
     * month : 1
     * day : 1
     * des : 在932年前的今天，1085年1月1日 (农历腊月初三)，司马光主持编撰的《资治通鉴》成书。
     * lunar : 甲子年腊月初三
     */

    @SerializedName("_id")
    private String id;
    private String title;
    @SerializedName("pic")
    private String picUrl;
    private int year;
    private int month;
    private int day;
    @SerializedName("des")
    private String description;
    private String lunar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }
}
