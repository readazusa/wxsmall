package club.lovety.wx.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 念梓  on 2017/2/22.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Component
@ConfigurationProperties( prefix = "jdbc",locations={"classpath:config/db.properties","classpath:config/test.properties"})
public class InitConfig {

    private String url;

    public String getUrl() {
        return url+"123213";
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
