package com.wxy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxy.pojo.Leave;
import com.wxy.pojo.Message;
import com.wxy.pojo.User;
import com.wxy.service.LeaveService;
import com.wxy.service.MessageService;
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
public class BlogController {

    @Resource
    private MessageService messageService;

    @Resource
    private LeaveService leaveService;

    @Resource
    private UserService userService;

    @RequestMapping("/search")
    public String Search(@RequestParam(required = false, defaultValue = "1",value = "pn")int pn,
                         String word,
                         Model model){
        Message message = new Message();
        message.setM_title(word);
        PageHelper.startPage(pn,3);
        List<Message> messages = messageService.queryMessageByLike(message);
        PageInfo<Message> pageInfo = new PageInfo<>(messages, 3);
        model.addAttribute("pageInfo",pageInfo);
        return "blog/calmlog-list";
    }

    @RequestMapping("/toDetails/{id}")
    public String toMessage(@PathVariable("id")int id,Model model){
        int views = messageService.queryViews(id);
        Message upViews = new Message();
        upViews.setM_id(id);
        upViews.setM_views(++views);
        messageService.updateViews(upViews);
        int count = leaveService.count(id);
        Message message = messageService.queryMessageById(id);
        List<Leave> leave = leaveService.queryLeaveByM_id(id);
        model.addAttribute("count",count);
        model.addAttribute("leave",leave);
        model.addAttribute("message",message);
        return "blog/calmlog-details";
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false,
                        defaultValue = "1",value = "pn")int pn,
                        Model model){
        PageHelper.startPage(pn,3);
        List<Message> message = messageService.queryAll();
        PageInfo<Message> pageInfo = new PageInfo<>(message, 3);
        model.addAttribute("pageInfo",pageInfo);
        return "blog/calmlog-index";
    }

    @GetMapping("/list")
    public String toList(){
        return "blog/calmlog-list";
    }

    @GetMapping("/toRelease")
    public String toRelease(){
        return "blog/release";
    }

    @GetMapping("/release")
    public String release(HttpSession session,Message message,Model model){
        if (!(StringUtils.isEmpty(message.getM_title())) && !(StringUtils.isEmpty(message.getM_content()))){
            User user =(User) session.getAttribute("user");
            message.setU_id(user.getU_id());
            message.setU_name(user.getU_name());
            message.setM_views(0);
            int i = messageService.addMsg(message);
            return "redirect:/";
        }
        String rMsg = "标题和内容都不能为空喔!";
        model.addAttribute("rMsg",rMsg);
        return "blog/release";
    }

}
