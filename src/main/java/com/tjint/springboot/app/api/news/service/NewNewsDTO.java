package com.tjint.springboot.app.api.news.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class NewNewsDTO {

    @ApiModelProperty(required = true, value = "NEWS IDX", hidden = true)
    private Integer newsSeq;

    @ApiModelProperty(required = true, value = "NEWS 제목")
    private String newsTitle;

    @ApiModelProperty(required = true, value = "NEWS 내용")
    private String newsDescription;

    @ApiModelProperty(required = true, value = "노출 여부")
    private String visible;

    @ApiModelProperty(required = true, value = "등록자")
    private Integer creator;

    @ApiModelProperty(required = true, value = "수정자")
    private Integer updater;
}
