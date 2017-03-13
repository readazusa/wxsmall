package club.lovety.wx.application.comment.service;

import club.lovety.wx.application.comment.entity.CommentInfo;
import club.lovety.wx.application.comment.entity.CommentVsUser;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import club.lovety.wx.base.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface ICommentService extends IService<CommentInfo> {

    public BasePageInfo<CommentInfo> queryBasePageInfo(HttpServletRequest request);


    public int saveLaud(CommentVsUser commentVsUser);


    public int deleteLaud(CommentVsUser commentVsUser);

    /**
     * 获取该用户是否赞了该条评论
     */
    public int queryLaudCountCommentByNickname(CommentVsUser commentVsUser);

    /**
     * 更新赞的操作
     * @return
     */
    public int updateCommentLaudCount(HttpServletRequest request);



    public List<CommentInfo> loadCommentInfoByParentId(long uid);
}
