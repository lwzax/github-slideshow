package com.liwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JumpController {

    @GetMapping("/index")
    public String indexJump(){
        return "index";
    }

    @GetMapping("/authority_page/identify")
    public String identifyJump(){
        return "authority_page/identify";
    }

    @GetMapping("/authority_page/account")
    public String accountJump(){
        return "authority_page/account";
    }

    @GetMapping("/authority_page/system")
    public String systemJump(){
        return "authority_page/system";
    }

    @GetMapping("/signin")
    public String signinJump(){
        return "signin";
    }

    @GetMapping("/grape-page")
    public String grapePageJump(){
        return "grape-page";
    }

    @GetMapping("/wheat-page")
    public String wheatPageJump(){
        return "wheat-page";
    }

    @GetMapping("/fruit-page")
    public String fruitPageJump(){
        return "fruit-page";
    }

    @GetMapping("/rice-page")
    public String ricePageJump(){
        return "rice-page";
    }
}
