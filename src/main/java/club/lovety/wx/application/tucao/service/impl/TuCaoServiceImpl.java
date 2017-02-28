package club.lovety.wx.application.tucao.service.impl;

import club.lovety.wx.application.contentvsfile.dao.IContentVsFileDao;
import club.lovety.wx.application.contentvsfile.entity.ContentVsFileInfo;
import club.lovety.wx.application.file.dao.IFileDao;
import club.lovety.wx.application.tucao.dao.ITuCaoDao;
import club.lovety.wx.application.tucao.entity.TuCaoInfo;
import club.lovety.wx.application.tucao.service.ITuCaoService;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import club.lovety.wx.common.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Service
public class TuCaoServiceImpl implements ITuCaoService {

    @Resource
    private ITuCaoDao tuCaoDao;

    @Resource
    private IContentVsFileDao contentVsFileDao;

    @Resource
    private IFileDao fileDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(TuCaoInfo tuCaoInfo) {
        long tcId = IdWorker.instance.getId();
        tuCaoInfo.setUid(tcId);
        tuCaoInfo.setCreateTime(new Date());
        tuCaoInfo.setUpdateTime(new Date());
        List<ContentVsFileInfo> contentVsFileInfos = getContentVsFileInfos(tcId, tuCaoInfo.getFileId());
        if (contentVsFileInfos.size() > 0) {
            contentVsFileDao.batchSave(contentVsFileInfos);
        }
        return tuCaoDao.save(tuCaoInfo);
    }


    private List<ContentVsFileInfo> getContentVsFileInfos(long contentId, String fileId) {
        List<ContentVsFileInfo> contentVsFileInfos = new ArrayList<>();
        if (StringUtils.isNotBlank(fileId)) {
            String[] fileIds = fileId.split("&");
            for (int index = 0; index < fileIds.length; index++) {
                ContentVsFileInfo contentVsFileInfo = new ContentVsFileInfo();
                contentVsFileInfo.setCreateTime(new Date());
                contentVsFileInfo.setUid(IdWorker.instance.getId());
                contentVsFileInfo.setFileId(Long.parseLong(fileIds[index]));
                contentVsFileInfo.setContentId(contentId);
                contentVsFileInfo.setUpdateTime(new Date());
                contentVsFileInfos.add(contentVsFileInfo);
            }
        }
        return contentVsFileInfos;
    }

    @Override
    public BasePageInfo<TuCaoInfo> queryBasePageInfo(BaseSearchInfo<TuCaoInfo> baseSearchInfo) {
        BasePageInfo<TuCaoInfo> basePageInfo = new BasePageInfo<>();
        basePageInfo.setPageIndex(baseSearchInfo.getPageIndex());
        int totalCount = tuCaoDao.queryTotalCount(baseSearchInfo.getT());
        List<TuCaoInfo> tuCaoInfos = tuCaoDao.queryPage(baseSearchInfo);
        basePageInfo.setData(tuCaoInfos);
        return basePageInfo;
    }


    @Override
    public BasePageInfo<TuCaoInfo> queryBasePageInfo(HttpServletRequest request) {
        BasePageInfo<TuCaoInfo> basePageInfo = new BasePageInfo<>();
        String pageIndex = request.getParameter("pageIndex");
        BaseSearchInfo<TuCaoInfo> baseSearchInfo = new BaseSearchInfo<>();
        baseSearchInfo.setPageIndex(StringUtils.isBlank(pageIndex) ? 0: (Integer.parseInt(pageIndex) - 1) * baseSearchInfo.getPageSize());

        int totalCount = tuCaoDao.queryTotalCount(baseSearchInfo.getT());
        List<TuCaoInfo> tuCaoInfos = tuCaoDao.queryPage(baseSearchInfo);
        for (TuCaoInfo tuCaoInfo : tuCaoInfos) {
            List<String> imageUrls = fileDao.queryFileByContentId(tuCaoInfo.getUid());
            tuCaoInfo.setFileUrls(imageUrls);
            tuCaoInfo.setFileUrlSize(imageUrls.size());
        }
        basePageInfo.setData(tuCaoInfos);
        basePageInfo.setTotalCount(totalCount);
        basePageInfo.setPageIndex(Integer.parseInt(pageIndex));
        return basePageInfo;
    }

    @Override
    public TuCaoInfo view(long uid) {
        TuCaoInfo tuCaoInfo = tuCaoDao.view(uid);
        List<String> imageUrls = fileDao.queryFileByContentId(uid);
        tuCaoInfo.setFileUrls(imageUrls);
        return tuCaoInfo;
    }
}
