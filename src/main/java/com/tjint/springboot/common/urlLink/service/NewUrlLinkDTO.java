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

    @ApiModelProperty(required = true, value = "페이지 구분", hidden = true)
    private String boardTypeCd;

    @ApiModelProperty(required = true, value = "어드민 IDX", hidden = true)
    private Integer boardSeq;

    @ApiModelProperty(required = true, value = "링크 분류", hidden = true)
    private String linkTypeCd;

    @ApiModelProperty(required = true, value = "링크 주소", hidden = true)
    private String linkAddress;

    @ApiModelProperty(required = true, value = "링크 순서", hidden = true)
    private Integer sortOrder;

    @ApiModelProperty(required = true, value = "노출 여부", hidden = true)
    private String visible;

    @ApiModelProperty(required = true, value = "등록자", hidden = true)
    private Integer creator;

    @ApiModelProperty(required = true, value = "수정자", hidden = true)
    private Integer updater;

    @ApiModelProperty(required = false, value = "홈페이지 링크", hidden = true)
    private String brandLink;

    @ApiModelProperty(required = false, value = "홈페이지 링크 노출 여부", hidden = true)
    private String brandLinkVisible;

    @ApiModelProperty(required = false, value = "SNS 링크 노출 여부", hidden = true)
    private String snsListAll;
}
