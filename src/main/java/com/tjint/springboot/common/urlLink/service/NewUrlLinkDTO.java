package com.tjint.springboot.common.urlLink.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class NewUrlLinkDTO {
    @ApiModelProperty(required = true, value = "링크 IDX", hidden = true)
    private Integer linkSeq;

    @ApiModelProperty(required = true, value = "페이지 구분")
    private String boardTypeCd;

    @ApiModelProperty(required = true, value = "브랜드 IDX")
    private Integer brandSeq;

    @ApiModelProperty(required = true, value = "링크 분류")
    private String linkTypeCd;

    @ApiModelProperty(required = true, value = "링크 주소")
    private String linkAddress;

    @ApiModelProperty(required = true, value = "링크 순서")
    private Integer sortOrder;

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
