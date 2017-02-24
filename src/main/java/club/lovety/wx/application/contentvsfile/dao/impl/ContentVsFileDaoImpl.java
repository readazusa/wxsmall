package club.lovety.wx.application.contentvsfile.dao.impl;

import club.lovety.wx.application.contentvsfile.dao.IContentVsFileDao;
import club.lovety.wx.application.contentvsfile.entity.ContentVsFileInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 念梓  on 2017/2/22.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Repository
public class ContentVsFileDaoImpl extends SqlSessionDaoSupport implements IContentVsFileDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int save(ContentVsFileInfo contentVsFileInfo) {
        return this.getSqlSession().insert("ContentVsFileInfo.save",contentVsFileInfo);
    }

    @Override
    public List<ContentVsFileInfo> queryList(BaseSearchInfo<ContentVsFileInfo> baseSearchInfo) {
        return null;
    }

    @Override
    public int queryTotalCount(ContentVsFileInfo contentVsFileInfo) {
        return 0;
    }

    @Override
    public int batchSave(List<ContentVsFileInfo> contentVsFileInfoList) {
        return this.getSqlSession().insert("ContentVsFileInfo.batchSave",contentVsFileInfoList);
    }
}
