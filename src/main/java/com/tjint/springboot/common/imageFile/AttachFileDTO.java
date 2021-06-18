package com.tjint.springboot.common.imageFile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class AttachFileDTO {
    @ApiModelProperty(value = "파일ID", hidden = true)
    private String fileId;

    @ApiModelProperty(value = "파일구분", hidden = true)
    private Integer fileSeq;

    @ApiModelProperty(required = true, value = "파일명")
    private String fileName;

    @ApiModelProperty(value = "파일SIZE", hidden = true)
    private Long fileSize;

    @ApiModelProperty(value = "파일MASK", hidden = true)
    private String fileMask;

    @ApiModelProperty(value = "파일경로", hidden = true)
    private String filePath;

    @ApiModelProperty(value = "다운로드횟수", hidden = true)
    private Integer downloadCnt;

    @ApiModelProperty(value = "다운로드 제한날짜", hidden = true)
    private String downloadExpireDate;

    @ApiModelProperty(value = "다운로드 제한횟수", hidden = true)
    private Integer downloadLimitCnt;

    @ApiModelProperty(value = "등록일자", hidden = true)
    private String regDate;

    @ApiModelProperty(value = "삭제여부", hidden = true)
    private String deleteYn;
}
