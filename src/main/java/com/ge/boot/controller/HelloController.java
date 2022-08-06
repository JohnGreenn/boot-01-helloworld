package com.ge.boot.controller;


import com.ge.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }


    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name) {
        return "hello, spring boot2"+"你好：" +name;
    }
}
