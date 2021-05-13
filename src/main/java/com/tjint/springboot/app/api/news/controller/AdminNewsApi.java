package com.tjint.springboot.app.api.news.controller;

import com.tjint.springboot.app.admin.news.service.NewsVo;
import com.tjint.springboot.app.api.news.service.AdminNewsApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/news")
@RestController
@RequiredArgsConstructor
@Api(tags = "News관리관련 API")
public class AdminNewsApi {

    private final AdminNewsApiService adminNewsApiService;

    @ApiOperation(value = "News관련조회", notes = "News를 조회한다.")
    @GetMapping(value = "/newsList")
    public List<NewsVo> getNewsList() throws Exception
    {
        List<NewsVo> newsList = this.adminNewsApiService.getNewsList();

        return newsList;
    }
}
