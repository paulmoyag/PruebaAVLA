package venta;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
//@EnableAutoConfiguration
public class Venta {

    public static void main(String[] args){
        SpringApplication.run(Venta.class, args);
    }

}
