package com.tjint.springboot.common.urlLink.service.impl;

import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UrlLinkMapper {

    public String addUrlLink(NewUrlLinkDTO newUrlLinkDTO) throws Exception;
}
