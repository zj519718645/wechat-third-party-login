package cn.artisan;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;




@SpringBootApplication
public class SpringBootWebApplication {

    public static void main(String[] args) {
        // http://localhost:8080/
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}