package com.ahern.livinghelper.recreation.history.model;

import java.util.List;

/**
 * @auther: WangHao on 2017/9/7 18:02
 * @email：Ahern.h.wang@emore-smart.com
 */

public class HistoryDetailRequestEntity {

    /**
     * result : [{"_id":"10850101","title":"司马光主持编撰的《资治通鉴》成书","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200911/30/0F02714956.jpg","year":1085,"month":1,"day":1,"des":"在932年前的今天，1085年1月1日 (农历腊月初三)，司马光主持编撰的《资治通鉴》成书。","content":"在932年前的今天，1085年1月1日 (农历腊月初三)，司马光主持编撰的《资治通鉴》成书。\n《资治通鉴》是我国北宋时编成的一部编年体通史。全书共294卷，又考异、目录各30卷。\n1066年（朱英宗治平三年），司马光将所撰的从战国至秦二世时的历代君臣事迹8卷进献英宗，并上疏：\u201c凡关国家之盛衰，系生民之休戚，善可为法，恶可为戒，帝王所立知者，（历史今天）略依左传春秋体，为编年一书，名曰《通志》。\u201d4月，朱英宗下旨设立书局，继续编撰。\n至1085年1月1日（元丰七年十二月初三日）全书编撰完毕，历时19年。全书上起公元前403年（周威烈王二十三年），下迄公元959年（后周世宗显德六年），贯串了1362年的史事。\n1067年（宋神宗治平四年），制序并赐名《资治通鉴》。在编撰过程中，司马光、刘做、刘恕、范祖禹等人取材于十七史、野史、传状。文集、话录等222种有关资料；其内容以政治。军事为主，略于经济文化。此书为中国古代历史的研究工作提供了较系统的历史资料。\n","lunar":"甲子年腊月初三"}]
     * reason : 请求成功！
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<HistoryDetailEntity> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<HistoryDetailEntity> getResult() {
        return result;
    }

    public void setResult(List<HistoryDetailEntity> result) {
        this.result = result;
    }


}
