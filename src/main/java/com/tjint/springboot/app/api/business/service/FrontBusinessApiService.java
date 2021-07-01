package com.tjint.springboot.app.api.business.service;

import com.tjint.springboot.app.api.brand.service.NewBrandDTO;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface FrontBusinessApiService {

	/**
	 * <pre>
	 * 1. MethodName : getBrandList
	 * 2. ClassName  : FrontBusinessApiService.java
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

	/**
	 * <pre>
	 * 1. MethodName : getSnsLinkList
	 * 2. ClassName  : FrontBusinessApiService.java
	 * 3. Comment    : Brand SNS Link
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 30.
	 * </pre>
	 *
	 * @param brandIdx
	 * @return
	 * @throws Exception
	 */
	public List<NewUrlLinkDTO> getSnsLinkList(Integer brandIdx) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : getImageList
	 * 2. ClassName  : FrontBusinessApiService.java
	 * 3. Comment    : Brand Image List
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 30.
	 * </pre>
	 *
	 * @param brandIdx
	 * @return
	 * @throws Exception
	 */
	public List<NewImageDTO> getImageList(Integer brandIdx) throws Exception;
}
