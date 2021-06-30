package com.tjint.springboot.app.api.business.service.impl;

import com.tjint.springboot.app.api.brand.service.NewBrandDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FrontBusinessApiMapper {
	/**
	 * <pre>
	 * 1. MethodName : getBrandList
	 * 2. ClassName  : FrontBusinessApiMapper.java
	 * 3. Comment    : BrandList
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 30.
	 * </pre>
	 *
	 * @param brandMap
	 * @return
	 * @throws Exception
	 */
	public List<NewBrandDTO> getBrandList(Map<String, Object> brandMap) throws Exception;
}
