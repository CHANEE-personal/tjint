package com.tjint.springboot.common.urlLink.service.impl;

import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface UrlLinkMapper {

    @Transactional
    Integer addUrlLink(NewUrlLinkDTO newUrlLinkDTO) throws Exception;

    @Transactional
    Integer updateUrlLink(NewUrlLinkDTO newUrlLinkDTO) throws Exception;

}
