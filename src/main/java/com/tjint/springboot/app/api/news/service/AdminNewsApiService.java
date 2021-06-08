package com.tjint.springboot.app.api.news.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AdminNewsApiService {

    /**
     * <pre>
     * 1. MethodName : addBrand
     * 2. ClassName  : AdminNewsApiService.java
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
     * 1. MethodName : addBrand
     * 2. ClassName  : AdminNewsApiService.java
     * 3. Comment    : News 리스트
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 08.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public List<NewNewsDTO> getNewsList(Map<String, Object> searchMap) throws Exception;
}
