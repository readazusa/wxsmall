package club.lovety.wx.util;


import java.util.UUID;

/**
 * Created by smc on 2015/11/19.
 */
public class UuidUtils {

    public static String getUpperUuid(){
        return getUuid().toUpperCase();
    }


    public static  String getUuid(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

}
