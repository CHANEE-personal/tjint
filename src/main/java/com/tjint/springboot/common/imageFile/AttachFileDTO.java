package com.tjint.springboot.common.imageFile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class AttachFileDTO {
    @ApiModelProperty(required = true, value = "파일ID")
    private String fileId;

    @ApiModelProperty(required = true, value = "파일구분")
    private Integer fileSeq;

    @ApiModelProperty(required = true, value = "파일명")
    private String fileName;

    @ApiModelProperty(required = true, value = "파일SIZE")
    private Integer fileSize;

    @ApiModelProperty(required = true, value = "파일MASK")
    private String fileMask;

    @ApiModelProperty(required = true, value = "파일경로")
    private String filePath;

    @ApiModelProperty(required = true, value = "다운로드횟수")
    private Integer downloadCnt;

    @ApiModelProperty(required = true, value = "다운로드 제한날짜")
    private String downloadExpireDate;

    @ApiModelProperty(required = true, value = "다운로드 제한횟수")
    private Integer downloadLimitCnt;

    @ApiModelProperty(required = true, value = "등록일자")
    private String regDate;

    @ApiModelProperty(required = true, value = "삭제여부")
    private String deleteYn;
}
