package club.lovety.wx.application.comment.dao;

import club.lovety.wx.application.comment.entity.CommentInfo;
import club.lovety.wx.base.dao.IDao;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface ICommentDao extends IDao<CommentInfo> {

    public int queryTotalCount(long relationUid) ;


}
