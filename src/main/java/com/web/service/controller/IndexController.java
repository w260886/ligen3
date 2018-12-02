package com.web.service.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class IndexController extends BaseController {
    public String index(Model model, HttpServletResponse response) {
        try{
            model.addAttribute("name", "simonsfan");
            log.info("TestBootController getUser info");
            return "";
        }catch (Exception e){
            e.printStackTrace();
            log.error("cuowu!");
            return "";
        }
    }

}
