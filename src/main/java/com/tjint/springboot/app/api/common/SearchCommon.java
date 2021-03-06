package com.tjint.springboot.app.api.common;

import com.tjint.springboot.app.api.admin.login.service.impl.AdminLoginApiMapper;
import com.tjint.springboot.common.NewCommonDTO;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@RequiredArgsConstructor
public class SearchCommon {

	private final AdminLoginApiMapper adminLoginApiMapper;

	/**
	 * <pre>
	 * 1. MethodName : searchCommon
	 * 2. ClassName  : SearchCommon.java
	 * 3. Comment    : 페이징 및 검색 조건 공통
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 08. 08.
	 * </pre>
	 *
	 * @param  page
	 * @param  searchKeyword
	 * @return ConcurrentHashMap
	 * @throws Exception
	 */
	public ConcurrentHashMap<String, Object> searchCommon(Page page, String searchKeyword) {

		ConcurrentHashMap<String, Object> searchMap = new ConcurrentHashMap<>();

		// 페이징 처리
		Integer pageCnt = StringUtil.getInt(page.getPage(), 1);
		Integer pageSize = StringUtil.getInt(page.getSize(), 10);
		page.setPage(pageCnt);
		page.setSize(pageSize);

		// 검색 조건
		searchMap.put("searchKeyword", StringUtil.getString(searchKeyword, ""));
		searchMap.put("startPage", page.getStartPage());
		searchMap.put("size", pageSize);

		return searchMap;
	}

	/**
	 * <pre>
	 * 1. MethodName : giveAuth
	 * 2. ClassName  : SearchCommon.java
	 * 3. Comment    : jwt 인증자
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 08. 08.
	 * </pre>
	 *
	 * @param  request
	 * @return ConcurrentHashMap
	 * @throws Exception
	 */
	public void giveAuth(HttpServletRequest request, NewCommonDTO newCommonDTO) throws Exception {
		// creator, updater 공통 DTO

		// JWT token 값 존재 시 유저 인증 값 부여
		if(request.getHeader("Authorization") != null) {
			String userSeq = adminLoginApiMapper.selectAdminSeq(StringUtil.getString(request.getHeader("Authorization"),""));
			newCommonDTO.setCreator(StringUtil.getInt(userSeq, 0));
			newCommonDTO.setUpdater(StringUtil.getInt(userSeq, 0));
		}
	}
}
