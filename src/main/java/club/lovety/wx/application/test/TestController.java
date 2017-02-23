package club.lovety.wx.application.test;

import club.lovety.wx.config.DbConfig;
import club.lovety.wx.config.InitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by 念梓  on 2017/2/22.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private Environment environment;

    @Resource
    private InitConfig initConfig;

    @Resource
    private DbConfig dbConfig;

    @RequestMapping("init")
    public Object test(){
        System.out.println(environment.getProperty("jdbc.url"));
        System.out.println(initConfig.getUrl());
        return "23";
    }
}
