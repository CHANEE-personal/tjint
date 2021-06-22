package com.tjint.springboot.app.api.news.service.impl;

import com.tjint.springboot.app.api.news.service.NewNewsDTO;
import org.apache.ibatis.annotations.Mapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdminNewsApiMapper {
    /**
     * <pre>
     * 1. MethodName : getNewsListCnt
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
    public List<NewNewsDTO> getNewsList(Map<String, Object> searchMap) throws Exception;

    /**
     * <pre>
     * 1. MethodName : addNews
     * 2. ClassName  : AdminNewsApiMapper.java
     * 3. Comment    : News 등록
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 08.
     * </pre>
     *
     * @param newNewsDTO
     * @return
     * @throws Exception
     */
    @Transactional
    public Integer addNews(NewNewsDTO newNewsDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : updateNews
     * 2. ClassName  : AdminNewsApiMapper.java
     * 3. Comment    : News 수정
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 22.
     * </pre>
     *
     * @param newNewsDTO
     * @return
     * @throws Exception
     */
    @Transactional
    public Integer updateNews(NewNewsDTO newNewsDTO) throws Exception;

    /**
     * <pre>
     * 1. MethodName : getNewsInfo
     * 2. ClassName  : AdminNewsApiMapper.java
     * 3. Comment    : News 상세 페이지 조회
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 17.
     * </pre>
     *
     * @param newNewsDTO
     * @return
     * @throws Exception
     */
    public Map<String, Object> getNewsInfo(NewNewsDTO newNewsDTO) throws Exception;
}
