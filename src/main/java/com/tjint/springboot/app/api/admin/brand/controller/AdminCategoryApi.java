package com.tjint.springboot.app.api.admin.brand.controller;

import com.tjint.springboot.app.api.admin.brand.service.AdminCategoryApiService;
import com.tjint.springboot.app.api.admin.brand.service.NewCodeDTO;
import com.tjint.springboot.app.api.common.SearchCommon;
import com.tjint.springboot.common.paging.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerError;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RequestMapping(value = "/api/category")
@RestController
@RequiredArgsConstructor
@Api(tags = "분야관리관련 API")
public class AdminCategoryApi {

	private final AdminCategoryApiService adminCategoryApiService;
	private final SearchCommon searchCommon;

	/**
	 * <pre>
	 * 1. MethodName : categoryList
	 * 2. ClassName  : AdminCategoryApi.java
	 * 3. Comment    : 분야 리스트 조회
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 07.
	 * </pre>
	 *
	 * @param searchKeyword
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "분야 조회", notes = "분야를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/lists")
	@ResponseBody
	public ConcurrentHashMap<String, Object> categoryList(
			@RequestParam(value = "searchKeyword", required = false) String searchKeyword
			,Page page) throws Exception {

		ConcurrentHashMap<String, Object> categoryMap = new ConcurrentHashMap<>();

		// 페이징 및 검색
		ConcurrentHashMap<String, Object> searchMap = searchCommon.searchCommon(page, searchKeyword);
		searchMap.put("parentCd", "ct000");

		Integer categoryListCnt = this.adminCategoryApiService.getCategoryListCnt(searchMap);
		List<NewCodeDTO> categoryList = null;

		if(categoryListCnt > 0) {
			categoryList = this.adminCategoryApiService.getCategoryList(searchMap);
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

	/**
	 * <pre>
	 * 1. MethodName : categoryInfo
	 * 2. ClassName  : AdminCategoryApi.java
	 * 3. Comment    : 분야 상세
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 07.
	 * </pre>
	 *
	 * @param  codeId
	 * @return categoryMap
	 * @throws Exception
	 */
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
		newCodeDTO.setParentCd("ct000");

		ConcurrentHashMap categoryMap = this.adminCategoryApiService.getCategoryInfo(newCodeDTO);

		return categoryMap;
	}

	/**
	 * <pre>
	 * 1. MethodName : insertCategory
	 * 2. ClassName  : AdminCategoryApi.java
	 * 3. Comment    : 분야 등록
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 07.
	 * </pre>
	 *
	 * @param  newCodeDTO
	 * @return result
	 * @throws Exception
	 */
	@ApiOperation(value = "분야 등록", notes = "분야를 등록한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PostMapping
	public String insertCategory(@RequestBody NewCodeDTO newCodeDTO, HttpServletRequest request) throws Exception {
		String result = "";

		searchCommon.giveAuth(request, newCodeDTO);

		result = this.adminCategoryApiService.insertCategory(newCodeDTO, request);

		return result;
	}

	/**
	 * <pre>
	 * 1. MethodName : updateCategory
	 * 2. ClassName  : AdminCategoryApi.java
	 * 3. Comment    : 분야 수정
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 07.
	 * </pre>
	 *
	 * @param  newCodeDTO
	 * @param  codeId
	 * @return result
	 * @throws Exception
	 */
	@ApiOperation(value = "분야 수정", notes = "분야를 수정한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PutMapping(value = "/{codeId}")
	public String updateCategory(@RequestBody NewCodeDTO newCodeDTO,
								 @PathVariable(name = "codeId") String codeId, HttpServletRequest request) throws Exception {
		String result = "";

		searchCommon.giveAuth(request, newCodeDTO);

		newCodeDTO.setCodeId(codeId);

		result = this.adminCategoryApiService.updateCategory(newCodeDTO, request);

		return result;
	}
}
