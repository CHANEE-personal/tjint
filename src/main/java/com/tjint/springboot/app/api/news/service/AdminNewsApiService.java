package com.tjint.springboot.app.api.news.service;

import com.tjint.springboot.app.admin.news.service.NewsVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminNewsApiService {
    /**
     * @package : com.tjint.springboot.app.admin.news.service
     * @method : AdminNewsApiService
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : news 리스트 조회
     **/
    public List<NewsVo> getNewsList() throws Exception;
}
