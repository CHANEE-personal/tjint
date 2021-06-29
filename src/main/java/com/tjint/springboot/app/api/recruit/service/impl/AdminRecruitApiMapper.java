package com.tjint.springboot.app.api.recruit.service.impl;

import com.tjint.springboot.app.api.recruit.service.NewRecruitDTO;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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
	public Integer getRecruitListCnt (Map<String, Object> searchMap) throws Exception;

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
	public List<NewRecruitDTO> getRecruitList(Map<String, Object> searchMap) throws Exception;

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
	public Map<String, Object> getRecruitInfo(NewRecruitDTO newRecruitDTO) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : addRecruit
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
	public Integer addRecruit(NewRecruitDTO newRecruitDTO) throws Exception;

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
	public List<NewUrlLinkDTO> getRecruitLinkList(NewUrlLinkDTO newUrlLinkDTO) throws Exception;
}
