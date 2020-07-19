package com.since.sincethird.filter;

import com.alibaba.fastjson.JSON;
import com.since.sincethird.common.Config;
import com.since.sincethird.common.SessionKey;
import com.since.sincethird.ret.Result;
import com.since.sincethird.ret.Ret;
import com.since.sincethird.util.WXUtil;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
public class SessionFilter implements Filter {
    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] excludeUrls = new String[]{Config.excludeURL};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
        System.out.println("filter url:"+uri);
        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);


        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
          if(session!=null&&session.getAttribute(SessionKey.LOGIN_USER) != null){
                filterChain.doFilter(request, response);
            }else{
                String requestType = request.getHeader("X-Requested-With");
                //判断是否是ajax请求
                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
                    response.getWriter().write(JSON.toJSONString(Ret.error(Result.NOT_LOGIN)));
                }else{
                    //重定向到登录页(需要在static文件夹下建立此html文件)
                    String redirectURL = WXUtil.genURL(Config.appId,Config.HOST+Config.loginURL);
                    response.sendRedirect(request.getContextPath()+redirectURL);
                }
                return;
            }
        }
    }

    /**
     * @Author: xxxxx
     * @Description: 是否需要过滤
     * @Date: 2018-03-12 13:20:54
     * @param uri
     */
    public boolean isNeedFilter(String uri) {

        for (String includeUrl : excludeUrls) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }
        if (uri.contains(Config.loginURL)){
            return false;
        }
        return true;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
