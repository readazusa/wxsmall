package club.lovety.wx.application.file.dao;

import club.lovety.wx.application.file.entity.FileInfo;
import club.lovety.wx.base.dao.IDao;

import java.util.List;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface IFileDao extends IDao<FileInfo> {


    public List<FileInfo> queryFileByContentId(long contentId);
}
