package com.kbstar.controller;

import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/item")          //라우터 생성 같은건가..
public class ItemController {

//    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
//    로그기록 사용 선언

    @Autowired
    ItemService service;
    String dir = "item/";

    //127.0.0.1/item
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"add");
        return "index";
    }

    @RequestMapping("/all")
    public String all(Model model){

        List<Item> list = new ArrayList<>();
        list.add(new Item(100,"사탕",1000,"a.jpg",new Date()));
        list.add(new Item(101,"초코릿",2000,"b.jpg",new Date()));
        list.add(new Item(102,"아스크림",3000,"c.jpg",new Date()));
        list.add(new Item(103,"호떡",4000,"d.jpg",new Date()));
        list.add(new Item(104,"커피",5000,"e.jpg",new Date()));
        model.addAttribute("allitem", list);

        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"all");
        return "index";
    }

    @RequestMapping("/allDB")
    public String allDB(Model model){
        List<Item> list = null;
        try{
            list = service.get();
            log.info("success");
        }catch(Exception e){
            log.info("Error");
            e.printStackTrace();
        }
        model.addAttribute("allitem", list);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"allDB");
        return "index";
    }
}
