package com.tjint.springboot.app.api.admin.news.service;

import com.tjint.springboot.app.exception.ApiException;
import com.tjint.springboot.common.imageFile.AttachFileDTO;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public interface AdminNewsApiService {

	/**
	 * <pre>
	 * 1. MethodName : getNewsListCnt
	 * 2. ClassName  : AdminNewsApiService.java
	 * 3. Comment    : News 리스트 갯수
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 08.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	Integer getNewsListCnt(Map<String, Object> searchMap) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : getNewsList
	 * 2. ClassName  : AdminNewsApiService.java
	 * 3. Comment    : News 리스트
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 08.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	List<NewNewsDTO> getNewsList(Map<String, Object> searchMap) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : addNews
	 * 2. ClassName  : AdminNewsApiService.java
	 * 3. Comment    : News 등록
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 08.
	 * </pre>
	 *
	 * @param newNewsDTO
	 * @return
	 * @throws Exception
	 */
	String addNews(NewNewsDTO newNewsDTO,
				   NewImageDTO newImageDTO,
				   AttachFileDTO attachFileDTO,
				   MultipartFile[] files,
				   HttpServletRequest request) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : getNewsInfo
	 * 2. ClassName  : AdminNewsApiService.java
	 * 3. Comment    : News 상세조회
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 17.
	 * </pre>
	 *
	 * @param  newNewsDTO
	 * @return ConcurrentHashMap
	 * @throws Exception
	 */
	ConcurrentHashMap<String, Object> getNewsInfo(NewNewsDTO newNewsDTO) throws Exception;

	/**
	 * <pre>
	 * 1. MethodName : updateNews
	 * 2. ClassName  : AdminNewsApiService.java
	 * 3. Comment    : News 수정
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 18.
	 * </pre>
	 *
	 * @param newNewsDTO
	 * @return
	 * @throws Exception
	 */
	String updateNews(NewNewsDTO newNewsDTO,
					  NewImageDTO newImageDTO,
					  MultipartFile[] files,
					  HttpServletRequest request) throws Exception;
}
