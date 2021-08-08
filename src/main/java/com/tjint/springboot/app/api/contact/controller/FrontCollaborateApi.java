package com.tjint.springboot.app.api.contact.controller;

import com.tjint.springboot.app.api.recruit.service.AdminRecruitApiService;
import com.tjint.springboot.app.api.recruit.service.NewRecruitDTO;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.rmi.ServerError;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Api(tags = "FRONT CONTACT API")
@RequestMapping(value = "/api/contact")
@RestController
@RequiredArgsConstructor
public class FrontCollaborateApi {

    private final AdminRecruitApiService adminRecruitApiService;

    @ApiOperation(value = "Front 협업 및 제휴 페이지", notes = "Front 협업 및 제휴 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/collaborates")
    public String collaborates() throws Exception {
        return "collaborates";
    }

    @ApiOperation(value = "Front 인재채용 페이지", notes = "Front 인재채용 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/recruits")
    public ConcurrentHashMap recruits(HttpServletRequest request, Page page) throws Exception {

        ConcurrentHashMap<String, Object> recruitMap = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Object> searchMap = new ConcurrentHashMap<>();

        Integer pageCnt = StringUtil.getInt(page.getPage(), 1);
        Integer pageSize = StringUtil.getInt(page.getSize(), 10);
        page.setPage(pageCnt);
        page.setSize(pageSize);
        searchMap.put("startPage", page.getStartPage());
        searchMap.put("size", pageSize);

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

    @ApiOperation(value = "Front 윤리경영 페이지", notes = "Front 윤리경영 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/ethics-committees")
    public String ethicsCommittees() throws Exception {
        return "ethicsCommittees";
    }

    @ApiOperation(value = "Front 오시는 길 페이지", notes = "Front 오시는 길 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공", response = Map.class),
            @ApiResponse(code = 403, message = "접근거부", response = HttpClientErrorException.class),
            @ApiResponse(code = 500, message = "서버 에러", response = ServerError.class)
    })
    @GetMapping(value = "/map")
    public String map() throws Exception {
        return "map";
    }
}
