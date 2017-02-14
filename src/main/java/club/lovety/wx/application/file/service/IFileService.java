package club.lovety.wx.application.file.service;

import club.lovety.wx.application.file.entity.FileInfo;
import club.lovety.wx.base.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public interface IFileService extends IService<FileInfo> {

    public int upload(HttpServletRequest request);

}