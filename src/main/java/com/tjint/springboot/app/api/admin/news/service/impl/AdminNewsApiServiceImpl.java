package com.tjint.springboot.app.api.admin.news.service.impl;

import com.tjint.springboot.app.api.admin.news.service.AdminNewsApiService;
import com.tjint.springboot.app.api.admin.news.service.NewNewsDTO;
import com.tjint.springboot.app.api.common.SearchCommon;
import com.tjint.springboot.common.imageFile.AttachFileDTO;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.imageFile.service.ImageService;
import com.tjint.springboot.common.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("AdminNewsApiService")
@RequiredArgsConstructor
public class AdminNewsApiServiceImpl implements AdminNewsApiService {

	private final AdminNewsApiMapper adminNewsApiMapper;
	private final ImageService imageService;
	private final SearchCommon searchCommon;

	/**
	 * <pre>
	 * 1. MethodName : getNewsListCnt
	 * 2. ClassName  : AdminNewsApiServiceImpl.java
	 * 3. Comment    : News 리스트 갯수
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 08.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	public Integer getNewsListCnt(Map<String, Object> searchMap) throws Exception {
		return adminNewsApiMapper.getNewsListCnt(searchMap);
	}

	/**
	 * <pre>
	 * 1. MethodName : getNewsList
	 * 2. ClassName  : AdminNewsApiServiceImpl.java
	 * 3. Comment    : News 리스트
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 08.
	 * </pre>
	 *
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	public List<NewNewsDTO> getNewsList(Map<String, Object> searchMap) throws Exception {
		return adminNewsApiMapper.getNewsList(searchMap);
	}

	/**
	 * <pre>
	 * 1. MethodName : addNews
	 * 2. ClassName  : AdminNewsApiServiceImpl.java
	 * 3. Comment    : News 등록
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 08.
	 * </pre>
	 *
	 * @param newNewsDTO
	 * @return
	 * @throws Exception
	 */
	public String addNews(NewNewsDTO newNewsDTO,
						  NewImageDTO newImageDTO,
						  AttachFileDTO attachFileDTO,
						  MultipartFile[] files, HttpServletRequest request) throws Exception {

		String resultMsg = "";

		// JWT token 값 존재 시 유저 인증 값 부여
		searchCommon.giveAuth(request, newNewsDTO);

		newImageDTO.setSortOrder(1);
		newImageDTO.setBoardTypeCd("brdt002");

		String flag = "A";
		if (adminNewsApiMapper.addNews(newNewsDTO) > 0) {
			newImageDTO.setBoardSeq(newNewsDTO.getNewsSeq());
			// 이미지 파일 등록
			if (StringUtil.getInt(imageService.addImageFile(request, newImageDTO, files, flag),0) > 0) {
				resultMsg = "Y";
			} else {
				resultMsg = "N";      // 이미지 파일 정보 insert 실패
			}
		} else {
			resultMsg = "N";            // 브랜드 등록 실패
		}

		return resultMsg;
	}

	/**
	 * <pre>
	 * 1. MethodName : getNewsInfo
	 * 2. ClassName  : AdminNewsApiServiceImpl.java
	 * 3. Comment    : News 상세 페이지 조회
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 17.
	 * </pre>
	 *
	 * @param newNewsDTO
	 * @return
	 * @throws Exception
	 */
	public ConcurrentHashMap<String, Object> getNewsInfo(NewNewsDTO newNewsDTO) throws Exception {
		ConcurrentHashMap<String, Object> newsMap = new ConcurrentHashMap<>();
		newsMap.put("newsInfo", adminNewsApiMapper.getNewsInfo(newNewsDTO));
		return newsMap;
	}

	/**
	 * <pre>
	 * 1. MethodName : updateNews
	 * 2. ClassName  : AdminNewsApiServiceImpl.java
	 * 3. Comment    : News 수정
	 * 4. 작성자       : CHO
	 * 5. 작성일       : 2021. 06. 18.
	 * </pre>
	 *
	 * @param newNewsDTO
	 * @return
	 * @throws Exception
	 */
	public String updateNews(NewNewsDTO newNewsDTO,
							 NewImageDTO newImageDTO,
							 MultipartFile[] files,
							 HttpServletRequest request) throws Exception {
		String resultMsg = "";

		// JWT token 값 존재 시 유저 인증 값 부여
		searchCommon.giveAuth(request, newNewsDTO);

		newImageDTO.setSortOrder(1);
		newImageDTO.setBoardTypeCd("brdt002");

		String flag = "U";
		if (adminNewsApiMapper.updateNews(newNewsDTO) > 0) {
			newImageDTO.setBoardSeq(newNewsDTO.getNewsSeq());
			if(files != null) {
				// 이미지 파일 등록
				if (StringUtil.getInt(imageService.addImageFile(request, newImageDTO, files, flag),0) > 0) {
					resultMsg = "Y";
				} else {
					resultMsg = "N";      // 이미지 파일 정보 insert 실패
				}
			} else {
				resultMsg = "Y";
			}
		} else {
			resultMsg = "N";            // 브랜드 등록 실패
		}

		return resultMsg;
	}
}
