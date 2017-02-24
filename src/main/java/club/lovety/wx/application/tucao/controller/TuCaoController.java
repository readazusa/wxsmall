package club.lovety.wx.application.tucao.controller;

import club.lovety.wx.application.tucao.entity.TuCaoInfo;
import club.lovety.wx.application.tucao.service.ITuCaoService;
import club.lovety.wx.base.controller.BaseController;

import club.lovety.wx.common.Result;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    public static final Logger log = LogManager.getLogger(TuCaoController.class);

    @Resource
    private ITuCaoService tuCaoService;

    @RequestMapping("page")
    public Object  page(HttpServletRequest request){
//        tuCaoService.queryBasePageInfo()
        return null;
    }

    @RequestMapping("add")
    public Object doAdd(@RequestBody TuCaoInfo tuCaoInfo, HttpServletRequest request){
        Result result = new Result();
        try{
            tuCaoInfo.setIp(this.getRequestIp(request));
            tuCaoService.save(tuCaoInfo);
        }catch (Exception ex){
            result.setMsg(ex.getMessage());
            result.setCode("00001");
            log.error("保存信息失败: ",ex);
        }
        return result;
    }

}
