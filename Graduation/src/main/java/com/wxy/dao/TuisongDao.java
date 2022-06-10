package com.wxy.dao;

import com.wxy.pojo.Tuisong;

public interface TuisongDao {

    Tuisong queryName(String username);

    void insertText(Tuisong tuisong);
}
