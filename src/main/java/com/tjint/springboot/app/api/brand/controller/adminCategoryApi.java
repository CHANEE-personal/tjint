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

import java.rmi.ServerError;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequestMapping(value = "/api/category")
@RestController
@RequiredArgsConstructor
@Api(tags = "분야관리관련 API")
public class adminCategoryApi {

	private final AdminBrandApiService adminBrandApiService;

	@ApiOperation(value = "분야 조회", notes = "분야를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/lists")
	@ResponseBody
	public ConcurrentHashMap<String, Object> categoryList(@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
											Page page) throws Exception {
		ConcurrentHashMap<String, Object> categoryMap = new ConcurrentHashMap<>();
		ConcurrentHashMap<String, Object> searchMap = new ConcurrentHashMap<>();

		Integer pageCnt = StringUtil.getInt(page.getPage(), 1);
		Integer pageSize = StringUtil.getInt(page.getSize(), 10);
		page.setPage(pageCnt);
		page.setSize(pageSize);

		searchMap.put("searchKeyword", StringUtil.getString(searchKeyword, ""));
		searchMap.put("startPage", page.getStartPage());
		searchMap.put("size", pageSize);
		searchMap.put("parentCd", "ct000");

		Integer categoryListCnt = this.adminBrandApiService.getCategoryListCnt(searchMap);
		List<NewCodeDTO> categoryList = null;

		if(categoryListCnt > 0) {
			categoryList = this.adminBrandApiService.getCategoryList(searchMap);
		}

		// 리스트 수
		categoryMap.put("pageSize", page.getSize());
		// 전체 페이지 수
		categoryMap.put("perPageListCnt", Math.ceil((categoryListCnt - 1) / page.getSize() + 1));
		// 전체 아이템 수
		categoryMap.put("categoryListTotalCnt", categoryListCnt);

		categoryMap.put("categoryList", categoryList);

		return categoryMap;
	}

	@ApiOperation(value = "분야 상세", notes = "분야 상세를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/{codeId}")
	public ConcurrentHashMap<String, Object> categoryInfo(@PathVariable("codeId") String codeId) throws Exception {

		NewCodeDTO newCodeDTO = new NewCodeDTO();
		newCodeDTO.setCodeId(codeId);

		ConcurrentHashMap categoryMap = this.adminBrandApiService.getCategoryInfo(newCodeDTO);

		return categoryMap;
	}

	@ApiOperation(value = "분야 등록", notes = "분야를 등록한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PostMapping
	public String insertCategory(NewCodeDTO newCodeDTO) throws Exception {
		String result = "";

		result = this.adminBrandApiService.insertCategory(newCodeDTO);

		return result;
	}

	@ApiOperation(value = "분야 수정", notes = "분야를 수정한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PutMapping(value = "/{codeId}")
	public String updateCategory(@RequestBody NewCodeDTO newCodeDTO,
								 @PathVariable(name = "codeId") String codeId) throws Exception {
		String result = "";

		newCodeDTO.setCodeId(codeId);

		result = this.adminBrandApiService.updateCategory(newCodeDTO);

		return result;
	}
}
