package com.tjint.springboot.app.api.admin.brand.controller;

import com.tjint.springboot.app.api.admin.brand.service.AdminBrandApiService;
import com.tjint.springboot.app.api.admin.brand.service.NewBrandDTO;
import com.tjint.springboot.app.api.common.SearchCommon;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import com.tjint.springboot.common.utils.StringUtil;
import io.swagger.annotations.*;
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

@RequestMapping(value = "/api/brand")
@RestController
@RequiredArgsConstructor
@Api(tags = "브랜드관리관련 API")
public class AdminBrandApi {

	private final AdminBrandApiService adminBrandApiService;
	private final SearchCommon searchCommon;

	/**
	 * <pre>
	 * 1. MethodName : lists
	 * 2. ClassName  : AdminBrandApi.java
	 * 3. Comment    : 브랜드 리스트 조회
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 04. 23.
	 * </pre>
	 *
	 * @param searchKeyword
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "브랜드 조회", notes = "브랜드를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/lists")
	public ConcurrentHashMap<String, Object> getBrandList(@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
														  Page page) throws Exception {

		ConcurrentHashMap<String, Object> brandMap = new ConcurrentHashMap<>();

		// 페이징 및 검색
		ConcurrentHashMap<String, Object> searchMap = searchCommon.searchCommon(page, searchKeyword);

		Integer brandListCnt = this.adminBrandApiService.getBrandListCnt(searchMap);

		List<NewBrandDTO> brandInfoList = null;

		if (brandListCnt > 0) {
			brandInfoList = this.adminBrandApiService.getBrandList(searchMap);
		}

		// 리스트 수
		brandMap.put("pageSize", page.getSize());
		// 전체 페이지 수
		brandMap.put("perPageListCnt", Math.ceil((brandListCnt - 1) / page.getSize() + 1));
		// 전체 아이템 수
		brandMap.put("brandInfoListTotalCnt", brandListCnt);

		brandMap.put("brandInfoList", brandInfoList);

		return brandMap;
	}

	/**
	 * <pre>
	 * 1. MethodName : brand-register
	 * 2. ClassName  : AdminBrandApi.java
	 * 3. Comment    : 브랜드 등록 페이지
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 04. 23.
	 * </pre>
	 *
	 * @return resultMap
	 * @throws Exception
	 */
	@ApiOperation(value = "브랜드 등록페이지", notes = "브랜드를 등록페이지", position = 1)
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/brand-register")
	public ConcurrentHashMap brandRegister() throws Exception {

		ConcurrentHashMap<String, Object> brandMap = this.adminBrandApiService.getBrandRegist();

		return brandMap;
	}

	/**
	 * <pre>
	 * 1. MethodName : brandInfo
	 * 2. ClassName  : AdminBrandApi.java
	 * 3. Comment    : 브랜드 상세 페이지
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 04. 23.
	 * </pre>
	 *
	 * @return resultMap
	 * @throws Exception
	 */
	@ApiOperation(value = "브랜드 상세", notes = "브랜드를 상세페이지")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/{brandSeq}")
	public ConcurrentHashMap<String, Object> brandInfo(@PathVariable("brandSeq") Integer brandSeq) throws Exception {

		ConcurrentHashMap<String, Object> brandMap = this.adminBrandApiService.getBrandInfo(brandSeq);

		return brandMap;
	}

	/**
	 * <pre>
	 * 1. MethodName : addBrand
	 * 2. ClassName  : AdminBrandApi.java
	 * 3. Comment    : 브랜드 등록
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 04. 23.
	 * </pre>
	 *
	 * @return result
	 * @throws Exception
	 */
	@ApiOperation(value = "브랜드 등록", notes = "브랜드를 등록한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 등록성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String addBrand(NewBrandDTO newBrandDTO,
						   NewImageDTO newImageDTO,
						   NewUrlLinkDTO newUrlLinkDTO,
						   @RequestParam(value = "fileName", required = false) MultipartFile[] files,
						   HttpServletRequest request) throws Exception {

		String result = "";
		if("Y".equals(this.adminBrandApiService.addBrand(newBrandDTO, newImageDTO, newUrlLinkDTO, files, request))) {
			result = "Y";
		} else {
			result = "N";
		}

		return result;
	}

	/**
	 * <pre>
	 * 1. MethodName : updateBrand
	 * 2. ClassName  : AdminBrandApi.java
	 * 3. Comment    : 브랜드 수정
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 04. 23.
	 * </pre>
	 *
	 * @return result
	 * @throws Exception
	 */
	@ApiOperation(value = "브랜드 수정", notes = "브랜드를 수정한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 수정성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})

	@PostMapping(value = "/{brandSeq}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String updateBrand(NewBrandDTO newBrandDTO,
							  NewImageDTO newImageDTO,
							  NewUrlLinkDTO newUrlLinkDTO,
							  @RequestParam(value = "fileName", required = false) MultipartFile[] files,
							  HttpServletRequest request) throws Exception {
		String result = "";

		if("Y".equals(this.adminBrandApiService.updateBrand(newBrandDTO, newImageDTO, newUrlLinkDTO, files, request))) {
			result = "Y";
		} else {
			result = "N";
		}

		return result;
	}

	/**
	 * <pre>
	 * 1. MethodName : deleteBrand
	 * 2. ClassName  : AdminBrandApi.java
	 * 3. Comment    : 브랜드 삭제
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 04. 23.
	 * </pre>
	 *
	 * @return result
	 * @throws Exception
	 */
	@ApiOperation(value = "브랜드 삭제", notes = "브랜드를 삭제한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 삭제성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})

	@DeleteMapping(value = "/{brandSeq}")
	public String deleteBrand(@PathVariable @ApiParam(value = "브랜드코드", required = true) Integer brandSeq) throws Exception {

		String result = "";

		NewBrandDTO newBrandDTO = new NewBrandDTO();
		newBrandDTO.setVisible("D");
		newBrandDTO.setBrandSeq(brandSeq);

		if (StringUtil.getInt(this.adminBrandApiService.deleteBrand(newBrandDTO), 0) > 0) {
			result = "Y";
		} else {
			result = "N";
		}

		return result;
	}
}
