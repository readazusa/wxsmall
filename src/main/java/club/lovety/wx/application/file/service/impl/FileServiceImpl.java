package club.lovety.wx.application.file.service.impl;

import club.lovety.wx.application.file.dao.IFileDao;
import club.lovety.wx.application.file.entity.FileInfo;
import club.lovety.wx.application.file.service.IFileService;
import club.lovety.wx.base.entity.BasePageInfo;
import club.lovety.wx.base.entity.BaseSearchInfo;
import club.lovety.wx.common.Constants;
import club.lovety.wx.common.IdWorker;
import club.lovety.wx.common.MyHttpException;
import club.lovety.wx.common.Result;
import club.lovety.wx.util.HttpUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public FileInfo upload(HttpServletRequest request) throws IOException, MyHttpException {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setUid(IdWorker.instance.getId());
        fileInfo.setIp(request.getHeader("x-forwarded-for") == null ? request.getRemoteAddr() : request.getHeader("x-forwarded-for"));
        fileInfo.setUpdateTime(new Date());
        fileInfo.setCreateTime(new Date());
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile(Constants.UPLOAD_FILE_NAME);
        fileInfo.setContentType(multipartRequest.getContentType());
        fileInfo.setName(multipartFile.getOriginalFilename());
        fileInfo.setSize(multipartFile.getSize());
        String suffix = getSuffixName(multipartFile.getOriginalFilename());
        fileInfo.setSuffix(suffix);
        fileInfo.setTempFilePath(request.getParameter("tempFilePath"));
        InputStream inputStream = multipartFile.getInputStream();
        fileInfo.setUrl(getFileUploadUrl(inputStream, suffix));
        save(fileInfo);
        return fileInfo;
    }

    @Override
    public int save(FileInfo fileInfo) {
        return fileDao.save(fileInfo);
    }

    @Override
    public BasePageInfo<FileInfo> queryBasePageInfo(BaseSearchInfo<FileInfo> baseSearchInfo) {
        return null;
    }


    private String getSuffixName(String requestFileName) {
        int lastIndex = requestFileName.lastIndexOf(".");
        return requestFileName.substring(lastIndex + 1);
    }

    private String getFileUploadUrl(InputStream inputStream, String suffix) throws MyHttpException {
        Result result = null;
        Map<String,InputStream> uploadParam = new HashMap<>();
        uploadParam.put(Constants.UPLOAD_FILE_NAME,inputStream);
        String uploadResult = HttpUtils.getInstance().postFormInputstream(Constants.FILE_SERVICE_URL,uploadParam,suffix);
        if(StringUtils.isBlank(uploadResult)){
            throw new MyHttpException("上传文件失败");
        }else{
            result= JSON.parseObject(uploadResult,Result.class);
        }
        return result.getData().toString();
    }

}
