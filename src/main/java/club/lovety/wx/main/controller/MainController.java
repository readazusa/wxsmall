package club.lovety.wx.main.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 念梓  on 2017/1/12.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@RestController
@RequestMapping("main")
public class MainController {
    private static final Logger log = LogManager.getLogger(MainController.class);


    @RequestMapping(value = "init", method = RequestMethod.GET)
    public String init(HttpServletRequest request, ModelMap model) {
        String signature = request.getParameter("signature");   //验证
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        log.debug("signature:[{}],timestamp:[{}],nonce:[{}],echostr:[{}]", signature, timestamp, nonce, echostr);
        model.put("echostr", echostr);
        return "echostr";
    }


}
