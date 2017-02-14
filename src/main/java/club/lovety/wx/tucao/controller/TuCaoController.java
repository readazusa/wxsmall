package club.lovety.wx.tucao.controller;

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
@RequestMapping("tucao")
public class TuCaoController {

    @RequestMapping("page")
    public Object  page(HttpServletRequest request){
        return null;
    }

    @RequestMapping("add")
    public Object doAdd(HttpServletRequest request){
        return null;
    }




}
