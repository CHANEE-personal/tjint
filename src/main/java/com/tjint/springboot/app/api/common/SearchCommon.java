package com.tjint.springboot.app.api.common;

import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.utils.StringUtil;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class SearchCommon {

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
}
