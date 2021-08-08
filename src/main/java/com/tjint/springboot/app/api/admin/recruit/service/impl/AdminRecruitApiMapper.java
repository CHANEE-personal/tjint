package com.tjint.springboot.app.api.admin.recruit.service.impl;

import com.tjint.springboot.app.api.admin.recruit.service.NewRecruitDTO;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import org.apache.ibatis.annotations.Mapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Mapper
public interface AdminRecruitApiMapper {

	/**
	 * <pre>
	 * 1. MethodName : getRecruitListCnt
	 * 2. ClassName  : AdminRecruitApiMapper.java
	 * 3. Comment    : 채용공고 리스트 갯수
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	Integer getRecruitListCnt (Map<String, Object> searchMap) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : getRecruitList
	 * 2. ClassName  : AdminRecruitApiMapper.java
	 * 3. Comment    : 채용공고 리스트
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	List<NewRecruitDTO> getRecruitList(Map<String, Object> searchMap) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : getRecruitInfo
	 * 2. ClassName  : AdminRecruitApiMapper.java
	 * 3. Comment    : 채용공고 상세
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param newRecruitDTO
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getRecruitInfo(NewRecruitDTO newRecruitDTO) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : insertRecruitInfo
	 * 2. ClassName  : AdminRecruitApiMapper.java
	 * 3. Comment    : 채용공고 등록
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param newRecruitDTO
	 * @return
	 * @throws Exception
	 */
	@Transactional
	Integer insertRecruitInfo(NewRecruitDTO newRecruitDTO) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : getRecruitLinkList
	 * 2. ClassName  : AdminRecruitApiMapper.java
	 * 3. Comment    : 채용공고 URL 조회
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param newUrlLinkDTO
	 * @return
	 * @throws Exception
	 */
	List<NewUrlLinkDTO> getRecruitLinkList(NewUrlLinkDTO newUrlLinkDTO) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : addRecruitUrlLink
	 * 2. ClassName  : AdminRecruitApiMapper.java
	 * 3. Comment    : 채용공고 URL 등록
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 30.
	 * </pre>
	 *
	 * @param newUrlLinkDTO
	 * @return
	 * @throws Exception
	 */
	@Transactional
	Integer addRecruitUrlLink(NewUrlLinkDTO newUrlLinkDTO) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : getRecruitUrlInfo
	 * 2. ClassName  : AdminRecruitApiMapper.java
	 * 3. Comment    : 채용 URL 조회
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 30.
	 * </pre>
	 *
	 * @param recruitMap
	 * @return
	 * @throws Exception
	 */
	ConcurrentHashMap<String, Object> getRecruitUrlInfo(Map<String, Object> recruitMap) throws Exception;
}
