package com.tjint.springboot.common.imageFile;

import com.tjint.springboot.common.NewCommonDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class NewImageDTO extends NewCommonDTO {
    @ApiModelProperty(required = true, value = "이미지 IDX", hidden = true)
    private Integer imageFileInfoSeq;

    @ApiModelProperty(required = true, value = "대표or서브이미지 구분 여부", hidden = true)
    private String imageTypeCd;

    @ApiModelProperty(required = true, value = "대표이미지ID", hidden = true)
    private String imageFileId;

    @ApiModelProperty(required = true, value = "이미지 테이블 IDX", hidden = true)
    private Integer imageFileSeq;

    @ApiModelProperty(required = true, value = "노출 순서", hidden=true)
    private Integer sortOrder;

    @ApiModelProperty(required = true, value = "노출 여부", hidden=true)
    private String visible;

    @ApiModelProperty(required = true, value = "페이지 구분", hidden=true)
    private String boardTypeCd;

    @ApiModelProperty(required = true, value = "브랜드 구분", hidden=true)
    private Integer boardSeq;

}
