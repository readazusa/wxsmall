package club.lovety.wx.application.contentvsfile.service.impl;

import club.lovety.wx.application.contentvsfile.dao.IContentVsFileDao;
import club.lovety.wx.application.contentvsfile.entity.ContentVsFileInfo;
import club.lovety.wx.application.contentvsfile.service.IContentVsFileService;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 念梓  on 2017/2/22.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Service
public class ContentVsFileServiceImpl implements IContentVsFileService {


    @Resource
    private IContentVsFileDao contentVsFileDao;

    @Override
    public int save(ContentVsFileInfo contentVsFileInfo) {
        return contentVsFileDao.save(contentVsFileInfo);
    }

    @Override
    public BasePageInfo<ContentVsFileInfo> queryBasePageInfo(BaseSearchInfo<ContentVsFileInfo> baseSearchInfo) {
        return null;
    }
}
