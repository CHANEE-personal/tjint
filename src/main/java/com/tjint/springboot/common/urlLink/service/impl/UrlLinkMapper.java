package com.tjint.springboot.common.urlLink.service.impl;

import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Repository
public interface UrlLinkMapper {

    /**
     * <pre>
     * 1. MethodName : addUrlLink
     * 2. ClassName  : UrlLinkMapper.java
     * 3. Comment    : 링크 저장
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 03.
     * </pre>
     *
     * @param newUrlLinkDTO
     * @return
     * @throws Exception
     */
    @Transactional
    Integer addUrlLink(NewUrlLinkDTO newUrlLinkDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : updateUrlLink
     * 2. ClassName  : UrlLinkMapper.java
     * 3. Comment    : 링크 수정
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 03.
     * </pre>
     *
     * @param newUrlLinkDTO
     * @return
     * @throws Exception
     */
    @Transactional
    Integer updateUrlLink(NewUrlLinkDTO newUrlLinkDTO) throws Exception;

}
