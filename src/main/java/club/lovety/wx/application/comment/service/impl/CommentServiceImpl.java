package club.lovety.wx.application.comment.service.impl;

import club.lovety.wx.application.comment.dao.ICommentDao;
import club.lovety.wx.application.comment.entity.CommentInfo;
import club.lovety.wx.application.comment.service.ICommentService;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import club.lovety.wx.common.IdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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
        commentInfo.setUid(IdWorker.instance.getId());
        commentInfo.setCreateTime(new Date());
        commentInfo.setUpdateTime(new Date());
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
        BaseSearchInfo<CommentInfo> baseSearchInfo = new BaseSearchInfo<>();
        String pageIndex = request.getParameter("pageIndex");
        baseSearchInfo.setPageIndex((Integer.parseInt(pageIndex)-1)*baseSearchInfo.getPageSize());
        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setRelationUid(Long.parseLong(request.getParameter("relationId")));
        baseSearchInfo.setT(commentInfo);
        BasePageInfo<CommentInfo> basePageInfo = new BasePageInfo<>();
        List<CommentInfo> commentInfoList = commentDao.queryPage(baseSearchInfo);
        int totalCount = commentDao.queryTotalCount(commentInfo);
        basePageInfo.setData(commentInfoList);
        basePageInfo.setTotalCount(totalCount);
        return basePageInfo;
    }
}
