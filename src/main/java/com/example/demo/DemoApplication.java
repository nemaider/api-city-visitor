package com.example.demo;

import com.example.demo.model.Monument;
import com.example.demo.repository.MonumentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


//    @Bean
//    CommandLineRunner runner(MonumentRepository repository){
//        return args -> {
//            Monument monument = new Monument(
//                    "name",
//                    "info",
//                    2.5
//            );
//
//            repository.insert(monument);
//        };
//    }

}
