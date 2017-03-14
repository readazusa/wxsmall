package club.lovety.wx.application.video.dao.impl;

import club.lovety.wx.application.video.dao.IVideoDao;
import club.lovety.wx.application.video.entity.VideoInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 念梓  on 2017/3/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Repository
public class VideoDaoImpl extends SqlSessionDaoSupport implements IVideoDao {

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int save(VideoInfo videoInfo) {
        return 0;
    }

    @Override
    public List<VideoInfo> queryPage(BaseSearchInfo<VideoInfo> baseSearchInfo) {
        return null;
    }

    @Override
    public int queryTotalCount(VideoInfo videoInfo) {
        return 0;
    }

    @Override
    public VideoInfo view(long uid) {
        return null;
    }
}
