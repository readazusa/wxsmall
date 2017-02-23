package club.lovety.wx.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 念梓  on 2017/2/23.
 * Email:sunmch@163.com
 * author: 念梓
 * des:加解密数据库的链接信息
 */
@Component
@ConfigurationProperties(prefix = "jdbc",locations = "classpath:config/db.properties")
public class DbConfig {

    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

    EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();

    public  DbConfig(){
        config.setAlgorithm("PBEWithMD5AndDES");
        //自己在用的时候更改此密码
        config.setPassword("tangtang");
        //应用配置
        encryptor.setConfig(config);
    }

    private String url;

    private String username;

    private String password;

    private String driver;

    public String getUrl() {
        return encryptor.decrypt(url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return encryptor.decrypt(username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return encryptor.decrypt(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
