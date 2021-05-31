package com.tjint.springboot.app.api.brand.service;

import com.tjint.springboot.common.imageFile.NewImageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class NewBrandDTO extends NewImageDTO {

    @ApiModelProperty(required = true, value = "브랜드 IDX", hidden = true)
    private Integer brandSeq;
    @ApiModelProperty(required = true, value = "카테고리 value")
    private String categoryCd;
    @ApiModelProperty(required = true, value = "분야 카테고리 value")
    private String menuCategoryCd;
    @ApiModelProperty(required = true, value = "분야 카테고리 이름")
    private String menuCategoryNm;
    @ApiModelProperty(required = true, value = "브랜드 이름")
    private String brandName;
    @ApiModelProperty(required = true, value = "브랜드 설명")
    private String brandDescription;
    @ApiModelProperty(required = true, value = "노출 여부")
    private String visible;
    @ApiModelProperty(required = true, value = "등록자")
    private Integer creator;
    @ApiModelProperty(required = true, value = "등록시간")
    private String createTime;
    @ApiModelProperty(required = true, value = "수정자")
    private Integer updater;
    @ApiModelProperty(required = true, value = "수정일자")
    private String updateTime;
}
