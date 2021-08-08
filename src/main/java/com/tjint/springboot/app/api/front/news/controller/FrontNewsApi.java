package com.tjint.springboot.app.api.front.news.controller;

import com.tjint.springboot.app.api.common.SearchCommon;
import com.tjint.springboot.app.api.front.news.service.FrontNewsApiService;
import com.tjint.springboot.app.api.admin.news.service.NewNewsDTO;
import com.tjint.springboot.common.paging.Page;
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

@Api(tags = "FRONT NEWS API")
@RequestMapping(value = "/api/front-news")
@RestController
@RequiredArgsConstructor
public class FrontNewsApi {

    private final FrontNewsApiService frontNewsApiService;
    private final SearchCommon searchCommon;

    @ApiOperation(value = "Front News 페이지", notes = "Front News 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/lists")
    public ConcurrentHashMap frontNewsList(@RequestParam(value = "searchCondition", required = false) Integer searchCondition,
                                           @RequestParam(value = "searchKeyword", required = false) String searchKeyword,
                                           Page page) throws Exception {

        ConcurrentHashMap<String, Object> newsMap = new ConcurrentHashMap<>();

        ConcurrentHashMap<String, Object> searchMap = searchCommon.searchCommon(page, searchKeyword);
        searchMap.put("searchCondition", searchCondition);

        Integer newsListCnt = this.frontNewsApiService.frontNewsListCnt(searchMap);
        List<NewNewsDTO> newsInfoList = null;

        if (newsListCnt > 0) {
            newsInfoList = this.frontNewsApiService.frontNewsList(searchMap);
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

    @ApiOperation(value = "Front News 상세페이지", notes = "Front News 상세페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/{newsSeq}")
    public ConcurrentHashMap<String, Object> frontNewsInfo(@PathVariable(value="newsSeq") Integer newsSeq) throws Exception {

        NewNewsDTO newNewsDTO = new NewNewsDTO();
        newNewsDTO.setNewsSeq(newsSeq);

        ConcurrentHashMap<String, Object> newsMap = this.frontNewsApiService.frontNewsInfo(newNewsDTO);

        return newsMap;
    }

    @ApiOperation(value = "Front SOCIETY 페이지", notes = "Front SOCIETY 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/society")
    public String society() throws Exception {
        return "society";
    }

    @ApiOperation(value = "Front CULTURE 페이지", notes = "Front CULTURE 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/culture")
    public String culture() throws Exception {
        return "culture";
    }
}
