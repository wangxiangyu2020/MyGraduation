package com.wxy.dao;

import com.wxy.pojo.Admin;
import com.wxy.pojo.Leave;
import com.wxy.pojo.Message;
import com.wxy.pojo.User;

import java.util.List;

public interface AdminDao {
    /**
     * 查询管理员
     * @return
     */
    Admin queryAll();

    /**
     * 根据名字查询对象
     * @param name
     * @return
     */
    Admin queryByAdminName(String name);

    /**
     * 查询所有用户
     * @return
     */
    List<User> queryUserAll();

    /**
     * 查询所有资讯
     * @return
     */
    List<Message> queryMsgAll();

    /**
     * 查询所有留言s
     * @return
     */
    List<Leave> queryLeaAll();

    /**
     * 搜索用户信息
     * @param name
     * @return
     */
    User queryUserLike(String name);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int upUser(User user);

    /**
     * 根据Id删除用户
     * @param id
     * @return
     */
    int delUser(int id);

    /**
     * 搜索留言信息
     * @param leave
     * @return
     */
    List<Leave> queryLeaLike(Leave leave);

    /**
     *
     * @param message
     * @return
     */
    List<Message> queryMsgLike(Message message);

    /**
     * 根据Id查询留言s
     * @param id
     * @return
     */
    Leave queryLeaById(int id);

    /**
     * 根据Id查询资讯
     * @param id
     * @return
     */
    Message queryMsgById(int id);

    /**
     * 删除留言
     * @param id
     * @return
     */
    int delLea(int id);

    /**
     * 删除资讯
     * @param id
     * @return
     */
    int delMsg(int id);
}
