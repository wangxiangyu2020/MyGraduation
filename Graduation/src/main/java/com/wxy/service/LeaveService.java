package com.wxy.service;

import com.wxy.pojo.Leave;

import java.util.List;

public interface LeaveService {

    /**
     * 添加留言
     * @param leave
     * @return
     */
    int addLeave(Leave leave);

    /**
     * 根据文章id查留言
     * @param id
     * @return
     */
    List<Leave> queryLeaveByM_id(int id);

    /**
     * 评论人数
     * @param id
     * @return
     */
    int count(int id);
}
