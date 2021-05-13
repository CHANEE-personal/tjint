package com.tjint.springboot.app.api.news.service.impl;

import com.tjint.springboot.app.admin.news.service.NewsVo;
import com.tjint.springboot.app.api.news.service.AdminNewsApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminNewsApiService")
@RequiredArgsConstructor
public class AdminNewsApiServiceImpl implements AdminNewsApiService {

    private final AdminNewsApiMapper adminNewsApiMapper;
    /**
     * @package : com.tjint.springboot.app.admin.news.service.impl
     * @method : AdminNewsApiServiceImpl
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : news 리스트 조회
     **/
    public List<NewsVo> getNewsList() throws Exception
    {
        return adminNewsApiMapper.getNewsList();
    }
}
