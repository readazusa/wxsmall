package club.lovety.wx.application.comment.controller;

import club.lovety.wx.application.comment.entity.CommentInfo;
import club.lovety.wx.application.comment.service.ICommentService;
import club.lovety.wx.base.controller.BaseController;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.common.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/2/28.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RestController
@RequestMapping("comment")
public class CommentController  extends BaseController{


    private static final Logger log = LogManager.getLogger(CommentController.class);

    @Resource
    private ICommentService commentService;

    @RequestMapping("add")
    public Object add(@RequestBody  CommentInfo commentInfo, HttpServletRequest request) {
        Result result = new Result();
        try{
            commentInfo.setIp(this.getRequestIp(request));
            commentService.save(commentInfo);
        }catch (Exception ex){
            log.error("新增评论错误: ",ex);
            result.setCode("00001");
        }
        return result;
    }

    @RequestMapping("page")
    public Object queryPage(HttpServletRequest request) {
        Result result = new Result();
        try {
            BasePageInfo<CommentInfo> basePageInfo = commentService.queryBasePageInfo(request);
            result.setData(basePageInfo);
        } catch (Exception ex) {
            log.error("获取评论信息失败,失败信息: ",ex);
            result.setCode("00001");
            result.setMsg(ex.getMessage());
        }
        return result;
    }

    @RequestMapping("updatelaudcount")
    public Object updateLaudCount(HttpServletRequest request){
        Result result = new Result();
        try{
            commentService.updateCommentLaudCount(request);
        }catch (Exception ex){
        }
        return result;
    }
}
