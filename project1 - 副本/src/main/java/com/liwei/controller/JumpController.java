package com.liwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JumpController {
    @GetMapping("/index")
    public String indexJump(){
        return "Public_page/index";
    }

    @GetMapping("/Public_page/signin")
    public String signinJump(){
        return "Public_page/signin";
    }

    @GetMapping("/signin")
    public String SsigninJump(){
        return "Public_page/signin";
    }

    @GetMapping("/Private_page/contact")
    public String contactJump(){
        return "Private_page/contact";
    }

    @GetMapping("/Private_page/codes")
    public String codesJump(){
        return "Private_page/codes";
    }

    @GetMapping("/Private_page/gallery")
    public String galleryJump(){
        return "Private_page/gallery";
    }

    @GetMapping("/Private_page/about")
    public String aboutJump(){
        return "Private_page/about";
    }


    @GetMapping("/Public_page/index")
    public String index1Jump(){
        return "Public_page/index";
    }
}
