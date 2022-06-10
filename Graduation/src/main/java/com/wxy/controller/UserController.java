package com.wxy.controller;

import com.wxy.pojo.Admin;
import com.wxy.pojo.Leave;
import com.wxy.pojo.Message;
import com.wxy.pojo.User;
import com.wxy.service.AdminService;
import com.wxy.service.MessageService;
import com.wxy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private AdminService adminService;

    @Resource
    private MessageService messageService;

    @RequestMapping("/register")
    public String register(User user,HttpSession session){
        int i = userService.addUser(user);
        if (i==0){
            String rgMsg = "用户已存在!";
            session.setAttribute("rgMsg",rgMsg);
        }
        return "user/login";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "user/login";
    }

    @RequestMapping("/login")
    public String login(String name, String pwd, HttpSession session){
        if ("admin".equals(name)){
            Admin admin = adminService.queryByAdminName(name,pwd);
            if (StringUtils.isEmpty(admin)){
                String rgMsg = "用户不存在或密码错误!";
                session.setAttribute("rgMsg",rgMsg);
                return "user/login";
            }
            session.setAttribute("name",name);
            session.setAttribute("admin",admin);
            return "admin/index";
        }else{
            User user = userService.queryUserByName(name, pwd);
            if (StringUtils.isEmpty(user)){
                String rgMsg = "用户不存在或密码错误!";
                session.setAttribute("rgMsg",rgMsg);
                return "user/login";
            }
            session.setAttribute("name",name);
            session.setAttribute("user",user);
            return "redirect:/";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "user/login";
    }

    @RequestMapping("/getUserInfo")
    public String UserInfo(HttpSession session,Model model){
        User userSession = (User)session.getAttribute("user");
        User user = userService.queryUserById(userSession.getU_id());
        List<Message> messages = userService.queryMsgByUserId(userSession.getU_id());
       if (messages.size()==0){
           String nu = "没有信息！";
           model.addAttribute("gMsg",nu);
       }
        model.addAttribute("message",messages);
        model.addAttribute("user",user);
        return "user/userInfo";
    }

    @RequestMapping("/toUpInfo")
    public String upInfo(HttpSession session,Model model){
        User userSession = (User)session.getAttribute("user");
        User user = userService.queryUserById(userSession.getU_id());
        model.addAttribute("user",user);
        return "user/upUserInfo";
    }

    @RequestMapping("/UpInfo")
    public String upInfo(User user,HttpSession session){
        int i = userService.updateUserById(user);
        if (i>0){
            User userById = userService.queryUserById(user.getU_id());
            User userSession =(User) session.getAttribute("user");
            if (!userById.getU_pwd().equals(userSession.getU_pwd())){
                String rgMsg = "密码已过期!";
                session.setAttribute("rgMsg",rgMsg);
                return "user/login";
            }
        }
        return "redirect:/getUserInfo";
    }

    @RequestMapping("/u_leave")
    public String leave(HttpSession session,Model model){
        User user =(User) session.getAttribute("user");
        List<Leave> leaves = userService.queryLeaByUserId(user.getU_id());
        model.addAttribute("leave",leaves);
        return "user/leave";
    }

    @RequestMapping("/u_message")
    public String message(HttpSession session,Model model){
        User user =(User) session.getAttribute("user");
        List<Message> messages = userService.queryMsgByUserId(user.getU_id());
        model.addAttribute("message",messages);
        return "user/message";
    }

    @RequestMapping("/delMsg/{id}")
    public String delMsg(@PathVariable("id")int id){
        int i = userService.delMsg(id);
        return "redirect:/u_message";
    }

    @RequestMapping("/delLea/{id}")
    public String delLea(@PathVariable("id")int id){
        int i = userService.delLea(id);
        return "redirect:/u_leave";
    }

}
