package club.lovety.wx.application.comment.service.impl;

import club.lovety.wx.application.comment.dao.ICommentDao;
import club.lovety.wx.application.comment.entity.CommentInfo;
import club.lovety.wx.application.comment.service.ICommentService;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/2/28.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private ICommentDao commentDao;

    @Override
    public int save(CommentInfo commentInfo) {
        return commentDao.save(commentInfo);
    }

    @Override
    public BasePageInfo<CommentInfo> queryBasePageInfo(BaseSearchInfo<CommentInfo> baseSearchInfo) {
        return null;
    }

    @Override
    public CommentInfo view(long uid) {
        return null;
    }

    @Override
    public BasePageInfo<CommentInfo> queryBasePageInfo(HttpServletRequest request) {
        return null;
    }
}
