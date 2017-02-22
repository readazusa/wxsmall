package club.lovety.wx.application.file.service;

import club.lovety.wx.application.file.entity.FileInfo;
import club.lovety.wx.base.service.IService;
import club.lovety.wx.common.MyHttpException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface IFileService extends IService<FileInfo> {

    public FileInfo upload(HttpServletRequest request) throws IOException, MyHttpException;

}
