package club.lovety.wx.application.comment.service;

import club.lovety.wx.application.comment.entity.CommentInfo;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import club.lovety.wx.base.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface ICommentService extends IService<CommentInfo> {

    public BasePageInfo<CommentInfo> queryBasePageInfo(HttpServletRequest request);



}
