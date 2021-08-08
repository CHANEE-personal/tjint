package com.tjint.springboot.app.api.admin.recruit.service;

import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public interface AdminRecruitApiService {

	/**
	 * <pre>
	 * 1. MethodName : getRecruitListCnt
	 * 2. ClassName  : AdminRecruitApiService.java
	 * 3. Comment    : 채용공고 리스트 갯수
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	Integer getRecruitListCnt(Map<String, Object> searchMap) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : getRecruitList
	 * 2. ClassName  : AdminRecruitApiService.java
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
	 * 2. ClassName  : AdminRecruitApiService.java
	 * 3. Comment    : 채용공고 상세
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param newRecruitDTO
	 * @return
	 * @throws Exception
	 */
	ConcurrentHashMap<String, Object> getRecruitInfo(NewRecruitDTO newRecruitDTO, NewUrlLinkDTO newUrlLinkDTO) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : addRecruit
	 * 2. ClassName  : AdminRecruitApiService.java
	 * 3. Comment    : 채용공고 등록
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param newRecruitDTO
	 * @return
	 * @throws Exception
	 */
	String addRecruit(NewRecruitDTO newRecruitDTO) throws Exception;
}
