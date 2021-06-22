package com.tjint.springboot.app.api.news.service.impl;

import com.tjint.springboot.app.api.news.service.AdminNewsApiService;
import com.tjint.springboot.app.api.news.service.NewNewsDTO;
import com.tjint.springboot.common.imageFile.AttachFileDTO;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import com.tjint.springboot.common.imageFile.service.impl.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service("AdminNewsApiService")
@RequiredArgsConstructor
public class AdminNewsApiServiceImpl implements AdminNewsApiService {

	private final AdminNewsApiMapper adminNewsApiMapper;
	private final ImageMapper imageMapper;

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
						  MultipartFile files) throws Exception {

		// 현재 날짜 구하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cl = Calendar.getInstance();
		String strToday = sdf.format(cl.getTime());
		// 파일 확장자
		String ext = files.getOriginalFilename().substring(files.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
		// 파일 Id
		String fileId = strToday.substring(4);
		// 파일 Mask
		String fileMask = strToday + '.' + ext;
		// 파일 Size
		long fileSize = files.getSize();

		newNewsDTO.setCreator(1);
		newNewsDTO.setUpdater(1);
		newImageDTO.setSortOrder(1);
		if (this.adminNewsApiMapper.addNews(newNewsDTO) > 0) {
			// 이미지 파일 정보 등록
			newImageDTO.setBoardTypeCd("brdt002");
			newImageDTO.setImageTypeCd("imgt001");
			newImageDTO.setBoardSeq(newNewsDTO.getNewsSeq());
			newImageDTO.setImageFileId(strToday);
			newImageDTO.setSortOrder(1);
			newImageDTO.setCreator(1);
			newImageDTO.setUpdater(1);
			newImageDTO.setVisible("Y");
			newImageDTO.setImageFileSeq(1);

			if (this.imageMapper.addImageFile(newImageDTO) > 0) {
				// 이미지 경로 및 정보 등록
				attachFileDTO.setFileId(fileId);
				attachFileDTO.setFileSeq(1);
				attachFileDTO.setFileSize(fileSize);
				attachFileDTO.setFileMask(fileMask);
				attachFileDTO.setFilePath("/Users/tj03/Documents/image/" + fileMask);
				attachFileDTO.setDownloadCnt(0);
				attachFileDTO.setFilename(files.getOriginalFilename());

				if(!new File("/Users/tj03/Documents/image/").exists()) {
					try {
						new File("/Users/tj03/Documents/image/").mkdir();
					}catch(Exception e) {
						e.getStackTrace();
					}
				}

				String filePath = "/Users/tj03/Documents/image/" + fileMask;
				files.transferTo(new File(filePath));

				if (this.imageMapper.addAttachFile(attachFileDTO) > 0) {
					return "Y";       // 등록 성공
				} else {
					return "N";
				}
			} else {
				return "N";       // 등록 실패
			}

		} else {
			return "N";       // 등록 실패
		}
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
	public Map<String, Object> getNewsInfo(NewNewsDTO newNewsDTO) throws Exception {
		return adminNewsApiMapper.getNewsInfo(newNewsDTO);
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
						   AttachFileDTO attachFileDTO,
						   MultipartFile files) throws Exception {
		// 현재 날짜 구하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cl = Calendar.getInstance();
		String strToday = sdf.format(cl.getTime());
		// 파일 확장자
		String ext = files.getOriginalFilename().substring(files.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
		// 파일 Id
		String fileId = strToday.substring(4);
		// 파일 Mask
		String fileMask = strToday + '.' + ext;
		// 파일 Size
		long fileSize = files.getSize();

		newNewsDTO.setUpdater(1);
		if (this.adminNewsApiMapper.updateNews(newNewsDTO) > 0) {
			// 이미지 파일 정보 등록
			newImageDTO.setBoardTypeCd("brdt002");
			newImageDTO.setImageTypeCd("imgt001");
			newImageDTO.setBoardSeq(newNewsDTO.getNewsSeq());
			newImageDTO.setImageFileId(strToday);
			newImageDTO.setSortOrder(1);
			newImageDTO.setCreator(1);
			newImageDTO.setUpdater(1);
			newImageDTO.setVisible("Y");
			newImageDTO.setImageFileSeq(1);
			imageMapper.deleteImageFile(newImageDTO);
			if (this.imageMapper.addImageFile(newImageDTO) > 0) {
				// 이미지 경로 및 정보 등록
				// 이미지 경로 및 정보 등록
				attachFileDTO.setFileId(fileId);
				attachFileDTO.setFileSeq(1);
				attachFileDTO.setFileSize(fileSize);
				attachFileDTO.setFileMask(fileMask);
				attachFileDTO.setFilePath("/Users/tj03/Documents/image/" + fileMask);
				attachFileDTO.setDownloadCnt(0);
				attachFileDTO.setFilename(files.getOriginalFilename());
				imageMapper.deleteAttachFile(attachFileDTO);
				if(!new File("/Users/tj03/Documents/image/").exists()) {
					try {
						new File("/Users/tj03/Documents/image/").mkdir();
					}catch(Exception e) {
						e.getStackTrace();
					}
				}

				String filePath = "/Users/tj03/Documents/image/" + fileMask;
				files.transferTo(new File(filePath));
				if (this.imageMapper.addAttachFile(attachFileDTO) > 0) {
					return "Y";       // 수정 성공
				} else {
					return "N";
				}
			} else {
				return "N";       // 수정 실패
			}

		} else {
			return "N";       // 수정 실패
		}
	}
}
