package com.tjint.springboot.app.api.brand.controller;

import com.tjint.springboot.app.admin.jwt.JwtDecoder;
import com.tjint.springboot.app.admin.jwt.JwtUtil;
import com.tjint.springboot.app.api.brand.service.AdminBrandApiService;
import com.tjint.springboot.app.api.brand.service.NewBrandDTO;
import com.tjint.springboot.app.api.brand.service.NewCodeDTO;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import com.tjint.springboot.common.utils.StringUtil;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api/brand")
@RestController
@RequiredArgsConstructor
@Api(tags = "브랜드관리관련 API")
public class adminBrandApi {
	private final AdminBrandApiService adminBrandApiService;
	private final JwtUtil jwtUtil;
	private final JwtDecoder jwtDecoder;

	@ApiOperation(value = "브랜드 조회", notes = "브랜드를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/brandList")
	@ResponseBody
	public JSONObject getBrandList(@RequestParam(value = "searchKeyword", required = false) String searchKeyword, Page page) throws Exception {

		JSONObject jsonObject = new JSONObject();
		Map<String, Object> searchMap = new HashMap<>();

		Integer pageCnt = StringUtil.getInt(page.getPage(), 1);
		Integer pageSize = StringUtil.getInt(page.getSize(), 10);
		page.setPage(pageCnt);
		page.setSize(pageSize);
		searchMap.put("searchKeyword", StringUtil.getString(searchKeyword, ""));
		searchMap.put("startPage", page.getStartPage());
		searchMap.put("size", pageSize);

		Integer brandListCnt = this.adminBrandApiService.getBrandListCnt(searchMap);
		List<BrandInfoVo> brandInfoList = null;

		if (brandListCnt > 0) {
			brandInfoList = this.adminBrandApiService.getBrandList(searchMap);
		}

		// 리스트 수
		jsonObject.put("pageSize", page.getSize());
		// 전체 페이지 수
		jsonObject.put("perPageListCnt", Math.ceil((brandListCnt - 1) / page.getSize() + 1));
		// 전체 아이템 수
		jsonObject.put("brandInfoListTotalCnt", brandListCnt);

		jsonObject.put("brandInfoList", brandInfoList);

		return jsonObject;
	}

	@ApiOperation(value = "분야 조회", notes = "분야를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/categoryList")
	@ResponseBody
	public Map<String, Object> categoryList(@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
											Page page) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> searchMap = new HashMap<>();

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
		resultMap.put("pageSize", page.getSize());
		// 전체 페이지 수
		resultMap.put("perPageListCnt", Math.ceil((categoryListCnt - 1) / page.getSize() + 1));
		// 전체 아이템 수
		resultMap.put("categoryListTotalCnt", categoryListCnt);

		resultMap.put("categoryList", categoryList);

		return resultMap;
	}

	@ApiOperation(value = "분야 상세", notes = "분야 상세를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/categoryInfo/{codeId}")
	@ResponseBody
	public Map<String, Object> categoryInfo(@PathVariable("codeId") String codeId) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();

		NewCodeDTO newCodeDTO = new NewCodeDTO();
		newCodeDTO.setCodeId(codeId);

		resultMap = this.adminBrandApiService.getCategoryInfo(newCodeDTO);

		return resultMap;
	}

	@ApiOperation(value = "분야 등록", notes = "분야를 등록한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PostMapping(value = "/insertCategory")
	@ResponseBody
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
	@PutMapping(value = "/updateCategory/{codeId}")
	@ResponseBody
	public String updateCategory(@RequestBody NewCodeDTO newCodeDTO) throws Exception {
		String result = "";

		result = this.adminBrandApiService.updateCategory(newCodeDTO);

		return result;
	}

	@ApiOperation(value = "SNS 조회", notes = "SNS를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/snsList")
	@ResponseBody
	public Map<String, Object> snsList(@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
									   Page page) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> searchMap = new HashMap<>();

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
		resultMap.put("pageSize", page.getSize());
		// 전체 페이지 수
		resultMap.put("perPageListCnt", Math.ceil((snsListCnt - 1) / page.getSize() + 1));
		// 전체 아이템 수
		resultMap.put("snsListTotalCnt", snsListCnt);

		resultMap.put("snsList", snsList);

		return resultMap;
	}

	@ApiOperation(value = "브랜드 등록페이지", notes = "브랜드를 등록페이지", position = 1)
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/brandRegist")
	@ResponseBody
	public JSONObject brandRegist(HttpServletRequest request) throws Exception {
		JSONObject jsonObject = new JSONObject();

		Map<String, Object> brandMap = new HashMap<>();
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("parentCd", "ct000");
		searchMap.put("visible","Y");

		Integer categoryListCnt = this.adminBrandApiService.getCategoryListCnt(searchMap);
		List<NewCodeDTO> categoryList = null;
		if(categoryListCnt > 0) {
			categoryList = this.adminBrandApiService.getCategoryList(searchMap);
		}

		searchMap.put("parentCd", "mu000");
		searchMap.put("visible", "Y");

		Integer menuListCnt = this.adminBrandApiService.getCategoryListCnt(searchMap);
		List<NewCodeDTO> menuList = null;
		if(menuListCnt > 0) {
			menuList = this.adminBrandApiService.getCategoryList(searchMap);
		}

		searchMap.put("parentCd", "lnkt002");
		searchMap.put("visible", "Y");
		Integer snsLinkListCnt = this.adminBrandApiService.getCategoryListCnt(searchMap);
		List<NewCodeDTO> snsLinkList = null;
		if(snsLinkListCnt > 0) {
			snsLinkList = this.adminBrandApiService.getCategoryList(searchMap);
		}

		brandMap.put("categoryList", categoryList);
		brandMap.put("menuList", menuList);
		brandMap.put("snsLinkList", snsLinkList);

		jsonObject.put("brandObject", brandMap);

		return jsonObject;
	}

	@ApiOperation(value = "브랜드 상세", notes = "브랜드를 상세페이지")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/brandInfo/{brandSeq}")
	@ResponseBody
	public Map<String, Object> brandInfo(@PathVariable("brandSeq") Integer brandSeq) throws Exception {
		Map<String, Object> brandMap = new HashMap<>();

		NewBrandDTO newBrandDTO = new NewBrandDTO();
		newBrandDTO.setBrandSeq(brandSeq);

		NewUrlLinkDTO newUrlLinkDTO = new NewUrlLinkDTO();
		newUrlLinkDTO.setBoardSeq(brandSeq);
		newUrlLinkDTO.setBoardTypeCd("brdt001");

		brandMap.put("brandInfo", this.adminBrandApiService.getBrandInfo(newBrandDTO));
		brandMap.put("snsLinkList", this.adminBrandApiService.getSnsLinkList(newUrlLinkDTO));

		return brandMap;
	}

	@ApiOperation(value = "브랜드 등록", notes = "브랜드를 등록한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 등록성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PostMapping(value = "/addBrand", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void addBrand(NewBrandDTO newBrandDTO,
						 NewImageDTO newImageDTO,
						 NewUrlLinkDTO newUrlLinkDTO,
						 @RequestParam(value = "fileName", required = false) MultipartFile[] files, HttpServletRequest request) throws Exception {

		this.adminBrandApiService.addBrand(newBrandDTO, newImageDTO, newUrlLinkDTO, files, request);
	}

	@ApiOperation(value = "브랜드 수정", notes = "브랜드를 수정한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 수정성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})

	@PutMapping(value = "/updateBrand/{brandSeq}")
	public void updateBrand(BrandInfoVo brandInfoVo) throws Exception {
		this.adminBrandApiService.modifyBrand(brandInfoVo);
	}

	@ApiOperation(value = "브랜드 삭제", notes = "브랜드를 삭제한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 삭제성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})

	@DeleteMapping(value = "/deleteBrand/{brandSeq}")
	public void deleteBrand(@PathVariable @ApiParam(value = "브랜드코드", required = true) Integer brandSeq) throws Exception {

		BrandInfoVo brandInfoVo = new BrandInfoVo();
		brandInfoVo.setVisible("N");
		brandInfoVo.setBrandSeq(brandSeq);

		this.adminBrandApiService.modifyBrand(brandInfoVo);
	}

}
