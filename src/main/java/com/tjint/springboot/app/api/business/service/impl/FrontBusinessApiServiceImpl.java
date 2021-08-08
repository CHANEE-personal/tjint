package com.tjint.springboot.app.api.business.service.impl;

import com.tjint.springboot.app.api.brand.service.NewBrandDTO;
import com.tjint.springboot.app.api.business.service.FrontBusinessApiService;
import com.tjint.springboot.common.imageFile.AttachFileDTO;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("FrontBusinessApiService")
@RequiredArgsConstructor
public class FrontBusinessApiServiceImpl implements FrontBusinessApiService {

	private final FrontBusinessApiMapper frontBusinessApiMapper;

	/**
	 * <pre>
	 * 1. MethodName : getBrandList
	 * 2. ClassName  : FrontBusinessApiServiceImpl.java
	 * 3. Comment    : BrandList
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 30.
	 * </pre>
	 *
	 * @param  brandMap
	 * @return ConcurrentHashMap
	 * @throws Exception
	 */
	public ConcurrentHashMap<String, Object> getBrandList(Map<String, Object> brandMap) throws Exception {
		ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

		NewBrandDTO newBrandDTO = new NewBrandDTO();

		List<NewBrandDTO> brandList = this.frontBusinessApiMapper.getBrandList(brandMap);
		int brandCount = this.frontBusinessApiMapper.getBrandList(brandMap).size();

		for(int i = 0; i < brandCount; i++) {
			newBrandDTO.setSnsLinkList(this.frontBusinessApiMapper.getSnsLinkList(brandList.get(i).getBrandSeq()));
			newBrandDTO.setImageList(this.frontBusinessApiMapper.getImageList(brandList.get(i).getBrandSeq()));
		}

		resultMap.put("brandList", brandList);

		return resultMap;
	}

	/**
	 * <pre>
	 * 1. MethodName : getSnsLinkList
	 * 2. ClassName  : FrontBusinessApiServiceImpl.java
	 * 3. Comment    : Brand SNS Link
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 30.
	 * </pre>
	 *
	 * @param brandIdx
	 * @return
	 * @throws Exception
	 */
	public List<NewUrlLinkDTO> getSnsLinkList(Integer brandIdx) throws Exception {
		return this.frontBusinessApiMapper.getSnsLinkList(brandIdx);
	}

	/**
	 * <pre>
	 * 1. MethodName : getImageList
	 * 2. ClassName  : FrontBusinessApiServiceImpl.java
	 * 3. Comment    : Brand Image List
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 30.
	 * </pre>
	 *
	 * @param brandIdx
	 * @return
	 * @throws Exception
	 */
	public List<AttachFileDTO> getImageList(Integer brandIdx) throws Exception {
		return this.frontBusinessApiMapper.getImageList(brandIdx);
	}
}
