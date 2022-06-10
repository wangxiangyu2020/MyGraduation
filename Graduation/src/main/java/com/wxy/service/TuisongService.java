package com.wxy.service;

import com.wxy.dao.TuisongDao;
import com.wxy.pojo.Tuisong;

public interface TuisongService {

    Tuisong queryName(String username);
    void insertText(Tuisong tuisong);
}

