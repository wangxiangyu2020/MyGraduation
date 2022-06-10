package com.wxy.dao;

import com.wxy.pojo.Message;

import java.util.List;

public interface MessageDao {

    /**
     * 查询浏览数
     * @param id
     * @return
     */
    int queryViews(int id);

    /**
     * 浏览数自增
     * @param message
     * @return
     */
    int updateViews(Message message);
    /**
     * 查询所有资讯
     * @return
     */
    List<Message> queryAll();

    /**
     * 根据Id查询资讯
     * @param id
     * @return
     */
    Message queryMessageById(int id);

    /**
     * 迷糊查询
     * @return
     */
    List<Message> queryMessageByLike(Message message);

    /**
     * 添加文章
     * @param message
     * @return
     */
    int addMsg(Message message);
}
