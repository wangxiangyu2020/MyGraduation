package com.wxy.service.serviceImpl;

import com.wxy.dao.LeaveDao;
import com.wxy.pojo.Leave;
import com.wxy.service.LeaveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Resource
    LeaveDao leaveDao;

    @Override
    public int addLeave(Leave leave) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String format = ft.format(new Date());
        leave.setL_time(format);
        return leaveDao.addLeave(leave);
    }

    @Override
    public List<Leave> queryLeaveByM_id(int id) {
        return leaveDao.queryLeaveByM_id(id);
    }

    @Override
    public int count(int id) {
        return leaveDao.count(id);
    }
}
