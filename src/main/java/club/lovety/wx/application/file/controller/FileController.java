package club.lovety.wx.application.file.controller;

import club.lovety.wx.base.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("upload")
    public Object uploadFile(HttpServletRequest request){
        return null;
    }


}
