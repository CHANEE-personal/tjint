package com.tjint.springboot.app.api.recruit.service.impl;

import com.tjint.springboot.app.api.recruit.service.AdminRecruitApiService;
import com.tjint.springboot.app.api.recruit.service.NewRecruitDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("AdminRecruitApiService")
@RequiredArgsConstructor
public class AdminRecruitApiServiceImpl implements AdminRecruitApiService {

	private final AdminRecruitApiMapper adminRecruitApiMapper;

	/**
	 * <pre>
	 * 1. MethodName : getRecruitListCnt
	 * 2. ClassName  : AdminRecruitApiServiceImpl.java
	 * 3. Comment    : 채용공고 리스트 갯수
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	public Integer getRecruitListCnt(Map<String, Object> searchMap) throws Exception {
		return this.adminRecruitApiMapper.getRecruitListCnt(searchMap);
	}

	/**
	 * <pre>
	 * 1. MethodName : getRecruitList
	 * 2. ClassName  : AdminRecruitApiServiceImpl.java
	 * 3. Comment    : 채용공고 리스트
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	public List<NewRecruitDTO> getRecruitList(Map<String, Object> searchMap) throws Exception {
		return this.adminRecruitApiMapper.getRecruitList(searchMap);
	}

	/**
	 * <pre>
	 * 1. MethodName : getRecruitInfo
	 * 2. ClassName  : AdminRecruitApiServiceImpl.java
	 * 3. Comment    : 채용공고 상세
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param newRecruitDTO
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getRecruitInfo(NewRecruitDTO newRecruitDTO) throws Exception {
		return adminRecruitApiMapper.getRecruitInfo(newRecruitDTO);
	}

	/**
	 * <pre>
	 * 1. MethodName : addRecruit
	 * 2. ClassName  : AdminRecruitApiServiceImpl.java
	 * 3. Comment    : 채용공고 등록
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 23.
	 * </pre>
	 *
	 * @param newRecruitDTO
	 * @return
	 * @throws Exception
	 */
	public String addRecruit(NewRecruitDTO newRecruitDTO) throws Exception {

		if(this.adminRecruitApiMapper.addRecruit(newRecruitDTO) > 0) {
			return "Y";
		} else {
			return "N";
		}
	}
}
