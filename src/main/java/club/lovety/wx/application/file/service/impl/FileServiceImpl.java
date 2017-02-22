package club.lovety.wx.application.file.service.impl;

import club.lovety.wx.application.file.dao.IFileDao;
import club.lovety.wx.application.file.entity.FileInfo;
import club.lovety.wx.application.file.service.IFileService;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import club.lovety.wx.common.Constants;
import club.lovety.wx.common.IdWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Service
public class FileServiceImpl implements IFileService {

    private static final Logger log = LogManager.getLogger(FileServiceImpl.class);

    @Resource
    private IFileDao fileDao;

    @Override
    public String upload(HttpServletRequest request) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setIp(request.getHeader("x-forwarded-for") == null ? request.getRemoteAddr() : request.getHeader("x-forwarded-for"));
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile(Constants.UPLOAD_FILE_NAME);
        String suffix = getSuffixName(multipartFile.getOriginalFilename());
        try {
            InputStream inputStream = multipartFile.getInputStream();
        } catch (IOException e) {
             log.error("读取上传文件流失败: ",e);
        }
        return null;
    }

    @Override
    public int save(FileInfo fileInfo) {
        return fileDao.save(fileInfo);
    }

    @Override
    public BasePageInfo<FileInfo> queryBasePageInfo(BaseSearchInfo<FileInfo> baseSearchInfo) {
        return null;
    }



    private String getSuffixName(String requestFileName){
        int lastIndex= requestFileName.lastIndexOf(".");
        return requestFileName.substring(lastIndex+1);
    }
}
