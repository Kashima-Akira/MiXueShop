package com.xzy.mapper;

import com.xzy.pojo.Activity;

public interface ActivityMapper {
    void insertActivity(Activity activity);
    void deleteActivity(Integer id);
    void updateActivity(Integer id);
   Activity selectActivity(Integer id);
}
