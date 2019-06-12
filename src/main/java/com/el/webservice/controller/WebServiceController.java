package com.el.webservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: roman.zhang
 * @Date: 2019/5/31 9:29
 * @Version:V1.0
 * @Description:WebServiceController
 */
@RestController("/api")
public class WebServiceController {

    @RequestMapping("/hello")
    public String hello(){
        return "hell word";
    }
}
