package club.lovety.wx.application.file.controller;

import club.lovety.wx.application.file.service.IFileService;
import club.lovety.wx.base.controller.BaseController;
import club.lovety.wx.common.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2017/2/14.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RestController
@RequestMapping("file")
public class FileController extends BaseController {

    @Resource
    private IFileService fileService;

    @RequestMapping("upload")
    public Object uploadFile(HttpServletRequest request){
        Result result = new Result();
        try{
            fileService.upload(request);
        }catch (Exception ex){

        }
        return result;
    }


}
