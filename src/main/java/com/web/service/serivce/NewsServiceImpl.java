package com.web.service.serivce;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.web.service.common.PageBean;
import com.web.service.dao.NewsInfoMapper;
import com.web.service.entity.NewsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsInfoMapper newsInfoMapper;

    public Map getList(int currentPage,int pageNum, int pageSize)  {
        //使用分页插件,核心代码就这一行
        try {
            Map<String, Object> data = new HashMap<>();
            Page page =PageHelper.startPage(pageNum, pageSize);
            // 获取
            List<NewsInfo> news=newsInfoMapper.queryNewsList();
            data.put("total", page.getTotal());
            data.put("nowPage", pageNum);
            data.put("data", news);
//            Integer count = newsInfoMapper.queryNewsCount();
//            PageBean<NewsInfo> pageData = new PageBean<>(currentPage, pageSize, count);
//            pageData.setItems(news);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
