package com.wxy.service.serviceImpl;

import com.wxy.dao.TuisongDao;
import com.wxy.pojo.Tuisong;
import com.wxy.service.TuisongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuisongServiceImpl implements TuisongService {

    @Autowired
    TuisongDao tuisongDao;

    @Override
    public Tuisong queryName(String username) {
        return (Tuisong) tuisongDao.queryName(username);
    }

    @Override
    public void insertText(Tuisong tuisong) {
        tuisongDao.insertText(tuisong);
    }
}
