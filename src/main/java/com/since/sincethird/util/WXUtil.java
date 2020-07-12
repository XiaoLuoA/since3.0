package com.since.sincethird.util;

import java.net.URLEncoder;

public class WXUtil {

    /**
     * {"subscribe":null,
     * "openId":"oIaLN563Ujp5EPzh2agMoIOHiFpY",
     * "nickname":"韩信","sexDesc":"男",
     * "sex":1,"language":"zh_CN",
     * "city":"焦作",
     * "province":"河南",
     * "country":"中国",
     * "headImgUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epxoWwmuAmwsUb1mSvlRJX4icCBSQk3IMQxo28d0Beler3Hpg41biaJ7icwI8nfrS0exulYUBgNvh9gA/132",
     * "subscribeTime":null,
     * "unionId":"oilT_snzCqs_T3ldEnJEMVJV20fM",
     * "remark":null,"groupId":null,
     * "tagIds":null,"privileges":[],
     * "subscribeScene":null,"qrScene":null,"qrSceneStr":null}
     * @param args
     */
    public static void main(String[] args) {
        genURL("wx55cd46481d4e28d6","http://wxtest.easy.echosite.cn/wx/redirect/wx55cd46481d4e28d6/greet");
    }
    public static String genURL(String appid,String uri){
        String appidStr = "appid="+appid;
        String redirect_uri = "redirect_uri="+URLEncoder.encode(uri);
        String ret =  "https://open.weixin.qq.com/connect/oauth2/authorize?"+appidStr+"&"+redirect_uri
                +"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        System.out.println(ret);
        return ret;
    }
}
