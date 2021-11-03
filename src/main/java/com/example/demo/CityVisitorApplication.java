package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CityVisitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityVisitorApplication.class, args);
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
