package com.tjint.springboot.app.api.news.controller;

import com.tjint.springboot.app.api.news.service.AdminNewsApiService;
import com.tjint.springboot.app.api.news.service.NewNewsDTO;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
