package com.tjint.springboot.app.api.news.service.impl;

import com.tjint.springboot.app.api.news.service.NewNewsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminNewsApiMapper {
    /**
     * <pre>
     * 1. MethodName : getNewsList
     * 2. ClassName  : AdminNewsApiMapper.java
     * 3. Comment    : News 리스트 갯수
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 08.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public Integer getNewsListCnt(Map<String, Object> searchMap) throws Exception;
    /**
     * <pre>
     * 1. MethodName : getNewsList
     * 2. ClassName  : AdminNewsApiMapper.java
     * 3. Comment    : News 리스트
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 08.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    List<NewNewsDTO> getNewsList(Map<String, Object> searchMap) throws Exception;
}
