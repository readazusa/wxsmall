import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.junit.Test;

/**
 * Created by 念梓  on 2017/2/23.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class Jetest {


    @Test
    public void testJet(){


        //加密工具
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //加密配置
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        //自己在用的时候更改此密码
        config.setPassword("tangtang");
        //应用配置
        encryptor.setConfig(config);
        String plaintext="lovety";
        //加密
        String ciphertext=encryptor.encrypt(plaintext);
//         String desc = encryptor.decrypt("6vC3Q9j+U0YGsr/jVmsfpMAeSnumiH88/C2RbP2eQuC+fa7S4w65PbshpHJacerpuJigD+9aIVWEPEg/zwSS8843OPeBx1Y1zp+HZaIYAhgrrvJbg+objPsyW481ZUenIbHkDjSVEmnCbaZVXUijyQ==");
//        System.out.println("des:  "+ desc);
        System.out.println(plaintext + " : " + ciphertext);
    }
}
