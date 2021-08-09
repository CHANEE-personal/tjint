package com.tjint.springboot.app.api.admin.brand.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public interface AdminCategoryApiService {
	/**
	 * <pre>
	 * 1. MethodName : getCategoryListCnt
	 * 2. ClassName  : AdminBrandApiService.java
	 * 3. Comment    : 분야 리스트 갯수
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 07.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	Integer getCategoryListCnt(Map<String, Object> searchMap) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : getCategoryList
	 * 2. ClassName  : AdminBrandApiService.java
	 * 3. Comment    : 분야 리스트
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 07.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	List<NewCodeDTO> getCategoryList(Map<String, Object> searchMap) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : getCategoryInfo
	 * 2. ClassName  : AdminBrandApiService.java
	 * 3. Comment    : 분야 상세
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 08.
	 * </pre>
	 *
	 * @param newCodeDTO
	 * @return
	 * @throws Exception
	 */
	ConcurrentHashMap<String, Object> getCategoryInfo(NewCodeDTO newCodeDTO) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : insertCategory
	 * 2. ClassName  : AdminBrandApiService.java
	 * 3. Comment    : 분야 등록
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 08.
	 * </pre>
	 *
	 * @param newCodeDTO
	 * @return
	 * @throws Exception
	 */
	String insertCategory(NewCodeDTO newCodeDTO) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : updateCategory
	 * 2. ClassName  : AdminBrandApiService.java
	 * 3. Comment    : 분야 수정
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 07. 08.
	 * </pre>
	 *
	 * @param newCodeDTO
	 * @return
	 * @throws Exception
	 */
	String updateCategory(NewCodeDTO newCodeDTO) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : addSns
	 * 2. ClassName  : AdminBrandApiService.java
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
	Integer addSns(NewCodeDTO newCodeDTO, MultipartFile files) throws Exception;
}
