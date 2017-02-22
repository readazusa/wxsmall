import club.lovety.wx.common.Constants;
import club.lovety.wx.util.HttpUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 念梓  on 2017/2/22.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class HttpFileTest {

    public static final Logger log = LogManager.getLogger(HttpFileTest.class);


    @Test
    public void testUpload(){
        log.error("测试邮件");
//        Map<String,InputStream> map = new HashMap<>();
//        File file = new File("F:"+File.separator+"bg.png");
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            map.put(Constants.UPLOAD_FILE_NAME,fileInputStream);
////            String result = HttpUtils.getInstance().postFormInputstream("http://127.0.0.1:5000/webfileservice/api/upload",map,"png");
//            String result = HttpUtils.getInstance().postFormInputstream(Constants.FILE_SERVICE_URL,map,"png");
//            System.out.println("result: "+ result);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
