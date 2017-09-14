package com.ahern.livinghelper.recreation.newschannel.model;

import java.io.Serializable;
import java.util.List;

/**
 * @auther: WangHao on 2017/9/13 16:12
 * @email：Ahern.h.wang@emore-smart.com
 */

public class NewsRequestEntity {

    /**
     * code : 10000
     * charge : false
     * msg : 查询成功
     * result : {"msg":"ok","result":{"num":"2","channel":"娱乐","list":[{"src":"新浪娱乐","weburl":"http://ent.sina.com.cn/s/m/2017-09-13/doc-ifykusey9998414.shtml","time":"2017.09.13 15:15:08","pic":"http://api.jisuapi.com/news/upload/201709/13160016_77425.jpg","title":"张歆艺发袁弘半裸照隔空表白：你问我爱你有多深","category":"ent","content":"<p class=\"art_p\">新浪娱乐讯 9月13日下午，张歆艺[微博]发微博秀恩爱再次虐狗，配文：\u201c你问我爱你有多深\u201d，以邓丽君的经典曲目《月亮代表我的心》隐喻自己的心与爱意。除此以外，她还大胆配图老公袁弘[微博]的半裸照片，明目张胆撒狗粮。照片是一张充满着文艺气息的黑白影像，袁弘靠在墙角，脸半侧过来望着相机后面的张歆艺，光洒在身上，有些忧郁，有些深情，也如往常一般帅气。<\/p><p class=\"art_p\">网友评价：\u201c性感！\u201d同时评论中也充满着酸酸甜甜的抱怨：\u201c大中午的发什么狗粮，虐死人了！\u201d（实习生昆丁/文）<\/p>","url":"http://ent.sina.cn/star/tv/2017-09-13/detail-ifykusey9998414.d.html?cre=tianyi&mod=went&loc=3&r=25&doct=0&rfunc=100&tj=none&tr=25"},{"src":"新浪娱乐","weburl":"http://ent.sina.com.cn/s/h/2017-09-13/doc-ifykusey9840837.shtml","time":"2017.09.13 12:07:08","pic":"http://api.jisuapi.com/news/upload/201709/13150013_81212.jpg","title":"欧弟与女儿电梯前自拍 JoJo穿小裙子戴小花超呆萌","category":"ent","content":"<p class=\"art_p\">新浪娱乐讯 9月13日，欧弟[微博]微博更新与女儿JoJo的合照一张。照片中，欧弟和JoJo站在电梯门前，从镜像中可见欧弟身穿灰色卫衣搭黑色短裤，脚踩运动鞋，一身休闲打扮，拿着手机在拍照。而一旁可爱的JoJo穿着蓝色的小裙子，头戴小花，扭头看向别处。<\/p><p class=\"art_p\">2015年12月，欧弟女儿小JoJo降生，如今已经快满2岁啦。照片中不知道爸爸在干什么的JoJo一脸茫然，呆萌可爱。网友们纷纷赞道：\u201c小不点儿好可爱！\u201d也有网友发现电梯里的欧弟腿长堪比超模，\u201c哥，腿过分细了。。。。。。\u201d<\/p><p class=\"art_p\">（实习生 白茉/文）<\/p>","url":"http://ent.sina.cn/star/hk_tw/2017-09-13/detail-ifykusey9840837.d.html?cre=tianyi&mod=went&loc=15&r=25&doct=0&rfunc=100&tj=none&tr=25"}]},"status":"0"}
     */

    private String code;
    private boolean charge;
    private String msg;
    private ResultBeanX result;

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

    public ResultBeanX getResult() {
        return result;
    }

    public void setResult(ResultBeanX result) {
        this.result = result;
    }

    public static class ResultBeanX {
        /**
         * msg : ok
         * result : {"num":"2","channel":"娱乐","list":[{"src":"新浪娱乐","weburl":"http://ent.sina.com.cn/s/m/2017-09-13/doc-ifykusey9998414.shtml","time":"2017.09.13 15:15:08","pic":"http://api.jisuapi.com/news/upload/201709/13160016_77425.jpg","title":"张歆艺发袁弘半裸照隔空表白：你问我爱你有多深","category":"ent","content":"<p class=\"art_p\">新浪娱乐讯 9月13日下午，张歆艺[微博]发微博秀恩爱再次虐狗，配文：\u201c你问我爱你有多深\u201d，以邓丽君的经典曲目《月亮代表我的心》隐喻自己的心与爱意。除此以外，她还大胆配图老公袁弘[微博]的半裸照片，明目张胆撒狗粮。照片是一张充满着文艺气息的黑白影像，袁弘靠在墙角，脸半侧过来望着相机后面的张歆艺，光洒在身上，有些忧郁，有些深情，也如往常一般帅气。<\/p><p class=\"art_p\">网友评价：\u201c性感！\u201d同时评论中也充满着酸酸甜甜的抱怨：\u201c大中午的发什么狗粮，虐死人了！\u201d（实习生昆丁/文）<\/p>","url":"http://ent.sina.cn/star/tv/2017-09-13/detail-ifykusey9998414.d.html?cre=tianyi&mod=went&loc=3&r=25&doct=0&rfunc=100&tj=none&tr=25"},{"src":"新浪娱乐","weburl":"http://ent.sina.com.cn/s/h/2017-09-13/doc-ifykusey9840837.shtml","time":"2017.09.13 12:07:08","pic":"http://api.jisuapi.com/news/upload/201709/13150013_81212.jpg","title":"欧弟与女儿电梯前自拍 JoJo穿小裙子戴小花超呆萌","category":"ent","content":"<p class=\"art_p\">新浪娱乐讯 9月13日，欧弟[微博]微博更新与女儿JoJo的合照一张。照片中，欧弟和JoJo站在电梯门前，从镜像中可见欧弟身穿灰色卫衣搭黑色短裤，脚踩运动鞋，一身休闲打扮，拿着手机在拍照。而一旁可爱的JoJo穿着蓝色的小裙子，头戴小花，扭头看向别处。<\/p><p class=\"art_p\">2015年12月，欧弟女儿小JoJo降生，如今已经快满2岁啦。照片中不知道爸爸在干什么的JoJo一脸茫然，呆萌可爱。网友们纷纷赞道：\u201c小不点儿好可爱！\u201d也有网友发现电梯里的欧弟腿长堪比超模，\u201c哥，腿过分细了。。。。。。\u201d<\/p><p class=\"art_p\">（实习生 白茉/文）<\/p>","url":"http://ent.sina.cn/star/hk_tw/2017-09-13/detail-ifykusey9840837.d.html?cre=tianyi&mod=went&loc=15&r=25&doct=0&rfunc=100&tj=none&tr=25"}]}
         * status : 0
         */

        private String msg;
        private ResultBean result;
        private String status;

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public static class ResultBean {
            /**
             * num : 2
             * channel : 娱乐
             * list : [{"src":"新浪娱乐","weburl":"http://ent.sina.com.cn/s/m/2017-09-13/doc-ifykusey9998414.shtml","time":"2017.09.13 15:15:08","pic":"http://api.jisuapi.com/news/upload/201709/13160016_77425.jpg","title":"张歆艺发袁弘半裸照隔空表白：你问我爱你有多深","category":"ent","content":"<p class=\"art_p\">新浪娱乐讯 9月13日下午，张歆艺[微博]发微博秀恩爱再次虐狗，配文：\u201c你问我爱你有多深\u201d，以邓丽君的经典曲目《月亮代表我的心》隐喻自己的心与爱意。除此以外，她还大胆配图老公袁弘[微博]的半裸照片，明目张胆撒狗粮。照片是一张充满着文艺气息的黑白影像，袁弘靠在墙角，脸半侧过来望着相机后面的张歆艺，光洒在身上，有些忧郁，有些深情，也如往常一般帅气。<\/p><p class=\"art_p\">网友评价：\u201c性感！\u201d同时评论中也充满着酸酸甜甜的抱怨：\u201c大中午的发什么狗粮，虐死人了！\u201d（实习生昆丁/文）<\/p>","url":"http://ent.sina.cn/star/tv/2017-09-13/detail-ifykusey9998414.d.html?cre=tianyi&mod=went&loc=3&r=25&doct=0&rfunc=100&tj=none&tr=25"},{"src":"新浪娱乐","weburl":"http://ent.sina.com.cn/s/h/2017-09-13/doc-ifykusey9840837.shtml","time":"2017.09.13 12:07:08","pic":"http://api.jisuapi.com/news/upload/201709/13150013_81212.jpg","title":"欧弟与女儿电梯前自拍 JoJo穿小裙子戴小花超呆萌","category":"ent","content":"<p class=\"art_p\">新浪娱乐讯 9月13日，欧弟[微博]微博更新与女儿JoJo的合照一张。照片中，欧弟和JoJo站在电梯门前，从镜像中可见欧弟身穿灰色卫衣搭黑色短裤，脚踩运动鞋，一身休闲打扮，拿着手机在拍照。而一旁可爱的JoJo穿着蓝色的小裙子，头戴小花，扭头看向别处。<\/p><p class=\"art_p\">2015年12月，欧弟女儿小JoJo降生，如今已经快满2岁啦。照片中不知道爸爸在干什么的JoJo一脸茫然，呆萌可爱。网友们纷纷赞道：\u201c小不点儿好可爱！\u201d也有网友发现电梯里的欧弟腿长堪比超模，\u201c哥，腿过分细了。。。。。。\u201d<\/p><p class=\"art_p\">（实习生 白茉/文）<\/p>","url":"http://ent.sina.cn/star/hk_tw/2017-09-13/detail-ifykusey9840837.d.html?cre=tianyi&mod=went&loc=15&r=25&doct=0&rfunc=100&tj=none&tr=25"}]
             */

            private String num;
            private String channel;
            private List<ListBean> list;

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean implements Serializable{
                /**
                 * src : 新浪娱乐
                 * weburl : http://ent.sina.com.cn/s/m/2017-09-13/doc-ifykusey9998414.shtml
                 * time : 2017.09.13 15:15:08
                 * pic : http://api.jisuapi.com/news/upload/201709/13160016_77425.jpg
                 * title : 张歆艺发袁弘半裸照隔空表白：你问我爱你有多深
                 * category : ent
                 * content : <p class="art_p">新浪娱乐讯 9月13日下午，张歆艺[微博]发微博秀恩爱再次虐狗，配文：“你问我爱你有多深”，以邓丽君的经典曲目《月亮代表我的心》隐喻自己的心与爱意。除此以外，她还大胆配图老公袁弘[微博]的半裸照片，明目张胆撒狗粮。照片是一张充满着文艺气息的黑白影像，袁弘靠在墙角，脸半侧过来望着相机后面的张歆艺，光洒在身上，有些忧郁，有些深情，也如往常一般帅气。</p><p class="art_p">网友评价：“性感！”同时评论中也充满着酸酸甜甜的抱怨：“大中午的发什么狗粮，虐死人了！”（实习生昆丁/文）</p>
                 * url : http://ent.sina.cn/star/tv/2017-09-13/detail-ifykusey9998414.d.html?cre=tianyi&mod=went&loc=3&r=25&doct=0&rfunc=100&tj=none&tr=25
                 */

                private String src;
                private String weburl;
                private String time;
                private String pic;
                private String title;
                private String category;
                private String content;
                private String url;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public String getWeburl() {
                    return weburl;
                }

                public void setWeburl(String weburl) {
                    this.weburl = weburl;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
