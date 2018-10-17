package com.xzy.controller;

import com.xzy.pojo.Activity;
import com.xzy.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("showActivity")
    public List<Activity> show(){
        List list=new ArrayList();
        Activity activity=activityService.find(1);
        list.add(activity);

        return  list;
    }
}
