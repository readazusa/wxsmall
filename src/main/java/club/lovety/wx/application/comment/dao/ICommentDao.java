package club.lovety.wx.application.comment.dao;

import club.lovety.wx.application.comment.entity.CommentInfo;
import club.lovety.wx.application.comment.entity.CommentVsUser;
import club.lovety.wx.base.dao.IDao;

import java.util.List;
import java.util.Map;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface ICommentDao extends IDao<CommentInfo> {

    public int queryTotalCount(long relationUid) ;

    public int saveLaud(CommentVsUser commentVsUser);


    public int deleteLaud(CommentVsUser commentVsUser);

    /**
     * 获取该用户是否赞了该条评论
     */
    public int queryLaudCountCommentByNickname(CommentVsUser commentVsUser);

    /**
     * 更新赞的操作
     * @param param
     * @return
     */
    public int updateCommentLaudCount(Map<String,Object> param);

    public List<CommentInfo>  loadCommentInfoByParentId(long uid);

}
