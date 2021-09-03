package com.tjint.springboot.app.api.admin.brand.service.impl;

import com.tjint.springboot.app.api.admin.brand.service.AdminCategoryApiService;
import com.tjint.springboot.app.api.admin.brand.service.NewCodeDTO;
import com.tjint.springboot.common.imageFile.service.ImageService;
import com.tjint.springboot.common.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("AdminCategoryApiService")
@RequiredArgsConstructor
public class AdminCategoryApiServiceImpl implements AdminCategoryApiService {

	private final AdminCategoryApiMapper adminCategoryApiMapper;
	private final ImageService imageService;

	/**
	 * <pre>
	 * 1. MethodName : getCategoryListCnt
	 * 2. ClassName  : AdminBrandApiServiceImpl.java
	 * 3. Comment    : 분야 리스트 갯수
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 07.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	public Integer getCategoryListCnt(Map<String, Object> searchMap) throws Exception {
		return adminCategoryApiMapper.getCategoryListCnt(searchMap);
	}

	/**
	 * <pre>
	 * 1. MethodName : getCategoryList
	 * 2. ClassName  : AdminBrandApiServiceImpl.java
	 * 3. Comment    : 분야 리스트
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 07.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	public List<NewCodeDTO> getCategoryList(Map<String, Object> searchMap) throws Exception {
		return adminCategoryApiMapper.getCategoryList(searchMap);
	}

	/**
	 * <pre>
	 * 1. MethodName : getCategoryInfo
	 * 2. ClassName  : AdminBrandApiServiceImpl.java
	 * 3. Comment    : 분야 상세
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 08.
	 * </pre>
	 *
	 * @param newCodeDTO
	 * @return
	 * @throws Exception
	 */
	public ConcurrentHashMap<String, Object> getCategoryInfo(NewCodeDTO newCodeDTO) throws Exception {
		ConcurrentHashMap<String, Object> categoryMap = new ConcurrentHashMap<>();
		categoryMap.put("categoryInfo", adminCategoryApiMapper.getCategoryInfo(newCodeDTO));
		return categoryMap;
	}

	/**
	 * <pre>
	 * 1. MethodName : insertCategory
	 * 2. ClassName  : AdminBrandApiServiceImpl.java
	 * 3. Comment    : 분야 등록
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 08.
	 * </pre>
	 *
	 * @param newCodeDTO
	 * @return
	 * @throws Exception
	 */
	public String insertCategory(NewCodeDTO newCodeDTO, HttpServletRequest request) throws Exception {
		String result = "";

		newCodeDTO.setDescription(newCodeDTO.getCodeName());
		newCodeDTO.setParentCd("ct000");
		newCodeDTO.setCodeValue(" ");

		if(this.adminCategoryApiMapper.insertCategory(newCodeDTO) > 0) {
			result = "Y";
		} else {
			result = "N";
		}

		return result;
	}

	/**
	 * <pre>
	 * 1. MethodName : updateCategory
	 * 2. ClassName  : AdminBrandApiServiceImpl.java
	 * 3. Comment    : 분야 수정
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 08.
	 * </pre>
	 *
	 * @param newCodeDTO
	 * @return
	 * @throws Exception
	 */
	public String updateCategory(NewCodeDTO newCodeDTO, HttpServletRequest request) throws Exception {
		String result = "";

		if(this.adminCategoryApiMapper.updateCategory(newCodeDTO) > 0) {
			result = "Y";
		} else {
			result = "N";
		}

		return result;
	}

	/**
	 * <pre>
	 * 1. MethodName : addSns
	 * 2. ClassName  : AdminBrandApiServiceImpl.java
	 * 3. Comment    : SNS 등록
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 18.
	 * </pre>
	 *
	 * @param newCodeDTO
	 * @param files
	 * @return
	 * @throws Exception
	 */
	public String addSns(NewCodeDTO newCodeDTO, MultipartFile[] files, HttpServletRequest request) throws Exception {
		newCodeDTO.setParentCd("lnkt002");
		newCodeDTO.setDescription(newCodeDTO.getCodeName());
		newCodeDTO.setCodeValue(" ");

		String result = "";
		if(this.adminCategoryApiMapper.addSns(newCodeDTO) > 0) {
			if ("Y".equals(StringUtil.getString(imageService.uploadImageFile(newCodeDTO, files, request),""))) {
				result = "Y";
			} else {
				result = "N";
			}
		} else {
			result = "N";
		}

		return result;
	}

	/**
	 * <pre>
	 * 1. MethodName : updateSns
	 * 2. ClassName  : AdminBrandApiServiceImpl.java
	 * 3. Comment    : SNS 수정
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 18.
	 * </pre>
	 *
	 * @param newCodeDTO
	 * @param files
	 * @return
	 * @throws Exception
	 */
	public String updateSns(NewCodeDTO newCodeDTO, MultipartFile[] files, HttpServletRequest request) throws Exception {
		newCodeDTO.setParentCd("lnkt002");
		newCodeDTO.setCodeValue(" ");

		String result = "";

		if(this.adminCategoryApiMapper.updateSns(newCodeDTO) > 0) {
			if ("Y".equals(StringUtil.getString(imageService.uploadImageFile(newCodeDTO, files, request),""))) {
				result = "Y";
			} else {
				result = "N";
			}
		} else {
			result = "N";
		}

		return result;
	}
}
