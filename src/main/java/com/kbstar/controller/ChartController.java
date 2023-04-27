package com.kbstar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller



@RequestMapping("/chart")
public class ChartController {

    String dir = "chart/";

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    //로그기록 사용 선언
    // http://127.0.0.1/chart
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }

    @RequestMapping("/chart01")
    public String map01(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"chart01");
        return "index";
    }

    @RequestMapping("/chart02")
    public String map02(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"chart02");
        return "index";
    }
    @RequestMapping("/chart03")
    public String map03(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"chart03");
        return "index";
    }
    @RequestMapping("/chart04")
    public String map04(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"chart04");
        return "index";
    }
    @RequestMapping("/chart05")
    public String map05(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"chart05");
        return "index";
    }
}
