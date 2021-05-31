package com.tjint.springboot.common.imageFile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class NewImageDTO {
    @ApiModelProperty(required = true, value = "이미지 IDX")
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
}
