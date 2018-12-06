package com.web.service.controller;

import com.web.service.entity.NewsInfo;
import com.web.service.serivce.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController extends BaseController{
    @Autowired
    private NewsService newsService;

    @RequestMapping("/itemsPage")
    @ResponseBody
    public Map itemsPage(HttpServletRequest request) {
        try {
            Integer currentPage = Integer.valueOf(request.getParameter("currentPage"));
            Integer pageNum = Integer.valueOf(request.getParameter("pageNum")==null?"1":request.getParameter("pageNum"));
            Integer pageSize = Integer.valueOf(request.getParameter("pageSize")==null?"10":request.getParameter("pageSize"));

            return newsService.getList(currentPage, pageSize, pageNum) ;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            log.info("失败");
            return null;
        }
    }

}
