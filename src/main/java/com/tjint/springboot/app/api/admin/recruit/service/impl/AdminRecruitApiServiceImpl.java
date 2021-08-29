package com.tjint.springboot.app.api.admin.recruit.service.impl;

import com.tjint.springboot.app.api.admin.recruit.service.AdminRecruitApiService;
import com.tjint.springboot.app.api.admin.recruit.service.NewRecruitDTO;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import com.tjint.springboot.common.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
	public ConcurrentHashMap<String, Object> getRecruitInfo(NewRecruitDTO newRecruitDTO, NewUrlLinkDTO newUrlLinkDTO) throws Exception {

		ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

		List<NewUrlLinkDTO> urlLinkList = null;

		newUrlLinkDTO.setBoardTypeCd("brdt003");
		newUrlLinkDTO.setBoardSeq(newRecruitDTO.getRecruitSeq());
		urlLinkList = this.adminRecruitApiMapper.getRecruitLinkList(newUrlLinkDTO);

		resultMap.put("recruitInfo", this.adminRecruitApiMapper.getRecruitInfo(newRecruitDTO));
		resultMap.put("urlLinkList", urlLinkList);

		return resultMap;
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
	public String addRecruit(NewRecruitDTO newRecruitDTO, HttpServletRequest request) throws Exception {

		//채용사이트 구분
		String result = "";
		NewUrlLinkDTO newUrlLinkDTO = new NewUrlLinkDTO();

		Map<String, Object> recruitMap = new HashMap<>();
		Map<String, Object> urlMap;

		// JWT token 값 존재 시 유저 인증 값 부여
		if(request.getHeader("Authorization") != null) {
			newRecruitDTO.setCreator(1);
			newRecruitDTO.setUpdater(1);
		}

		if(this.adminRecruitApiMapper.insertRecruitInfo(newRecruitDTO) > 0) {
			String[] snsArr = newRecruitDTO.getJobsValues().split(",");
			for(int i = 0; i < snsArr.length; i++) {
				// 채용 url 조회
				recruitMap.put("codeId", snsArr[i]);

				urlMap = this.adminRecruitApiMapper.getRecruitUrlInfo(recruitMap);

				newUrlLinkDTO.setBoardTypeCd("brdt003");
				newUrlLinkDTO.setLinkTypeCd(snsArr[i]);
				newUrlLinkDTO.setBoardSeq(newRecruitDTO.getRecruitSeq());
				newUrlLinkDTO.setLinkAddress(StringUtil.getString(urlMap.get("property1"),""));
				newUrlLinkDTO.setSortOrder(i);
				newUrlLinkDTO.setVisible("Y");
				newUrlLinkDTO.setCreator(1);
				newUrlLinkDTO.setUpdater(1);

				if(this.adminRecruitApiMapper.addRecruitUrlLink(newUrlLinkDTO) > 0) {
					result = "Y";
				} else {
					result = "N";
				}
			}
		} else {
			result = "N";
		}

		return result;
	}
}
