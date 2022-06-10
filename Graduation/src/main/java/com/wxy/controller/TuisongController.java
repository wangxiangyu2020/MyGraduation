package com.wxy.controller;

import com.wxy.dao.TuisongDao;
import com.wxy.pojo.Tuisong;
import com.wxy.pojo.User;
import com.wxy.service.TuisongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TuisongController {

    @Autowired
    private TuisongService tuisongService;

    @RequestMapping("/query")
    public String queryName(){
        return "user/tuisong";
    }

    @RequestMapping("/insert")
    public String insert(String text,HttpSession session){
        String name =(String) session.getAttribute("name");
        Tuisong tuisong = new Tuisong();
        tuisong.setUsername(name);
        tuisong.setText(text);
        tuisongService.insertText(tuisong);
        System.out.println(tuisong);
        return "redirect:/";
    }
}
