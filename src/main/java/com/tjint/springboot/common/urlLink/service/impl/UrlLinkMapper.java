package com.tjint.springboot.common.urlLink.service.impl;

import com.tjint.springboot.common.urlLink.service.UrlLinkVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UrlLinkMapper {
    List<UrlLinkVo> selectUrlLinkList(UrlLinkVo paramUrlLinkVo) throws Exception;
}
