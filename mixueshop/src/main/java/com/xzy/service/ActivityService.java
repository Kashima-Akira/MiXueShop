package com.xzy.service;

import com.xzy.pojo.Activity;

public interface ActivityService {
    void add(Activity activity);
    Activity find(Integer id);
}
