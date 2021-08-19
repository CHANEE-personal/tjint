package com.tjint.springboot.app.api.front.news.service.impl;

import com.tjint.springboot.app.api.front.news.service.FrontNewsApiService;
import com.tjint.springboot.app.api.admin.news.service.NewNewsDTO;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
    public ConcurrentHashMap<String, Object> frontNewsInfo(NewNewsDTO newNewsDTO) throws Exception {

        ConcurrentHashMap<String, Object> newsMap = new ConcurrentHashMap<>();

        Integer newsSeq = newNewsDTO.getNewsSeq();

        Integer prevIdx = this.frontNewsApiMapper.frontNewsPrevIdx(newsSeq);
        // 이전 글 상세 조회
        if(prevIdx != null) {
            newsMap.put("prevIdx", prevIdx);
            newNewsDTO.setNewsSeq(prevIdx);
            newsMap.put("newsPrevInfo", this.frontNewsApiMapper.frontNewsInfo(newNewsDTO));
        }

        Integer nextIdx = this.frontNewsApiMapper.frontNewsNextIdx(newsSeq);
        // 다음 글 상세 조회
        if(nextIdx != null) {
            newsMap.put("nextIdx", nextIdx);
            newNewsDTO.setNewsSeq(nextIdx);
            newsMap.put("newsNextInfo", this.frontNewsApiMapper.frontNewsInfo(newNewsDTO));
        }

        newNewsDTO.setNewsSeq(newsSeq);

        // 뉴스 상세 조회
        newsMap.put("newsInfo", this.frontNewsApiMapper.frontNewsInfo(newNewsDTO));

        return newsMap;
    }

    /**
     * <pre>
     * 1. MethodName : frontSnsLinkList
     * 2. ClassName  : FrontNewsApiServiceImpl.java
     * 3. Comment    : News SNS Link 조회
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 30.
     * </pre>
     *
     * @param newsSeq
     * @return
     * @throws Exception
     */
    public List<NewUrlLinkDTO> frontSnsLinkList(Integer newsSeq) throws Exception {
        return frontNewsApiMapper.frontSnsLinkList(newsSeq);
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
     * @param newsSeq
     * @return
     * @throws Exception
     */
    public Integer frontNewsNextIdx(Integer newsSeq) throws Exception {
        return frontNewsApiMapper.frontNewsNextIdx(newsSeq);
    }
}
