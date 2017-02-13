package club.lovety.wx.main.controller;

import club.lovety.wx.main.entity.UserInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 念梓  on 2017/1/12.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RestController
@RequestMapping("main")
public class MainController {
    private static final Logger log = LogManager.getLogger(MainController.class);

    @RequestMapping(value = "init", method = RequestMethod.GET)
    public String init(HttpServletRequest request) {
        String echostr = request.getParameter("echostr");
        log.debug("微信小程序服务器验证: echostr: {}",echostr);
        return echostr;
    }

    @RequestMapping("user")
    @ResponseBody
    public UserInfo queryUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId("123");
        return userInfo;
    }

    @RequestMapping(value = "init",method = RequestMethod.POST)
    public void receive(){
        log.debug("接收了微信小程序发过来的消息");
    }

}
