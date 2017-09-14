package com.ahern.livinghelper.tool.oneiromancy.model;

import com.google.gson.annotations.SerializedName;

/**
 * @auther: WangHao on 2017/9/8 10:20
 * @email：Ahern.h.wang@emore-smart.com
 */

public class DreamBriefEntity {

    /**
     * id : 913d226b18ff44fda2fdc8ec1d3851c1
     * title : 蛇
     * des : 蛇在梦中出现是典型的具有性意味的意象，梦见蛇可能暗示你对性的感觉或是性生活的状态。也许你最近有些欲求不满;也许性行为让你充满罪恶感，甚至感觉污秽;也可能你的性生活很美满，让你乐在其中。不同的梦境中，蛇给不同的做梦者带来不同的心理感觉。
     */

    private String id;
    private String title;
    @SerializedName("des")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
