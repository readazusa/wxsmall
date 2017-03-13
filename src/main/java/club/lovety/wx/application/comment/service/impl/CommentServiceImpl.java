package club.lovety.wx.application.comment.service.impl;

import club.lovety.wx.application.comment.dao.ICommentDao;
import club.lovety.wx.application.comment.entity.CommentInfo;
import club.lovety.wx.application.comment.entity.CommentVsUser;
import club.lovety.wx.application.comment.service.ICommentService;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import club.lovety.wx.common.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        CommentVsUser commentVsUser = new CommentVsUser();
        for(CommentInfo commentInfoTaget: commentInfoList){
            commentVsUser.setCommentId(commentInfoTaget.getUid());
            commentVsUser.setNickName(commentInfoTaget.getNickName());
            commentInfoTaget.setHasLaud(this.queryLaudCountCommentByNickname(commentVsUser));
        }
        int totalCount = commentDao.queryTotalCount(commentInfo);
        basePageInfo.setData(commentInfoList);
        basePageInfo.setTotalCount(totalCount);
        basePageInfo.setPageIndex(Integer.parseInt(pageIndex));
        return basePageInfo;
    }

    @Override
    public int saveLaud(CommentVsUser commentVsUser) {
        commentVsUser.setUid(IdWorker.instance.getId());
        commentVsUser.setCreateTime(new Date());
        commentVsUser.setUpdateTime(new Date());
        return this.commentDao.saveLaud(commentVsUser);
    }

    @Override
    public int deleteLaud(CommentVsUser commentVsUser) {
        return this.commentDao.deleteLaud(commentVsUser);
    }

    @Override
    public int queryLaudCountCommentByNickname(CommentVsUser commentVsUser) {
        return this.commentDao.queryLaudCountCommentByNickname(commentVsUser);
    }

    @Transactional
    @Override
    public int updateCommentLaudCount(HttpServletRequest request) {
        CommentVsUser commentVsUser = new CommentVsUser();
        String laudCount = request.getParameter("laudCount");
        String uid = request.getParameter("uid");
        commentVsUser.setCommentId(Long.parseLong(uid));
        commentVsUser.setNickName(request.getParameter("nickName"));
        Map<String,Object> target = new HashMap<>();
        target.put("laudCount",laudCount);
        target.put("uid",uid);
        if("-1".equals(laudCount)){
            this.deleteLaud(commentVsUser);
        }else{
            this.saveLaud(commentVsUser);
        }
        return this.commentDao.updateCommentLaudCount(target);
    }

    @Override
    public List<CommentInfo> loadCommentInfoByParentId(long uid) {
        return this.commentDao.loadCommentInfoByParentId(uid);
    }
}
