package com.tjint.springboot.app.api.recruit.service;

import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class NewRecruitDTO extends NewUrlLinkDTO {

	@ApiModelProperty(required = true, value = "채용공고 IDX", hidden = true)
	private Integer recruitSeq;

	@ApiModelProperty(required = true, value = "채용공고 제목")
	private String recruitTitle;

	@ApiModelProperty(required = false, value = "채용공고 상세", hidden = true)
	private String recruitDescription;

	@ApiModelProperty(required = false, value = "채용사이트")
	private String jobsValues;

	@ApiModelProperty(required = true, value = "오픈일자")
	private String time1;

	@ApiModelProperty(required = true, value = "종료일자")
	private String time2;

	@ApiModelProperty(required = true, value = "노출여부")
	private String visible;

	@ApiModelProperty(required = true, value = "등록자", hidden=true)
	private Integer creator;

	@ApiModelProperty(required = true, value = "수정자", hidden=true)
	private Integer updater;
}
