package com.wxy.service;

import com.wxy.pojo.Leave;
import com.wxy.pojo.Message;
import com.wxy.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据用户名查询对象
     * @param name
     * @return
     */
    User queryUserByName(String name,String pwd);

    /**
     * 根据Id查对象
     * @param id
     * @return
     */
    User queryUserById(int id);

    /**
     * 查询用户的所有资讯
     * @param id
     * @return
     */
    List<Message> queryMsgByUserId(int id);

    /**
     * 查询用户所有留言
     * @param id
     * @return
     */
    List<Leave> queryLeaByUserId(int id);

    /**
     * 根据Id修改用户信息
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * 根据Id删除资讯
     * @param id
     * @return
     */
    int delMsg(int id);

    /**
     * 根据Id删除留言
     * @param id
     * @return
     */
    int delLea(int id);

    /**
     * 修改密码
     * @param user
     * @return
     */
    int upPwd(User user);
}
