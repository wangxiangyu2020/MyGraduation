package com.wxy.controller;

import com.wxy.pojo.Admin;
import com.wxy.pojo.Leave;
import com.wxy.pojo.Message;
import com.wxy.pojo.User;
import com.wxy.service.AdminService;
import com.wxy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private UserService userService;

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "admin/index";
    }

    @RequestMapping("/toUser")
    public String toUserInfo(Model model) {
        List<User> users = adminService.queryUserAll();
        model.addAttribute("users",users);
        return "/admin/userInfo";
    }

    @RequestMapping("/toMessage")
    public String toMessageInfo(Model model) {
        List<Message> messages = adminService.queryMsgAll();
        model.addAttribute("message",messages);
        return "/admin/messageInfo";
    }

    @RequestMapping("/toLeave")
    public String toLeaveInfo(Model model) {
        List<Leave> leaves = adminService.queryLeaAll();
        model.addAttribute("leave",leaves);
        return "/admin/leaveInfo";
    }

    @RequestMapping("/toUserFile")
    public String toUserFile(@RequestParam("name")String name, Model model) {
        User user = adminService.queryUserLike(name);
        if (StringUtils.isEmpty(user)){
            String fileInfo = "查询不到相关用户的信息";
            model.addAttribute("fileInfo",fileInfo);
        }else {
            model.addAttribute("user",user);
        }
        return "/admin/userProfile";
    }

    @RequestMapping("/toUpUser/{id}")
    public String toUpUser(@PathVariable("id")int id,Model model){
        User user = userService.queryUserById(id);
        System.out.println(user);
        model.addAttribute("user",user);
        return "admin/upUser";
    }

    @RequestMapping("/upUser")
    public String upUser(User user){
        int i = adminService.upUser(user);
        return  "redirect:/toUser";
    }

    @RequestMapping("/delUser/{id}")
    public String delUser(@PathVariable("id")int id){
        int i = adminService.delUser(id);
        return  "redirect:/toUser";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser() {
        return "admin/addUser";
    }


    @RequestMapping("/addUser")
    public String addUser(HttpSession session,User user) {
        Admin admin =(Admin) session.getAttribute("admin");
        user.setA_id(admin.getA_id());
        int i = userService.addUser(user);
        return "redirect:/toUser";
    }

    @RequestMapping("/toM_Info")
    public String toM_Info(String word,Model model) {
        Message message = new Message();
        message.setU_name(word);
        List<Message> messages = adminService.queryMsgLike(message);
        model.addAttribute("message",messages);
        return "/admin/M_Info";
    }

    @RequestMapping("/dlMsg/{id}")
    public String delMsg(@PathVariable("id")int id){
        int i = adminService.delMsg(id);
        return "redirect:/toMessage";
    }

    @RequestMapping("/toL_Info")
    public String toL_Info(String word,Model model){
        Leave leave = new Leave();
        leave.setU_name(word);
        List<Leave> leaves = adminService.queryLeaLike(leave);
        model.addAttribute("leave",leaves);
        return "/admin/L_Info";
    }

    @RequestMapping("/toM_UpInfo")
    public String toM_UpInfo() {
        return "/admin/M_UpInfo";
    }

    @RequestMapping("/toL_UpInfo/{id}")
    public String toL_UpInfo(@PathVariable("id")int id,Model model) {
        Leave leave = adminService.queryLeaById(id);
        model.addAttribute("leave",leave);
        return "/admin/L_UpInfo";
    }

    @RequestMapping("/dLea/{id}")
    public String delLea(@PathVariable("id") int id){
        int i = adminService.delLea(id);
        return "redirect:/toLeave";
    }

    @RequestMapping("/adminIn")
    public String login(){
        return "/admin/login";
    }

    @GetMapping("/adminOut")
    public String logout(){
        return "redirect:/adminIn";
    }

    @RequestMapping("/toAdInfo")
    public String toAdminInfo(){
        return "admin/AdminInfo";
    }

}
