package com.wxy.controller;

import com.wxy.pojo.Leave;
import com.wxy.pojo.User;
import com.wxy.service.LeaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LeaveController {

    @Resource
    private LeaveService leaveService;

    @RequestMapping("/leave/{id}")
    public String leave(@PathVariable("id")int id, String content,
                         HttpSession session){
        User user =(User) session.getAttribute("user");
        Leave leave = new Leave();
        leave.setM_id(id);
        leave.setU_name(user.getU_name());
        leave.setU_id(user.getU_id());
        leave.setL_content(content);
        int i = leaveService.addLeave(leave);
        return "redirect:/toDetails/{id}";
    }
}
