package com.tjint.springboot.app.api.admin.brand.service;

import com.tjint.springboot.common.NewCommonDTO;
import com.tjint.springboot.common.imageFile.AttachFileDTO;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel
public class NewBrandDTO extends NewCommonDTO {

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

    @ApiModelProperty(required = true, value = "등록시간", hidden = true)
    private String createTime;

    @ApiModelProperty(required = true, value = "수정일자", hidden = true)
    private String updateTime;

    @ApiModelProperty(required = true, value = "SNS 리스트", hidden = true)
    private List<NewUrlLinkDTO> snsLinkList;

    @ApiModelProperty(required = true, value = "Image 리스트", hidden = true)
    private List<AttachFileDTO> imageList;
}
