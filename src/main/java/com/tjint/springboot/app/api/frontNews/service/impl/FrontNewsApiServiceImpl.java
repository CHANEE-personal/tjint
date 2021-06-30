package com.tjint.springboot.app.api.frontNews.service.impl;

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
     * 2. ClassName  : FrontNewsApiServiceImpl.java
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
     * 2. ClassName  : FrontNewsApiServiceImpl.java
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

    /**
     * <pre>
     * 1. MethodName : frontNewsInfo
     * 2. ClassName  : FrontNewsApiServiceImpl.java
     * 3. Comment    : News 상세
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param newNewsDTO
     * @return
     * @throws Exception
     */
    public Map<String, Object> frontNewsInfo(NewNewsDTO newNewsDTO) throws Exception {
        return frontNewsApiMapper.frontNewsInfo(newNewsDTO);
    }

    /**
     * <pre>
     * 1. MethodName : frontNewsPrevIdx
     * 2. ClassName  : FrontNewsApiServiceImpl.java
     * 3. Comment    : 이전 idx 조회
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param newsSeq
     * @return
     * @throws Exception
     */
    public Integer frontNewsPrevIdx(Integer newsSeq) throws Exception {
        return frontNewsApiMapper.frontNewsPrevIdx(newsSeq);
    }

    /**
     * <pre>
     * 1. MethodName : frontNewsPrevIdx
     * 2. ClassName  : FrontNewsApiServiceImpl.java
     * 3. Comment    : 다음 idx 조회
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param idxMap
     * @return
     * @throws Exception
     */
    public Integer frontNewsNextIdx(Integer newsSeq) throws Exception {
        return frontNewsApiMapper.frontNewsNextIdx(newsSeq);
    }
}
