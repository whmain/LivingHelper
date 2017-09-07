package com.ahern.livinghelper.recreation.history.model;

import com.google.gson.annotations.SerializedName;

/**
 * @auther: WangHao on 2017/9/7 18:03
 * @email：Ahern.h.wang@emore-smart.com
 */

public class HistoryDetailEntity {

    /**
     * _id : 10850101
     * title : 司马光主持编撰的《资治通鉴》成书
     * pic : http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200911/30/0F02714956.jpg
     * year : 1085
     * month : 1
     * day : 1
     * des : 在932年前的今天，1085年1月1日 (农历腊月初三)，司马光主持编撰的《资治通鉴》成书。
     * content : 在932年前的今天，1085年1月1日 (农历腊月初三)，司马光主持编撰的《资治通鉴》成书。
     《资治通鉴》是我国北宋时编成的一部编年体通史。全书共294卷，又考异、目录各30卷。
     1066年（朱英宗治平三年），司马光将所撰的从战国至秦二世时的历代君臣事迹8卷进献英宗，并上疏：“凡关国家之盛衰，系生民之休戚，善可为法，恶可为戒，帝王所立知者，（历史今天）略依左传春秋体，为编年一书，名曰《通志》。”4月，朱英宗下旨设立书局，继续编撰。
     至1085年1月1日（元丰七年十二月初三日）全书编撰完毕，历时19年。全书上起公元前403年（周威烈王二十三年），下迄公元959年（后周世宗显德六年），贯串了1362年的史事。
     1067年（宋神宗治平四年），制序并赐名《资治通鉴》。在编撰过程中，司马光、刘做、刘恕、范祖禹等人取材于十七史、野史、传状。文集、话录等222种有关资料；其内容以政治。军事为主，略于经济文化。此书为中国古代历史的研究工作提供了较系统的历史资料。

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
    private String content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }
}
