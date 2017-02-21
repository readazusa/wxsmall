package club.lovety.wx.application.tucao.controller;

import club.lovety.wx.application.tucao.entity.TuCaoInfo;
import club.lovety.wx.application.tucao.service.ITuCaoService;
import club.lovety.wx.base.controller.BaseController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RestController
@RequestMapping("tucao")
public class TuCaoController extends BaseController {


    @Resource
    private ITuCaoService tuCaoService;

    @RequestMapping("page")
    public Object  page(HttpServletRequest request){
        return null;
    }

    @RequestMapping("add")
    public Object doAdd(@RequestBody TuCaoInfo tuCaoInfo, HttpServletRequest request){
        tuCaoInfo.setIp(this.getRequestIp(request));
        return null;
    }




}
