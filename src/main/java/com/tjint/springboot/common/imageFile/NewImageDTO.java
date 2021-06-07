package com.tjint.springboot.common.imageFile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class NewImageDTO {
    @ApiModelProperty(required = true, value = "이미지 IDX", hidden = true)
    private Integer imageFileInfoSeq;

    @ApiModelProperty(required = true, value = "대표or서브이미지 구분 여부")
    private String imageTypeCd;

    @ApiModelProperty(required = true, value = "대표이미지ID")
    private String imageFileId;

    @ApiModelProperty(required = true, value = "대표이미지명")
    private String imageFileName;

    @ApiModelProperty(required = true, value = "이미지 테이블 IDX")
    private Integer imageFileSeq;

    @ApiModelProperty(required = true, value = "이미지 경로")
    private String imageFilePath;

    @ApiModelProperty(required = true, value = "노출 순서")
    private Integer sortOrder;

    @ApiModelProperty(required = true, value = "페이지 구분")
    private String boardTypeCd;

    @ApiModelProperty(required = true, value = "등록자")
    private Integer creator;

    @ApiModelProperty(required = true, value = "등록시간")
    private String createTime;

    @ApiModelProperty(required = true, value = "수정자")
    private Integer updater;

    @ApiModelProperty(required = true, value = "수정일자")
    private String updateTime;
}
