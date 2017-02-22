package club.lovety.wx.application.file.controller;

import club.lovety.wx.application.file.entity.FileInfo;
import club.lovety.wx.application.file.service.IFileService;
import club.lovety.wx.base.controller.BaseController;
import club.lovety.wx.common.Constants;
import club.lovety.wx.common.MyHttpException;
import club.lovety.wx.common.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RestController
@RequestMapping("file")
public class FileController extends BaseController {

    private static final Logger log = LogManager.getLogger(FileController.class);

    @Resource
    private IFileService fileService;

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Object uploadFile(HttpServletRequest request) {
        Result result = new Result();
        try {
            FileInfo fileInfo = fileService.upload(request);
            result.setObj(fileInfo);
        } catch (IOException e) {
            log.error("上传文件失败,失败信息如下： ", e);
            result.setCode(Constants.UPLOAD_FILE_IO_ERROR_CODE);
            result.setMsg(e.getMessage());
        } catch (MyHttpException e) {
            log.error("上传文件调用文件服务器错误: ", e);
            result.setCode(Constants.UPLOAD_FILE_HTTP_ERROR_CODE);
            result.setMsg(e.getMessage());
        }
        return result;
    }


}
