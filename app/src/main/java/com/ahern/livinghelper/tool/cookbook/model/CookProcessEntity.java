package com.ahern.livinghelper.tool.cookbook.model;

/**
 * @auther: WangHao on 2017/9/12 14:05
 * @email：Ahern.h.wang@emore-smart.com
 */

public class CookProcessEntity {
    private String process;
    private String picUrl;

    public String getProcess() {
        return process;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public CookProcessEntity(String process, String picUrl) {
        this.process = process;
        this.picUrl = picUrl;
    }

}
