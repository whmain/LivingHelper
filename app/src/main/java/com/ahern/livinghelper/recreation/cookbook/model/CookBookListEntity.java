package com.ahern.livinghelper.recreation.cookbook.model;

import java.io.Serializable;
import java.util.List;

/**
 * @auther: WangHao on 2017/9/11 16:43
 * @email：Ahern.h.wang@emore-smart.com
 */

public class CookBookListEntity {

    /**
     * code : 10000
     * charge : false
     * msg : 查询成功
     * result : {"msg":"ok","result":{"num":"1","list":[{"classid":"24","process":[{"pcontent":"先把虾清洗一下。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141253_70570.jpg"},{"pcontent":"再剪去虾须，将虾背剪开，抽出沙线。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_48259.jpg"},{"pcontent":"清理好的虾。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_77549.jpg"},{"pcontent":"葱姜蒜洗净后切成末。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_74719.jpg"},{"pcontent":"锅中放入比平时炒菜略多一点的油， 油热后放入大虾，待虾的一面变红后放入葱姜末，然后翻面。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_81174.jpg"},{"pcontent":"放入少许番茄酱炒匀。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_43197.jpg"},{"pcontent":"烹入料酒。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_98717.jpg"},{"pcontent":"加入盐、糖、高汤烧开。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_62158.jpg"},{"pcontent":"烧开后改小火，盖上锅盖焖约3分钟。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_12941.jpg"},{"pcontent":"转中火收汁微干，淋入几滴醋即可。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141255_92532.jpg"}],"preparetime":"10-20分钟","material":[{"amount":"适量","mname":"油","type":"0"},{"amount":"适量","mname":"盐","type":"0"},{"amount":"适量","mname":"葱","type":"0"},{"amount":"适量","mname":"姜","type":"0"},{"amount":"适量","mname":"蒜","type":"0"},{"amount":"适量","mname":"番茄酱","type":"0"},{"amount":"适量","mname":"糖","type":"0"},{"amount":"适量","mname":"高汤","type":"0"},{"amount":"适量","mname":"醋","type":"0"},{"amount":"350g","mname":"虾","type":"1"}],"name":"油焖大虾","id":"5328","pic":"http://api.jisuapi.com/recipe/upload/20160719/122644_42140.jpg","tag":"下酒菜,增强免疫力,油焖,补钙,鲁菜","peoplenum":"1-2人","content":"虾的营养价值极高，能增强人体的免疫力，海虾是可以为大脑提供营养的美味食品。油焖大虾色泽枣红亮丽，味香飘逸，鲜嫩微甜，油润适口。在餐桌上是极受欢迎的一道菜。<br />一直都爱吃老爸做的大虾，鲜美可口，让人垂涎三尺。这个时候，老爸也就会拿起酒杯，喝上二两白酒，真是美哉！","cookingtime":"10-20分钟"}]},"status":"0"}
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
         * result : {"num":"1","list":[{"classid":"24","process":[{"pcontent":"先把虾清洗一下。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141253_70570.jpg"},{"pcontent":"再剪去虾须，将虾背剪开，抽出沙线。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_48259.jpg"},{"pcontent":"清理好的虾。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_77549.jpg"},{"pcontent":"葱姜蒜洗净后切成末。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_74719.jpg"},{"pcontent":"锅中放入比平时炒菜略多一点的油， 油热后放入大虾，待虾的一面变红后放入葱姜末，然后翻面。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_81174.jpg"},{"pcontent":"放入少许番茄酱炒匀。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_43197.jpg"},{"pcontent":"烹入料酒。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_98717.jpg"},{"pcontent":"加入盐、糖、高汤烧开。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_62158.jpg"},{"pcontent":"烧开后改小火，盖上锅盖焖约3分钟。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_12941.jpg"},{"pcontent":"转中火收汁微干，淋入几滴醋即可。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141255_92532.jpg"}],"preparetime":"10-20分钟","material":[{"amount":"适量","mname":"油","type":"0"},{"amount":"适量","mname":"盐","type":"0"},{"amount":"适量","mname":"葱","type":"0"},{"amount":"适量","mname":"姜","type":"0"},{"amount":"适量","mname":"蒜","type":"0"},{"amount":"适量","mname":"番茄酱","type":"0"},{"amount":"适量","mname":"糖","type":"0"},{"amount":"适量","mname":"高汤","type":"0"},{"amount":"适量","mname":"醋","type":"0"},{"amount":"350g","mname":"虾","type":"1"}],"name":"油焖大虾","id":"5328","pic":"http://api.jisuapi.com/recipe/upload/20160719/122644_42140.jpg","tag":"下酒菜,增强免疫力,油焖,补钙,鲁菜","peoplenum":"1-2人","content":"虾的营养价值极高，能增强人体的免疫力，海虾是可以为大脑提供营养的美味食品。油焖大虾色泽枣红亮丽，味香飘逸，鲜嫩微甜，油润适口。在餐桌上是极受欢迎的一道菜。<br />一直都爱吃老爸做的大虾，鲜美可口，让人垂涎三尺。这个时候，老爸也就会拿起酒杯，喝上二两白酒，真是美哉！","cookingtime":"10-20分钟"}]}
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
             * num : 1
             * list : [{"classid":"24","process":[{"pcontent":"先把虾清洗一下。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141253_70570.jpg"},{"pcontent":"再剪去虾须，将虾背剪开，抽出沙线。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_48259.jpg"},{"pcontent":"清理好的虾。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_77549.jpg"},{"pcontent":"葱姜蒜洗净后切成末。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_74719.jpg"},{"pcontent":"锅中放入比平时炒菜略多一点的油， 油热后放入大虾，待虾的一面变红后放入葱姜末，然后翻面。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_81174.jpg"},{"pcontent":"放入少许番茄酱炒匀。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_43197.jpg"},{"pcontent":"烹入料酒。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_98717.jpg"},{"pcontent":"加入盐、糖、高汤烧开。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_62158.jpg"},{"pcontent":"烧开后改小火，盖上锅盖焖约3分钟。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_12941.jpg"},{"pcontent":"转中火收汁微干，淋入几滴醋即可。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141255_92532.jpg"}],"preparetime":"10-20分钟","material":[{"amount":"适量","mname":"油","type":"0"},{"amount":"适量","mname":"盐","type":"0"},{"amount":"适量","mname":"葱","type":"0"},{"amount":"适量","mname":"姜","type":"0"},{"amount":"适量","mname":"蒜","type":"0"},{"amount":"适量","mname":"番茄酱","type":"0"},{"amount":"适量","mname":"糖","type":"0"},{"amount":"适量","mname":"高汤","type":"0"},{"amount":"适量","mname":"醋","type":"0"},{"amount":"350g","mname":"虾","type":"1"}],"name":"油焖大虾","id":"5328","pic":"http://api.jisuapi.com/recipe/upload/20160719/122644_42140.jpg","tag":"下酒菜,增强免疫力,油焖,补钙,鲁菜","peoplenum":"1-2人","content":"虾的营养价值极高，能增强人体的免疫力，海虾是可以为大脑提供营养的美味食品。油焖大虾色泽枣红亮丽，味香飘逸，鲜嫩微甜，油润适口。在餐桌上是极受欢迎的一道菜。<br />一直都爱吃老爸做的大虾，鲜美可口，让人垂涎三尺。这个时候，老爸也就会拿起酒杯，喝上二两白酒，真是美哉！","cookingtime":"10-20分钟"}]
             */

            private String num;
            private List<ListBean> list;

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean implements Serializable{
                /**
                 * classid : 24
                 * process : [{"pcontent":"先把虾清洗一下。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141253_70570.jpg"},{"pcontent":"再剪去虾须，将虾背剪开，抽出沙线。<br />\n","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_48259.jpg"},{"pcontent":"清理好的虾。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_77549.jpg"},{"pcontent":"葱姜蒜洗净后切成末。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_74719.jpg"},{"pcontent":"锅中放入比平时炒菜略多一点的油， 油热后放入大虾，待虾的一面变红后放入葱姜末，然后翻面。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_81174.jpg"},{"pcontent":"放入少许番茄酱炒匀。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_43197.jpg"},{"pcontent":"烹入料酒。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_98717.jpg"},{"pcontent":"加入盐、糖、高汤烧开。","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_62158.jpg"},{"pcontent":"烧开后改小火，盖上锅盖焖约3分钟。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141254_12941.jpg"},{"pcontent":"转中火收汁微干，淋入几滴醋即可。 ","pic":"http://api.jisuapi.com/recipe/upload/20160720/141255_92532.jpg"}]
                 * preparetime : 10-20分钟
                 * material : [{"amount":"适量","mname":"油","type":"0"},{"amount":"适量","mname":"盐","type":"0"},{"amount":"适量","mname":"葱","type":"0"},{"amount":"适量","mname":"姜","type":"0"},{"amount":"适量","mname":"蒜","type":"0"},{"amount":"适量","mname":"番茄酱","type":"0"},{"amount":"适量","mname":"糖","type":"0"},{"amount":"适量","mname":"高汤","type":"0"},{"amount":"适量","mname":"醋","type":"0"},{"amount":"350g","mname":"虾","type":"1"}]
                 * name : 油焖大虾
                 * id : 5328
                 * pic : http://api.jisuapi.com/recipe/upload/20160719/122644_42140.jpg
                 * tag : 下酒菜,增强免疫力,油焖,补钙,鲁菜
                 * peoplenum : 1-2人
                 * content : 虾的营养价值极高，能增强人体的免疫力，海虾是可以为大脑提供营养的美味食品。油焖大虾色泽枣红亮丽，味香飘逸，鲜嫩微甜，油润适口。在餐桌上是极受欢迎的一道菜。<br />一直都爱吃老爸做的大虾，鲜美可口，让人垂涎三尺。这个时候，老爸也就会拿起酒杯，喝上二两白酒，真是美哉！
                 * cookingtime : 10-20分钟
                 */

                private String classid;
                private String preparetime;
                private String name;
                private String id;
                private String pic;
                private String tag;
                private String peoplenum;
                private String content;
                private String cookingtime;
                private List<ProcessBean> process;
                private List<MaterialBean> material;

                public String getClassid() {
                    return classid;
                }

                public void setClassid(String classid) {
                    this.classid = classid;
                }

                public String getPreparetime() {
                    return preparetime;
                }

                public void setPreparetime(String preparetime) {
                    this.preparetime = preparetime;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getPeoplenum() {
                    return peoplenum;
                }

                public void setPeoplenum(String peoplenum) {
                    this.peoplenum = peoplenum;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getCookingtime() {
                    return cookingtime;
                }

                public void setCookingtime(String cookingtime) {
                    this.cookingtime = cookingtime;
                }

                public List<ProcessBean> getProcess() {
                    return process;
                }

                public void setProcess(List<ProcessBean> process) {
                    this.process = process;
                }

                public List<MaterialBean> getMaterial() {
                    return material;
                }

                public void setMaterial(List<MaterialBean> material) {
                    this.material = material;
                }

                public static class ProcessBean implements Serializable{
                    /**
                     * pcontent : 先把虾清洗一下。
                     * pic : http://api.jisuapi.com/recipe/upload/20160720/141253_70570.jpg
                     */

                    private String pcontent;
                    private String pic;

                    public String getPcontent() {
                        return pcontent;
                    }

                    public void setPcontent(String pcontent) {
                        this.pcontent = pcontent;
                    }

                    public String getPic() {
                        return pic;
                    }

                    public void setPic(String pic) {
                        this.pic = pic;
                    }
                }

                public static class MaterialBean implements Serializable{
                    /**
                     * amount : 适量
                     * mname : 油
                     * type : 0
                     */

                    private String amount;
                    private String mname;
                    private String type;

                    public String getAmount() {
                        return amount;
                    }

                    public void setAmount(String amount) {
                        this.amount = amount;
                    }

                    public String getMname() {
                        return mname;
                    }

                    public void setMname(String mname) {
                        this.mname = mname;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }
                }
            }
        }
    }
}
