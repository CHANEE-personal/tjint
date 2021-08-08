package com.tjint.springboot.app.api.brand.controller;

import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.app.api.brand.service.NewCodeDTO;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.rmi.ServerError;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequestMapping(value = "/api/sns/")
@RestController
@RequiredArgsConstructor
@Api(tags = "SNS관리관련 API")
public class adminSnsApi {

	private final AdminBrandApiService adminBrandApiService;

	@ApiOperation(value = "SNS 등록", notes = "SNS를 등록한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PostMapping
	public String addSns(NewCodeDTO newCodeDTO,
						 @RequestParam(value = "fileName") MultipartFile files) throws Exception {
		String result = "";

		if(this.adminBrandApiService.addSns(newCodeDTO, files) > 0) {
			result = "Y";
		} else {
			result = "N";
		}

		return result;
	}

	@ApiOperation(value = "SNS 조회", notes = "SNS를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/lists")
	public ConcurrentHashMap<String, Object> snsList(@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
									   Page page) throws Exception {
		ConcurrentHashMap<String, Object> snsMap = new ConcurrentHashMap<>();
		ConcurrentHashMap<String, Object> searchMap = new ConcurrentHashMap<>();

		Integer pageCnt = StringUtil.getInt(page.getPage(), 1);
		Integer pageSize = StringUtil.getInt(page.getSize(), 10);
		page.setPage(pageCnt);
		page.setSize(pageSize);

		searchMap.put("searchKeyword", StringUtil.getString(searchKeyword, ""));
		searchMap.put("startPage", page.getStartPage());
		searchMap.put("size", pageSize);
		searchMap.put("parentCd", "lnkt002");

		Integer snsListCnt = this.adminBrandApiService.getCategoryListCnt(searchMap);
		List<NewCodeDTO> snsList = null;

		if(snsListCnt > 0) {
			snsList = this.adminBrandApiService.getCategoryList(searchMap);
		}

		// 리스트 수
		snsMap.put("pageSize", page.getSize());
		// 전체 페이지 수
		snsMap.put("perPageListCnt", Math.ceil((snsListCnt - 1) / page.getSize() + 1));
		// 전체 아이템 수
		snsMap.put("snsListTotalCnt", snsListCnt);

		snsMap.put("snsList", snsList);

		return snsMap;
	}
}
