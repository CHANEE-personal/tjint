package com.tjint.springboot.app.api.admin.login.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotEmpty;

@Getter
@Setter
@ApiModel
public class NewUserDTO {
	@ApiModelProperty(required = true, value = "user Seq", hidden = true)
	String userSeq;

	@NotEmpty
	@ApiModelProperty(required = true, value = "user Id")
	String userId;

	@NotEmpty
	@ApiModelProperty(required = true, value = "user Password")
	String password;

	@ApiModelProperty(required = true, value = "user Name", hidden = true)
	String userName;

	@ApiModelProperty(required = true, value = "user Type", hidden = true)
	String userTypeCd;

	@ApiModelProperty(required = false, value = "user Token", hidden = true)
	String userToken;
}
