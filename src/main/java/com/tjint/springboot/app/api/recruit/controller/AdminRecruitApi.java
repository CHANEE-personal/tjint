package com.tjint.springboot.app.api.recruit.controller;

import com.tjint.springboot.app.api.recruit.service.AdminRecruitApiService;
import com.tjint.springboot.app.api.recruit.service.NewRecruitDTO;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import com.tjint.springboot.common.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.rmi.ServerError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api/recruit")
@RestController
@RequiredArgsConstructor
@Api(tags = "채용공고 API")
public class AdminRecruitApi {

	private final AdminRecruitApiService adminRecruitApiService;

	@ApiOperation(value = "채용공고 조회", notes = "채용공고를 조회한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "채용공고 조회성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/getRecruitList")
	public JSONObject getRecruitList (@RequestParam(value = "searchKeyword", required = false) String searchKeyword, Page page) throws Exception {
		JSONObject jsonObject = new JSONObject();

		Map<String, Object> searchMap = new HashMap<>();

		Integer pageCnt = StringUtil.getInt(page.getPage(), 1);
		Integer pageSize = StringUtil.getInt(page.getSize(), 10);
		page.setPage(pageCnt);
		page.setSize(pageSize);
		searchMap.put("searchKeyword", StringUtil.getString(searchKeyword, ""));
		searchMap.put("startPage", page.getStartPage());
		searchMap.put("size", pageSize);

		Integer recruitListCnt = this.adminRecruitApiService.getRecruitListCnt(searchMap);

		List<NewRecruitDTO> recruitList = null;

		if(recruitListCnt > 0) {
			recruitList = this.adminRecruitApiService.getRecruitList(searchMap);
		}

		// 리스트 수
		jsonObject.put("pageSize", page.getSize());
		// 전체 페이지 수
		jsonObject.put("perPageListCnt", Math.ceil((recruitListCnt - 1) / page.getSize() + 1));
		// 전체 아이템 수
		jsonObject.put("recruitListTotalCnt", recruitListCnt);

		jsonObject.put("recruitList", recruitList);


		return jsonObject;
	}

	@ApiOperation(value = "채용공고 상세", notes = "채용공고 상세 조회")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 등록성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/getRecruitInfo/{recruitSeq}")
	public Map<String, Object> getRecruitInfo(@PathVariable("recruitSeq") Integer recruitSeq) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> recruitMap;
		NewRecruitDTO newRecruitDTO = new NewRecruitDTO();
		NewUrlLinkDTO newUrlLinkDTO = new NewUrlLinkDTO();
		newRecruitDTO.setRecruitSeq(recruitSeq);

		recruitMap = this.adminRecruitApiService.getRecruitInfo(newRecruitDTO, newUrlLinkDTO);
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
	@PostMapping(value = "/addRecruit")
	public String addRecruit(@RequestBody NewRecruitDTO newRecruitDTO) throws Exception {

		System.out.println("===Idx===");
		System.out.println(newRecruitDTO.getRecruitSeq());
		String result = this.adminRecruitApiService.addRecruit(newRecruitDTO);

		return result;
	}
}
