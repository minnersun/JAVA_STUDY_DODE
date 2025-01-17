package xdclass_websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


//springboot启动类
@ComponentScan(basePackages="xdclass_websocket")
@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String [] args){
		SpringApplication.run(Application.class);
	}
	
	
}
