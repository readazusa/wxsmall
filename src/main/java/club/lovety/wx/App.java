package club.lovety.wx;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class App{
    private static  final Logger log = LogManager.getLogger(App.class);
    public static void main( String[] args ) {
        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.run(args);
    }
}
