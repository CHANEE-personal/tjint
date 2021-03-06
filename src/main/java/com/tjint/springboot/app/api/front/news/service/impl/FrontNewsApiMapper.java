package com.tjint.springboot.app.api.front.news.service.impl;

import com.tjint.springboot.app.api.admin.news.service.NewNewsDTO;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FrontNewsApiMapper {
    /**
     * <pre>
     * 1. MethodName : frontNewsListCnt
     * 2. ClassName  : FrontNewsApiMapper.java
     * 3. Comment    : News 리스트 갯수
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 29.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    Integer frontNewsListCnt(Map<String, Object> searchMap) throws Exception;

    /**
     * <pre>
     * 1. MethodName : frontNewsList
     * 2. ClassName  : FrontNewsApiMapper.java
     * 3. Comment    : News 리스트
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 29.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    List<NewNewsDTO> frontNewsList(Map<String, Object> searchMap) throws Exception;

    /**
     * <pre>
     * 1. MethodName : frontNewsInfo
     * 2. ClassName  : FrontNewsApiMapper.java
     * 3. Comment    : News 상세
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param newNewsDTO
     * @return
     * @throws Exception
     */
    Map<String, Object> frontNewsInfo(NewNewsDTO newNewsDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : frontSnsLinkList
     * 2. ClassName  : FrontNewsApiMapper.java
     * 3. Comment    : News SNS Link 조회
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param newsSeq
     * @return
     * @throws Exception
     */
    List<NewUrlLinkDTO> frontSnsLinkList(Integer newsSeq) throws Exception;

    /**
     * <pre>
     * 1. MethodName : frontNewsPrevIdx
     * 2. ClassName  : FrontNewsApiMapper.java
     * 3. Comment    : 이전 idx 조회
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param newsSeq
     * @return
     * @throws Exception
     */
    Integer frontNewsPrevIdx(Integer newsSeq) throws Exception;

    /**
     * <pre>
     * 1. MethodName : frontNewsNextIdx
     * 2. ClassName  : FrontNewsApiMapper.java
     * 3. Comment    : 다음 idx 조회
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param newsSeq
     * @return
     * @throws Exception
     */
    Integer frontNewsNextIdx(Integer newsSeq) throws Exception;
}
