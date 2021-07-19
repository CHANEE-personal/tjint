package com.tjint.springboot.app.api.brand.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class NewCodeDTO {
	@ApiModelProperty(required = true, value = "code Id", hidden = true)
	private String codeId;

	@ApiModelProperty(required = true, value = "code Name")
	private String codeName;

	@ApiModelProperty(required = false, value = "code Value", hidden = true)
	private String codeValue;

	@ApiModelProperty(required = true, value = "description", hidden = true)
	private String description;

	@ApiModelProperty(required = true, value = "parentCd", hidden = true)
	private String parentCd;

	@ApiModelProperty(required = true, value = "property1", hidden = true)
	private String property1;

	@ApiModelProperty(required = true, value = "property2", hidden = true)
	private String property2;

	@ApiModelProperty(required = true, value = "property3", hidden = true)
	private String property3;

	@ApiModelProperty(required = true, value = "property4", hidden = true)
	private String property4;

	@ApiModelProperty(required = true, value = "property5", hidden = true)
	private String property5;

	@ApiModelProperty(required = true, value = "순서", hidden = true)
	private String sortOrder;

	@ApiModelProperty(required = true, value = "노출여부")
	private String visible;

	@ApiModelProperty(required = true, value = "등록자", hidden = true)
	private Integer creator;

	@ApiModelProperty(required = true, value = "등록시간", hidden = true)
	private String createTime;

	@ApiModelProperty(required = true, value = "수정자", hidden = true)
	private Integer updater;

	@ApiModelProperty(required = true, value = "수정일자", hidden = true)
	private String updateTime;
}
