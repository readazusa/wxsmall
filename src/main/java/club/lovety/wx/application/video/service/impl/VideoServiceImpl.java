package club.lovety.wx.application.video.service.impl;

import club.lovety.wx.application.contentvsfile.dao.IContentVsFileDao;
import club.lovety.wx.application.contentvsfile.entity.ContentVsFileInfo;
import club.lovety.wx.application.file.dao.IFileDao;
import club.lovety.wx.application.video.dao.IVideoDao;
import club.lovety.wx.application.video.entity.VideoInfo;
import club.lovety.wx.application.video.service.IVideoService;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import club.lovety.wx.common.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by 念梓  on 2017/3/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Service
public class VideoServiceImpl implements IVideoService {

    @Resource
    private IVideoDao videoDao;

    @Resource
    private IFileDao fileDao;

    @Resource
    private IContentVsFileDao contentVsFileDao;

    @Override
    public int save(VideoInfo videoInfo) {
        long tcId = IdWorker.instance.getId();
        videoInfo.setUid(tcId);
        videoInfo.setCreateTime(new Date());
        videoInfo.setUpdateTime(new Date());
        ContentVsFileInfo contentVsFileInfo = new ContentVsFileInfo();
        contentVsFileInfo.setContentId(tcId);
        contentVsFileInfo.setFileId(Long.parseLong(videoInfo.getFileId()));
        contentVsFileInfo.setUid(IdWorker.instance.getId());
        contentVsFileInfo.setCreateTime(new Date());
        contentVsFileInfo.setUpdateTime(new Date());
        contentVsFileDao.save(contentVsFileInfo);
        return videoDao.save(videoInfo);

    }

    @Override
    public BasePageInfo<VideoInfo> queryBasePageInfo(BaseSearchInfo<VideoInfo> baseSearchInfo) {
        return null;
    }

    @Override
    public VideoInfo view(long uid) {
        VideoInfo videoInfo = videoDao.view(uid);
        String imageUrl = fileDao.queryFileUrlByContentId(uid);
        videoInfo.setImageUrl(imageUrl);

        return videoInfo;
    }

    @Override
    public BasePageInfo<VideoInfo> queryBasePageInfo(HttpServletRequest request) {
        BasePageInfo<VideoInfo> basePageInfo = new BasePageInfo<>();
        String pageIndex = request.getParameter("pageIndex");
        BaseSearchInfo<VideoInfo> baseSearchInfo = new BaseSearchInfo<>();
        baseSearchInfo.setPageIndex(StringUtils.isBlank(pageIndex) ? 0 : (Integer.parseInt(pageIndex) - 1) * baseSearchInfo.getPageSize());

        int totalCount = videoDao.queryTotalCount(baseSearchInfo.getT());
        List<VideoInfo> videoInfos = videoDao.queryPage(baseSearchInfo);
        for (VideoInfo videoInfo : videoInfos) {
            String imageUrl = fileDao.queryFileUrlByContentId(videoInfo.getUid());
            videoInfo.setImageUrl(imageUrl);
        }
        basePageInfo.setData(videoInfos);
        basePageInfo.setTotalCount(totalCount);
        basePageInfo.setPageIndex(Integer.parseInt(pageIndex));
        return basePageInfo;
    }
}
