package com.tjint.springboot.app.api.admin.recruit.controller;

import com.tjint.springboot.app.api.admin.recruit.service.AdminRecruitApiService;
import com.tjint.springboot.app.api.admin.recruit.service.NewRecruitDTO;
import com.tjint.springboot.app.api.common.SearchCommon;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
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

@RequestMapping(value = "/api/recruit")
@RestController
@RequiredArgsConstructor
@Api(tags = "채용공고 API")
public class AdminRecruitApi {

	private final AdminRecruitApiService adminRecruitApiService;
	private final SearchCommon searchCommon;

	@ApiOperation(value = "채용공고 조회", notes = "채용공고를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "채용공고 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/lists")
	public ConcurrentHashMap<String, Object> getRecruitList (@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
															 Page page) throws Exception {
		ConcurrentHashMap<String, Object> recruitMap = new ConcurrentHashMap<>();

		ConcurrentHashMap<String, Object> searchMap = searchCommon.searchCommon(page, searchKeyword);

		Integer recruitListCnt = this.adminRecruitApiService.getRecruitListCnt(searchMap);

		List<NewRecruitDTO> recruitList = null;

		if(recruitListCnt > 0) {
			recruitList = this.adminRecruitApiService.getRecruitList(searchMap);
		}

		// 리스트 수
		recruitMap.put("pageSize", page.getSize());
		// 전체 페이지 수
		recruitMap.put("perPageListCnt", Math.ceil((recruitListCnt - 1) / page.getSize() + 1));
		// 전체 아이템 수
		recruitMap.put("recruitListTotalCnt", recruitListCnt);

		recruitMap.put("recruitList", recruitList);

		return recruitMap;
	}

	@ApiOperation(value = "채용공고 상세", notes = "채용공고 상세 조회")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 등록성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/{recruitSeq}")
	public ConcurrentHashMap<String, Object> getRecruitInfo(@PathVariable("recruitSeq") Integer recruitSeq) throws Exception {
		ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

		NewRecruitDTO newRecruitDTO = new NewRecruitDTO();
		NewUrlLinkDTO newUrlLinkDTO = new NewUrlLinkDTO();
		newRecruitDTO.setRecruitSeq(recruitSeq);

		ConcurrentHashMap<String, Object> recruitMap = this.adminRecruitApiService.getRecruitInfo(newRecruitDTO, newUrlLinkDTO);

		resultMap.put("recruitMap", recruitMap.get("recruitInfo"));
		resultMap.put("urlLinkList", recruitMap.get("urlLinkList"));

		return recruitMap;
	}

	@ApiOperation(value = "채용공고 등록", notes = "채용공고를 등록한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "채용공고 등록성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PostMapping
	public String addRecruit(@RequestBody NewRecruitDTO newRecruitDTO) throws Exception {

		String result = this.adminRecruitApiService.addRecruit(newRecruitDTO);

		return result;
	}
}
