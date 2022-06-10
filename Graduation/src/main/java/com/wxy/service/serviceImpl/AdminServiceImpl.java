package com.wxy.service.serviceImpl;

import com.wxy.dao.AdminDao;
import com.wxy.pojo.Admin;
import com.wxy.pojo.Leave;
import com.wxy.pojo.Message;
import com.wxy.pojo.User;
import com.wxy.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminDao adminDao;

    @Override
    public Admin queryAll() {
        return adminDao.queryAll();
    }

    @Override
    public Admin queryByAdminName(String name,String pwd) {
        Admin admin = adminDao.queryByAdminName(name);
        if (!(StringUtils.isEmpty(admin)) && pwd.equals(admin.getA_pwd())){
            return admin;
        }
        return null;
    }

    @Override
    public List<User> queryUserAll() {
        return adminDao.queryUserAll();
    }

    @Override
    public List<Message> queryMsgAll() {
        return adminDao.queryMsgAll();
    }

    @Override
    public List<Leave> queryLeaAll() {
        return adminDao.queryLeaAll();
    }

    @Override
    public User queryUserLike(String name) {
        return adminDao.queryUserLike(name);
    }

    @Override
    public int upUser(User user) {
        return adminDao.upUser(user);
    }

    @Override
    public int delUser(int id) {
        return adminDao.delUser(id);
    }

    @Override
    public List<Leave> queryLeaLike(Leave leave) {
        return adminDao.queryLeaLike(leave);
    }

    @Override
    public List<Message> queryMsgLike(Message message) {
        return adminDao.queryMsgLike(message);
    }

    @Override
    public Leave queryLeaById(int id) {
        return adminDao.queryLeaById(id);
    }

    @Override
    public Message queryMsgById(int id) {
        return adminDao.queryMsgById(id);
    }

    @Override
    public int delLea(int id) {
        return adminDao.delLea(id);
    }

    @Override
    public int delMsg(int id) {
        return adminDao.delMsg(id);
    }
}
