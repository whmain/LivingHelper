package com.ahern.livinghelper.recreation.turingchat.model;

/**
 * @auther: WangHao on 2017/9/8 15:54
 * @email：Ahern.h.wang@emore-smart.com
 */

public class TuringRequestDataEntity {

    /**
     * code : 10000
     * charge : false
     * msg : 查询成功
     * result : {"code":200000,"text":"亲，已帮你找到体育新闻","url":"http://m.toutiao.com/#channel=news_sports"}
     */

    private String code;
    private boolean charge;
    private String msg;
    private ResultBean result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * code : 200000
         * text : 亲，已帮你找到体育新闻
         * url : http://m.toutiao.com/#channel=news_sports
         */

        private int code;
        private String text;
        private String url;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
