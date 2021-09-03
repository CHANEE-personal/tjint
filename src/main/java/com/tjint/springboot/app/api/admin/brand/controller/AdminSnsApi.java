package com.tjint.springboot.app.api.admin.brand.controller;

import com.tjint.springboot.app.api.admin.brand.service.AdminCategoryApiService;
import com.tjint.springboot.app.api.admin.brand.service.NewCodeDTO;
import com.tjint.springboot.app.api.common.SearchCommon;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerError;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequestMapping(value = "/api/sns")
@RestController
@RequiredArgsConstructor
@Api(tags = "SNS관리관련 API")
public class AdminSnsApi {

	private final AdminCategoryApiService adminCategoryApiService;
	private final SearchCommon searchcommon;

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

		// 페이징 및 검색
		ConcurrentHashMap<String, Object> searchMap = searchcommon.searchCommon(page, searchKeyword);
		searchMap.put("parentCd", "lnkt002");

		Integer snsListCnt = this.adminCategoryApiService.getCategoryListCnt(searchMap);

		List<NewCodeDTO> snsList = null;

		if(snsListCnt > 0) {
			snsList = this.adminCategoryApiService.getCategoryList(searchMap);
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
	@ApiOperation(value = "SNS 상세", notes = "SNS 상세를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/{codeId}")
	public ConcurrentHashMap<String, Object> snsInfo(@PathVariable("codeId") String codeId) throws Exception {

		NewCodeDTO newCodeDTO = new NewCodeDTO();
		newCodeDTO.setCodeId(codeId);
		newCodeDTO.setParentCd("lnkt002");

		ConcurrentHashMap categoryMap = this.adminCategoryApiService.getCategoryInfo(newCodeDTO);

		return categoryMap;
	}

	@ApiOperation(value = "SNS 등록", notes = "SNS를 등록한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String addSns(NewCodeDTO newCodeDTO,
						 @RequestParam(value = "fileName", required = false) MultipartFile[] files, HttpServletRequest request) throws Exception {
		String result = "";

		searchcommon.giveAuth(request, newCodeDTO);

		if("Y".equals(StringUtil.getString(this.adminCategoryApiService.addSns(newCodeDTO, files, request),""))) {
			result = "Y";
		} else {
			result = "N";
		}

		return result;
	}

	@ApiOperation(value = "SNS 수정", notes = "SNS를 수정한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PostMapping(value="update-sns", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String updateSns(NewCodeDTO newCodeDTO,
							@RequestParam(value = "fileName") MultipartFile[] files, HttpServletRequest request) throws Exception {
		String result = "";

		searchcommon.giveAuth(request, newCodeDTO);

		if("Y".equals(StringUtil.getString(this.adminCategoryApiService.updateSns(newCodeDTO, files, request),""))) {
			result = "Y";
		} else {
			result = "N";
		}

		return result;
	}
}
