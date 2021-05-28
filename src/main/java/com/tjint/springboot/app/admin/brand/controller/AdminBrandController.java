package com.tjint.springboot.app.admin.brand.controller;

import com.tjint.springboot.app.admin.brand.service.AdminBrandService;
import com.tjint.springboot.app.admin.brand.service.SnsInfoVo;
import com.tjint.springboot.common.BrandInfoVo;
import com.tjint.springboot.common.CodeVo;
import com.tjint.springboot.common.paging.Page;
import com.tjint.springboot.common.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @package : com.tjint.springboot.app.admin.brand.controller
 * @method : AdminBrandController
 * @date : 12/05/2021 5:33 오후
 * @author : chanee
 * @version : 1.0.0
 * @modifyed : 브랜드관리
 **/
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/business")
public class AdminBrandController {
    private final AdminBrandService adminBrandService;

    /**
     * @package : com.tjint.springboot.app.admin.brand.controller
     * @method : brandList
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드관리
     **/

    @GetMapping(value = "/brandList/{searchKeyword}")
    public JSONObject brandList(String searchKeyword, Page page) throws Exception {

        JSONObject jsonObject = new JSONObject();

        Map<String, Object> searchMap = new HashMap<>();

        searchMap.put("searchKeyword", StringUtil.getString(searchKeyword,""));
        searchMap.put("size", page.getSize());
        searchMap.put("startPage", page.getStartPage());

        Integer brandListCnt = this.adminBrandService.getBrandListCnt(searchMap);
        List<BrandInfoVo> brandList = null;

        if(brandListCnt > 0) {
            brandList = this.adminBrandService.getBrandList(searchMap);
        }

        final CodeVo codeVo = new CodeVo();
        codeVo.setParentCd("ct000");
        final List<SnsInfoVo> codeList = this.adminBrandService.getCodeList(codeVo);

        jsonObject.put("brandList", brandList);
        jsonObject.put("codeList", codeList);

        return jsonObject;
    }

    /**
     * @package : com.tjint.springboot.app.admin.brand.controller
     * @method : brandInfo
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드 상세
     **/
    @GetMapping(value = "/brandInfo/{brandSeq}")
    public JSONObject brandInfo(BrandInfoVo brandInfoVo) throws Exception {
        JSONObject jsonObject = new JSONObject();

        Map<String, Object> brandMap = this.adminBrandService.getBrandInfo(brandInfoVo);

        jsonObject.put("brandMap", brandMap);

        return jsonObject;
    }

    /**
     * @package : com.tjint.springboot.app.admin.brand.controller
     * @method : addBrand
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드 등록
     **/
    @PostMapping(value = "/addBrand")
    public JSONObject addBrand(BrandInfoVo brandInfoVo) throws Exception {
        JSONObject jsonObject = new JSONObject();
        if(StringUtil.getInt(this.adminBrandService.addBrand(brandInfoVo),0) > 0) {
            jsonObject.put("insertYn", "Y");
            jsonObject.put("message", "등록되었습니다.");
        } else {
            jsonObject.put("insertYn", "N");
            jsonObject.put("message", "등록에 실패하였습니다.");
        }

        return jsonObject;
    }

    /**
     * @package : com.tjint.springboot.app.admin.brand.controller
     * @method : modifyBrand
     * @date : 12/05/2021 5:33 오후
     * @author : chanee
     * @version : 1.0.0
     * @modifyed : 브랜드수정
     **/
    @PutMapping(value = "/modifyBrand/{brandSeq}")
    public JSONObject modifyBrand(BrandInfoVo brandInfoVo) throws Exception {
        JSONObject jsonObject = new JSONObject();

        if(StringUtil.getInt(this.adminBrandService.modifyBrand(brandInfoVo),0) > 0) {
            jsonObject.put("updateYn", "Y");
            jsonObject.put("message", "수정되었습니다.");
        } else {
            jsonObject.put("updateYn", "N");
            jsonObject.put("message", "수정에 실패하였습니다.");
        }

        return jsonObject;
    }
}
