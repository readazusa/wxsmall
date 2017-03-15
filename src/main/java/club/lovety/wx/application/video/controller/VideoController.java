package club.lovety.wx.application.video.controller;

import club.lovety.wx.application.video.entity.VideoInfo;
import club.lovety.wx.application.video.service.IVideoService;
import club.lovety.wx.base.controller.BaseController;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.common.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/3/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */

@RestController
@RequestMapping("video")
public class VideoController extends BaseController {

    private static final Logger log = LogManager.getLogger(VideoController.class);

    @Resource
    private IVideoService videoService;

    @RequestMapping("page")
    public Object  page(HttpServletRequest request){

        Result result =  new Result();
        try{
            BasePageInfo<VideoInfo> basePageInfo = videoService.queryBasePageInfo(request);
            result.setData(basePageInfo);
        }catch (Exception ex){
            log.error("展示吐槽列表失败: ",ex);
            result.setCode("00001");
            result.setMsg(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("add")
    public Object doAdd(@RequestBody VideoInfo videoInfo, HttpServletRequest request){
        Result result = new Result();
        try{
            videoInfo.setIp(this.getRequestIp(request));
            videoService.save(videoInfo);
        }catch (Exception ex){
            result.setMsg(ex.getMessage());
            result.setCode("00001");
            log.error("保存视频失败: ",ex);
        }
        return result;
    }

    @RequestMapping("view")
    public Object doView(@RequestParam("uid") long uid){
        Result result = new Result();
        try{
            VideoInfo videoInfo = videoService.view(uid);
            result.setData(videoInfo);
        }catch (Exception ex){
            log.error("查看视频信息失败,失败信息: ",ex);
            result.setMsg(ex.getMessage());
            result.setCode("000001");
        }
        return result;
    }
}
