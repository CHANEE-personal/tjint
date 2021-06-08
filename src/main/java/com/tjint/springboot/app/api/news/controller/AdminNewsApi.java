package com.tjint.springboot.app.api.news.controller;

import com.tjint.springboot.app.api.news.service.AdminNewsApiService;
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

    @ApiOperation(value = "News관련조회", notes = "News를 조회한다.")
    @GetMapping(value = "/getNewsList")
    public JSONObject getNewsList(@RequestParam(value = "searchKeyword", required = false) String searchKeyword, Page page) throws Exception {

        JSONObject jsonObject = new JSONObject();
        Map<String, Object> searchMap = new HashMap<>();

        Integer pageCnt = StringUtil.getInt(page.getPage(),1);
        Integer pageSize = StringUtil.getInt(page.getSize(),10);
        page.setPage(pageCnt);
        page.setSize(pageSize);
        searchMap.put("searchKeyword", StringUtil.getString(searchKeyword,""));
        searchMap.put("startPage", page.getStartPage());
        searchMap.put("size", pageSize);

        Integer newsListCnt = this.adminNewsApiService.getNewsListCnt(searchMap);
        List<NewNewsDTO> newsInfoList = null;

        if(newsListCnt > 0) {
            newsInfoList = this.adminNewsApiService.getNewsList(searchMap);
        }

        // 리스트 수
        jsonObject.put("pageSize", page.getSize());
        // 전체 페이지 수
        jsonObject.put("perPageListCnt", Math.ceil((newsListCnt-1)/page.getSize()+1));
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
    @PostMapping(value = "addNews")
    public void addNews(NewNewsDTO newNewsDTO) throws Exception {
        this.adminNewsApiService.addNews(newNewsDTO);
    }
}
