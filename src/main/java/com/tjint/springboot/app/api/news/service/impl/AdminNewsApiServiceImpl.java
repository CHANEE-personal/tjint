package com.tjint.springboot.app.api.news.service.impl;

import com.tjint.springboot.app.api.news.service.AdminNewsApiService;
import com.tjint.springboot.app.api.news.service.NewNewsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("AdminNewsApiService")
@RequiredArgsConstructor
public class AdminNewsApiServiceImpl implements AdminNewsApiService {

    private final AdminNewsApiMapper adminNewsApiMapper;

    /**
     * <pre>
     * 1. MethodName : getNewsListCnt
     * 2. ClassName  : AdminNewsApiServiceImpl.java
     * 3. Comment    : News 리스트 갯수
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 08.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public Integer getNewsListCnt(Map<String, Object> searchMap) throws Exception {
        return adminNewsApiMapper.getNewsListCnt(searchMap);
    }


    /**
     * <pre>
     * 1. MethodName : getNewsList
     * 2. ClassName  : AdminNewsApiServiceImpl.java
     * 3. Comment    : News 리스트
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 08.
     * </pre>
     *
     * @param searchMap
     * @return
     * @throws Exception
     */
    public List<NewNewsDTO> getNewsList(Map<String, Object> searchMap) throws Exception
    {
        return adminNewsApiMapper.getNewsList(searchMap);
    }
}
