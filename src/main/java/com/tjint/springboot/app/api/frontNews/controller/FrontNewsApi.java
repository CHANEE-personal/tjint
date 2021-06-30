package com.tjint.springboot.app.api.frontNews.controller;

import com.tjint.springboot.app.api.frontNews.service.FrontNewsApiService;
import com.tjint.springboot.app.api.news.service.NewNewsDTO;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "FRONT NEWS API")
@RequestMapping(value = "/api/news")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class FrontNewsApi {

    private final FrontNewsApiService frontNewsApiService;

    @ApiOperation(value = "Front News 페이지", notes = "Front News 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/frontNewsList")
    public JSONObject frontNewsList(@RequestParam(value = "searchKeyword", required = false) String searchKeyword, Page page) throws Exception {
        JSONObject jsonObject = new JSONObject();

        Map<String, Object> searchMap = new HashMap<>();

        Integer pageCnt = StringUtil.getInt(page.getPage(), 1);
        Integer pageSize = StringUtil.getInt(page.getSize(), 10);
        page.setPage(pageCnt);
        page.setSize(pageSize);
        searchMap.put("searchKeyword", StringUtil.getString(searchKeyword, ""));
        searchMap.put("startPage", page.getStartPage());
        searchMap.put("size", pageSize);

        Integer newsListCnt = this.frontNewsApiService.frontNewsListCnt(searchMap);
        List<NewNewsDTO> newsInfoList = null;

        if (newsListCnt > 0) {
            newsInfoList = this.frontNewsApiService.frontNewsList(searchMap);
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

    @ApiOperation(value = "Front News 상세페이지", notes = "Front News 상세페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/frontNewsInfo/{newsSeq}")
    public Map<String, Object> frontNewsInfo(@PathVariable(value="newsSeq") Integer newsSeq) throws Exception {
        Map<String, Object> newsMap = new HashMap<>();

        NewNewsDTO newNewsDTO = new NewNewsDTO();
        newNewsDTO.setNewsSeq(newsSeq);

        // 이전, 다음 글 idx 조회
        newsMap.put("prevIdx", this.frontNewsApiService.frontNewsPrevIdx(newsSeq));
        newsMap.put("nextIdx", this.frontNewsApiService.frontNewsNextIdx(newsSeq));
        newsMap.put("newsInfo", this.frontNewsApiService.frontNewsInfo(newNewsDTO));

        return newsMap;
    }

    @ApiOperation(value = "Front SOCIETY 페이지", notes = "Front SOCIETY 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/society")
    public JSONObject society(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }

    @ApiOperation(value = "Front CULTURE 페이지", notes = "Front CULTURE 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/culture")
    public JSONObject culture(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }
}
