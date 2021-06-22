package com.tjint.springboot.app.api.news.controller;

import com.tjint.springboot.app.api.news.service.AdminNewsApiService;
import com.tjint.springboot.app.api.news.service.NewNewsDTO;
import com.tjint.springboot.common.imageFile.AttachFileDTO;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.rmi.ServerError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api/news")
@RestController
@RequiredArgsConstructor
@Api(tags = "News관리관련 API")
public class AdminNewsApi {

	private final AdminNewsApiService adminNewsApiService;

	@ApiOperation(value = "News 조회", notes = "News를 조회한다.")
	@GetMapping(value = "/getNewsList")
	public JSONObject getNewsList(@RequestParam(value = "searchKeyword", required = false) String searchKeyword, Page page) throws Exception {

		JSONObject jsonObject = new JSONObject();
		Map<String, Object> searchMap = new HashMap<>();

		Integer pageCnt = StringUtil.getInt(page.getPage(), 1);
		Integer pageSize = StringUtil.getInt(page.getSize(), 10);
		page.setPage(pageCnt);
		page.setSize(pageSize);
		searchMap.put("searchKeyword", StringUtil.getString(searchKeyword, ""));
		searchMap.put("startPage", page.getStartPage());
		searchMap.put("size", pageSize);

		Integer newsListCnt = this.adminNewsApiService.getNewsListCnt(searchMap);
		List<NewNewsDTO> newsInfoList = null;

		if (newsListCnt > 0) {
			newsInfoList = this.adminNewsApiService.getNewsList(searchMap);
		}

		// 리스트 수
		jsonObject.put("pageSize", page.getSize());
		// 전체 페이지 수
		jsonObject.put("perPageListCnt", Math.ceil((newsListCnt - 1) / page.getSize() + 1));
		// 전체 아이템 수
		jsonObject.put("newsInfoListTotalCnt", newsListCnt);

		jsonObject.put("newsInfoList", newsInfoList);

		return jsonObject;
	}

	@ApiOperation(value = "News 등록", notes = "News를 등록한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 등록성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PostMapping(value = "/addNews", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String addNews(NewNewsDTO newNewsDTO,
						  NewImageDTO newImageDTO,
						  AttachFileDTO attachFileDTO,
						  @RequestParam(value = "fileName", required = false) MultipartFile files) throws Exception {

		String result = this.adminNewsApiService.addNews(newNewsDTO, newImageDTO, attachFileDTO, files);

		return result;
	}

	@ApiOperation(value = "News 상세", notes = "News 상세 조회")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 등록성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/getNewsInfo/{newsSeq}")
	public Map<String, Object> getNewsInfo(@PathVariable("newsSeq") Integer newsSeq) throws Exception {
		Map<String, Object> newsMap = new HashMap<>();
		NewNewsDTO newNewsDTO = new NewNewsDTO();
		newNewsDTO.setNewsSeq(newsSeq);

		newsMap = this.adminNewsApiService.getNewsInfo(newNewsDTO);
		return newsMap;
	}

	@ApiOperation(value = "News 수정", notes = "News 수정")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 등록성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PutMapping(value = "/updateNews/{newsSeq}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String updateNews(@RequestBody NewNewsDTO newNewsDTO,
						   @PathVariable(value="newsSeq") Integer newsSeq,
						   NewImageDTO newImageDTO,
						   AttachFileDTO attachFileDTO,
							 @RequestPart(value = "files", required = false) MultipartFile files) throws Exception {
		newNewsDTO.setNewsSeq(newsSeq);
		String result = this.adminNewsApiService.updateNews(newNewsDTO, newImageDTO, attachFileDTO, files);

		return result;
	}
}
