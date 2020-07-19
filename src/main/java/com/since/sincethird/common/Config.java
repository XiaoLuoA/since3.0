package com.since.sincethird.common;

/**
 * @author luoxinyuan
 */
public interface Config {
    String HOST = "http://www.sinceweb.xin";

    Integer YUAN_TO_FEN = 100;

    String appId = "wx55cd46481d4e28d6";

    String loginURL = "/wx/redirect/wx55cd46481d4e28d6/greet";

    String excludeURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx55cd46481d4e28d6&redirect_uri=http%3A%2F%2Fwww.sinceweb.xin%2Fwx%2Fredirect%2Fwx55cd46481d4e28d6%2Fgreet&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect";


}
