package com.tjint.springboot.app.api.frontNews.service.impl;

import com.tjint.springboot.app.api.frontNews.controller.FrontNewsApi;
import com.tjint.springboot.app.api.frontNews.service.FrontNewsApiService;
import com.tjint.springboot.app.api.news.service.NewNewsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("FrontNewsApiService")
@RequiredArgsConstructor
public class FrontNewsApiServiceImpl implements FrontNewsApiService {

    private final FrontNewsApiMapper frontNewsApiMapper;

    /**
     * <pre>
     * 1. MethodName : frontNewsListCnt
     * 2. ClassName  : FrontNewsApiService.java
     * 3. Comment    : News 리스트 갯수
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 29.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public Integer frontNewsListCnt(Map<String, Object> searchMap) throws Exception {
        return frontNewsApiMapper.frontNewsListCnt(searchMap);
    }

    /**
     * <pre>
     * 1. MethodName : frontNewsList
     * 2. ClassName  : FrontNewsApiService.java
     * 3. Comment    : News 리스트
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 29.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public List<NewNewsDTO> frontNewsList(Map<String, Object> searchMap) throws Exception {
        return frontNewsApiMapper.frontNewsList(searchMap);
    }

}
