package com.tjint.springboot.common.urlLink.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface UrlLinkService {
    /**
     * <pre>
     * 1. MethodName : addUrlLink
     * 2. ClassName  : UrlLinkService.java
     * 3. Comment    : 링크 저장
     * 4. 작성자       : CHO
     * 5. 작성일       : 2021. 06. 03.
     * </pre>
     *
     * @param newUrlLinkDTO
     * @return
     * @throws Exception
     */
    Integer addUrlLink(HttpServletRequest request, NewUrlLinkDTO newUrlLinkDTO, String flag) throws Exception;
}
