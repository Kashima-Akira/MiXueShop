package com.xzy.service.serviceImp;

import com.xzy.mapper.ActivityMapper;
import com.xzy.pojo.Activity;
import com.xzy.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;

public class ActivityServiceImp implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public void add(Activity activity) {
        activityMapper.insertActivity(activity);
    }

    @Override
    public Activity find(Integer id) {
        return activityMapper.selectActivity(id);
    }
}
