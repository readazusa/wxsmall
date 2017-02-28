package club.lovety.wx.application.comment.dao.impl;

import club.lovety.wx.application.comment.dao.ICommentDao;
import club.lovety.wx.application.comment.entity.CommentInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 念梓  on 2017/2/28.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Repository
public class CommentDaoImpl extends SqlSessionDaoSupport implements ICommentDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int save(CommentInfo commentInfo) {
        return this.getSqlSession().insert("CommentInfo.save",commentInfo);
    }

    @Override
    public List<CommentInfo> queryPage(BaseSearchInfo<CommentInfo> baseSearchInfo) {
        return this.getSqlSession().selectList("CommentInfo.queryPage",baseSearchInfo);
    }

    @Override
    public int queryTotalCount(CommentInfo commentInfo) {
        return this.getSqlSession().selectOne("CommentInfo.queryTotalCount",commentInfo);
    }

    @Override
    public CommentInfo view(long uid) {
        return null;
    }

    @Override
    public int queryTotalCount(long relationUid) {
        return this.getSqlSession().selectOne("CommentInfo.queryTotalCount",relationUid);
    }
}
