package club.lovety.wx.application.contentvsfile.dao;

import club.lovety.wx.application.contentvsfile.entity.ContentVsFileInfo;
import club.lovety.wx.base.dao.IDao;

import java.util.List;

/**
 * Created by 念梓  on 2017/2/22.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface IContentVsFileDao extends IDao<ContentVsFileInfo> {

    public int batchSave(List<ContentVsFileInfo> contentVsFileInfoList);



}
