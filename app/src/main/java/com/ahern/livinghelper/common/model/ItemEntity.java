package com.ahern.livinghelper.common.model;

/**
 * @auther: WangHao on 2017/9/6 15:20
 * @email：Ahern.h.wang@emore-smart.com
 */

public class ItemEntity {

    private String title;
    private int imageID;
    private String introduction;




    public ItemEntity(String title,int imageID,String introduction) {
        this.title = title;
        this.imageID = imageID;
        this.introduction = introduction;
    }

    public String getTitle() {
        return title;
    }
    public String getIntroduction() {
        return introduction;
    }

    public int getImageID() {
        return imageID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
