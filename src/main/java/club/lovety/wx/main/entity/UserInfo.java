package club.lovety.wx.main.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 念梓  on 2017/1/16.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@XmlRootElement
public class UserInfo {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
