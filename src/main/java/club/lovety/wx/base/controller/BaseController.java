package club.lovety.wx.base.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public abstract  class BaseController {

    public String getRequestIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for") == null ? request.getRemoteAddr() : request.getHeader("x-forwarded-for");
        return ip;
    }
}
