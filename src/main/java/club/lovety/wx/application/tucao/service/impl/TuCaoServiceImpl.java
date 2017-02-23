package club.lovety.wx.application.tucao.service.impl;

import club.lovety.wx.application.contentvsfile.dao.IContentVsFileDao;
import club.lovety.wx.application.contentvsfile.entity.ContentVsFileInfo;
import club.lovety.wx.application.tucao.dao.ITuCaoDao;
import club.lovety.wx.application.tucao.entity.TuCaoInfo;
import club.lovety.wx.application.tucao.service.ITuCaoService;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import club.lovety.wx.common.IdWorker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(TuCaoInfo tuCaoInfo) {
        long tcId = IdWorker.instance.getId();
        tuCaoInfo.setUid(tcId);
        tuCaoInfo.setCreateTime(new Date());
        tuCaoInfo.setUpdateTime(new Date());
        List<ContentVsFileInfo> contentVsFileInfos = getContentVsFileInfos(tcId, tuCaoInfo.getFileId());
        contentVsFileDao.batchSave(contentVsFileInfos);
        return tuCaoDao.save(tuCaoInfo);
    }


    private List<ContentVsFileInfo> getContentVsFileInfos(long contentId, String fileId) {
        List<ContentVsFileInfo> contentVsFileInfos = new ArrayList<>();
        String[] fileIds = fileId.split("&");
        for (int index = 0; index < fileIds.length; index++) {
            ContentVsFileInfo contentVsFileInfo = new ContentVsFileInfo();
            contentVsFileInfo.setCreateTime(new Date());
            contentVsFileInfo.setUid(IdWorker.instance.getId());
            contentVsFileInfo.setFileId(Integer.parseInt(fileIds[index]));
            contentVsFileInfo.setContentId(contentId);
            contentVsFileInfo.setUpdateTime(new Date());
            contentVsFileInfos.add(contentVsFileInfo);
        }
        return contentVsFileInfos;
    }


    @Override
    public BasePageInfo<TuCaoInfo> queryBasePageInfo(BaseSearchInfo<TuCaoInfo> baseSearchInfo) {
        BasePageInfo<TuCaoInfo> basePageInfo = new BasePageInfo<>();
        basePageInfo.setPageIndex(baseSearchInfo.getPageIndex());
        int totalCount = tuCaoDao.queryTotalCount(baseSearchInfo.getT());
        List<TuCaoInfo> tuCaoInfos = tuCaoDao.queryList(baseSearchInfo);
        basePageInfo.setData(tuCaoInfos);
        basePageInfo.setData(tuCaoInfos);
        return basePageInfo;
    }
}
