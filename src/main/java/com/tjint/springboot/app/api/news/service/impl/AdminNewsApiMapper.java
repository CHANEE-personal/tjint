package com.tjint.springboot.app.api.news.service.impl;

import com.tjint.springboot.app.admin.news.service.NewsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminNewsApiMapper {
    List<NewsVo> getNewsList() throws Exception;
}
