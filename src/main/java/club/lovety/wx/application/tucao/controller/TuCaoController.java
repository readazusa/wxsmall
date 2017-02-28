package club.lovety.wx.application.tucao.controller;

import club.lovety.wx.application.tucao.entity.TuCaoInfo;
import club.lovety.wx.application.tucao.service.ITuCaoService;
import club.lovety.wx.base.controller.BaseController;

import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.common.Result;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

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
        Result result =  new Result();
        try{
            BasePageInfo<TuCaoInfo> basePageInfo = tuCaoService.queryBasePageInfo(request);
            result.setData(basePageInfo);
        }catch (Exception ex){
            log.error("展示吐槽列表失败: ",ex);
            result.setCode("00001");
            result.setMsg(ex.getMessage());
        }
        return result;
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


    @RequestMapping("view")
    public Object doView(@RequestParam("uid") long uid){
        Result result = new Result();
        try{
            TuCaoInfo tuCaoInfo = tuCaoService.view(uid);
            result.setData(tuCaoInfo);
        }catch (Exception ex){
            log.error("查看吐槽信息失败,失败信息: ",ex);
            result.setMsg(ex.getMessage());
            result.setCode("000001");
        }
        return result;
    }



}
