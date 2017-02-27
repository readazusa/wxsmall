package club.lovety.wx.application.tucao.dao.impl;

import club.lovety.wx.application.tucao.dao.ITuCaoDao;
import club.lovety.wx.application.tucao.entity.TuCaoInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Repository
public class TuCaoDaoImpl extends SqlSessionDaoSupport implements ITuCaoDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int save(TuCaoInfo tuCaoInfo) {
        return this.getSqlSession().insert("TuCaoInfo.save",tuCaoInfo);
    }

    @Override
    public List<TuCaoInfo> queryPage(BaseSearchInfo<TuCaoInfo> baseSearchInfo) {
        return null;
    }

    @Override
    public int queryTotalCount(TuCaoInfo tuCaoInfo) {
        return 0;
    }

    @Override
    public TuCaoInfo view(long uid) {
        return null;
    }
}
