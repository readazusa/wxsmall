package club.lovety.wx.base.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public abstract  class BaseController {

    private static  final Logger log = LogManager.getLogger(BaseController.class);

    public String getRequestIp(HttpServletRequest request){



        String ip = request.getHeader("x-forwarded-for") == null ? request.getRemoteAddr() : request.getHeader("x-forwarded-for");
        return ip;
    }
}
