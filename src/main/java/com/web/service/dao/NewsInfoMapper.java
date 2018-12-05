package com.web.service.dao;

import com.web.service.entity.NewsInfo;

import java.util.List;
import java.util.Map;

public interface NewsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsInfo record);

    int insertSelective(NewsInfo record);

    NewsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsInfo record);

    int updateByPrimaryKeyWithBLOBs(NewsInfo record);

    int updateByPrimaryKey(NewsInfo record);

    List<NewsInfo> queryNewsList();

    Integer queryNewsCount();
}