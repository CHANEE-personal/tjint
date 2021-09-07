package com.tjint.springboot.app.api.admin.news.controller;

import com.tjint.springboot.app.api.admin.news.service.AdminNewsApiService;
import com.tjint.springboot.app.api.admin.news.service.NewNewsDTO;
import com.tjint.springboot.app.api.common.SearchCommon;
import com.tjint.springboot.common.imageFile.AttachFileDTO;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.paging.Page;
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

@RequestMapping(value = "/api/admin-news")
@RestController
@RequiredArgsConstructor
@Api(tags = "News관리관련 API")
public class AdminNewsApi {

	private final AdminNewsApiService adminNewsApiService;
	private final SearchCommon searchCommon;

	@ApiOperation(value = "News 조회", notes = "News를 조회한다.")
	@GetMapping(value = "/lists")
	public ConcurrentHashMap getNewsList(@RequestParam(value = "searchKeyword", required = false) String searchKeyword,
										 Page page) throws Exception {

		ConcurrentHashMap<String, Object> newsMap = new ConcurrentHashMap<>();

		// 페이징 및 검색
		ConcurrentHashMap<String, Object> searchMap = searchCommon.searchCommon(page, searchKeyword);

		Integer newsListCnt = this.adminNewsApiService.getNewsListCnt(searchMap);
		List<NewNewsDTO> newsInfoList = null;

		if (newsListCnt > 0) {
			newsInfoList = this.adminNewsApiService.getNewsList(searchMap);
		}

		// 리스트 수
		newsMap.put("pageSize", page.getSize());
		// 전체 페이지 수
		newsMap.put("perPageListCnt", Math.ceil((newsListCnt - 1) / page.getSize() + 1));
		// 전체 아이템 수
		newsMap.put("newsInfoListTotalCnt", newsListCnt);

		newsMap.put("newsInfoList", newsInfoList);

		return newsMap;
	}

	@ApiOperation(value = "News 등록", notes = "News를 등록한다.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 등록성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String addNews(NewNewsDTO newNewsDTO,
						  NewImageDTO newImageDTO,
						  AttachFileDTO attachFileDTO,
						  @RequestParam(value = "fileName", required = false) MultipartFile[] files, HttpServletRequest request) throws Exception {

		String result = this.adminNewsApiService.addNews(newNewsDTO, newImageDTO, attachFileDTO, files, request);

		return result;
	}

	@ApiOperation(value = "News 상세", notes = "News 상세 조회")
	@ApiResponses({
			@ApiResponse(code = 200, message = "브랜드 등록성공", response = Map.class),
			@ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
			@ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
	})
	@GetMapping(value = "/{newsSeq}")
	public Map<String, Object> getNewsInfo(@PathVariable("newsSeq") Integer newsSeq) throws Exception {
		ConcurrentHashMap<String, Object> newsMap;

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
	@PostMapping(value = "/{newsSeq}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String updateNews(@PathVariable(value = "newsSeq") Integer newsSeq,
							 NewNewsDTO newNewsDTO,
							 NewImageDTO newImageDTO,
							 @RequestParam(value = "fileName", required = false) MultipartFile[] files, HttpServletRequest request) throws Exception {

		newNewsDTO.setNewsSeq(newsSeq);

		String result = this.adminNewsApiService.updateNews(newNewsDTO, newImageDTO, files, request);

		return result;
	}
}
