package club.lovety.wx.application.file.service.impl;

import club.lovety.wx.application.file.entity.FileInfo;
import club.lovety.wx.application.file.service.IFileService;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Service
public class FileServiceImpl implements IFileService {

    @Override
    public int upload(HttpServletRequest request) {
        MultipartRequest multipartRequest = (MultipartRequest) request;




        return 0;
    }

    @Override
    public int save(FileInfo fileInfo) {
        return 0;
    }

    @Override
    public BasePageInfo<FileInfo> queryBasePageInfo(BaseSearchInfo<FileInfo> baseSearchInfo) {
        return null;
    }
}
