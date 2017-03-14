package club.lovety.wx.application.file.dao.impl;

import club.lovety.wx.application.file.dao.IFileDao;
import club.lovety.wx.application.file.entity.FileInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 念梓  on 2017/2/21.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Repository
public class FileDaoImpl extends SqlSessionDaoSupport implements IFileDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int save(FileInfo fileInfo) {
        return this.getSqlSession().insert("FileInfo.save",fileInfo);
    }

    @Override
    public List<FileInfo> queryPage(BaseSearchInfo<FileInfo> baseSearchInfo) {
        return null;
    }

    @Override
    public int queryTotalCount(FileInfo fileInfo) {
        return 0;
    }

    @Override
    public FileInfo view(long uid) {
        return null;
    }

    @Override
    public List<String> queryFileByContentId(long contentId) {
        return this.getSqlSession().selectList("FileInfo.queryFileByContentId",contentId);
    }

    @Override
    public String queryFileUrlByContentId(long contentId) {
         List<String> fileUrls = this.getSqlSession().selectList("FileInfo.queryFileByContentId",contentId);
        return fileUrls.size()>0?fileUrls.get(0):null;
    }

}
