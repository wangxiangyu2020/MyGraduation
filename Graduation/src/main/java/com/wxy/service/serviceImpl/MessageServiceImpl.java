package com.wxy.service.serviceImpl;

import com.wxy.dao.MessageDao;
import com.wxy.pojo.Message;
import com.wxy.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    MessageDao messageDao;

    @Override
    public List<Message >queryAll() {
        return messageDao.queryAll();
    }

    @Override
    public Message queryMessageById(int id) {
        Message message = messageDao.queryMessageById(id);
        return message;
    }

    @Override
    public List<Message> queryMessageByLike(Message message) {
        return messageDao.queryMessageByLike(message);
    }

    @Override
    public int addMsg(Message message) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String format = ft.format(new Date());
        message.setM_time(format);
        return messageDao.addMsg(message);
    }

    @Override
    public int queryViews(int id) {
        return messageDao.queryViews(id);
    }

    @Override
    public int updateViews(Message message) {
        return messageDao.updateViews(message);
    }
}
