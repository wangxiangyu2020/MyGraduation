package com.wxy.service.serviceImpl;

import com.wxy.dao.AdminDao;
import com.wxy.dao.UserDao;
import com.wxy.pojo.Admin;
import com.wxy.pojo.Leave;
import com.wxy.pojo.Message;
import com.wxy.pojo.User;
import com.wxy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Resource
    AdminDao adminDao;

    @Override
    public int addUser(User user) {
        Admin admin = adminDao.queryAll();
        user.setA_id(admin.getA_id());
        user.setU_sex(1);
        User userByName = userDao.queryUserByName(user.getU_name());
        if (StringUtils.isEmpty(userByName)){
            return userDao.addUser(user);
        }
        return 0;
    }

    @Override
    public User queryUserByName(String name,String pwd){
        User user = userDao.queryUserByName(name);
        if (!(StringUtils.isEmpty(user)) && pwd.equals(user.getU_pwd())){
            return user;
        }
        return null;
    }

    @Override
    public User queryUserById(int id) {
        User user = userDao.queryUserById(id);
        return user;
    }

    @Override
    public List<Message> queryMsgByUserId(int id) {
        return userDao.queryMsgByUserId(id);
    }

    @Override
    public List<Leave> queryLeaByUserId(int id) {
        return userDao.queryLeaByUserId(id);
    }

    @Override
    public int updateUserById(User user) {
        int i = userDao.updateUserById(user);
        return i;
    }

    @Override
    public int delMsg(int id) {
        return userDao.delMsg(id);
    }

    @Override
    public int delLea(int id) {
        return userDao.delLea(id);
    }

    @Override
    public int upPwd(User user) {
        return userDao.upPwd(user);
    }
}
