package com.since.sincethird.ret;

import com.since.sincethird.common.Config;
import com.since.sincethird.util.WXUtil;

/**
 * @author luoxinyuan
 */
public interface Result {
    Code SUCCESS = new Code("0");
    Code NOT_LOGIN = new Code("500_001", WXUtil.genURL(Config.appId,Config.HOST+Config.loginURL));
    Code NOT_FIND_ERROR= new Code("404","该页面不存在！");
}
