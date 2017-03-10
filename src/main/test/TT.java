import java.io.UnsupportedEncodingException;

/**
 * Created by 念梓  on 2017/3/3.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class TT {
    public static byte[] int2Byte(int intValue){
        byte[] b=new byte[4];
        for(int i=0;i<4;i++){
            b[i]=(byte)(intValue>>8*(3-i) & 0xFF);
            System.out.println(Integer.toBinaryString(b[i])+" ");
            System.out.println("test");
            System.out.println(i+" , "+ (b[i]& 0xFF)+" ");
        }
        return b;
    }

    public static void main(String[] args) {

        try {
            byte[] bb = "123213".getBytes("UCS2");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }



    }
