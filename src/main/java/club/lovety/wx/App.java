package club.lovety.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class App{
    public static void main( String[] args ) {
        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.run(args);
    }
}
