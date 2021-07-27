package com.tjint.springboot.common.urlLink.service.impl;

import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import com.tjint.springboot.common.urlLink.service.UrlLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("UrlLinkService")
@RequiredArgsConstructor
public class UrlLinkServiceImpl implements UrlLinkService {
    private final UrlLinkMapper urlLinkMapper;

    public Integer addUrlLink(NewUrlLinkDTO newUrlLinkDTO, String flag) throws Exception {

        if("Y".equals(newUrlLinkDTO.getBrandLinkVisible())) {
            newUrlLinkDTO.setBoardTypeCd("brdt001");
            newUrlLinkDTO.setLinkTypeCd("lnkt001");
            newUrlLinkDTO.setLinkAddress(newUrlLinkDTO.getBrandLink());
            newUrlLinkDTO.setSortOrder(1);
            newUrlLinkDTO.setCreator(1);
            newUrlLinkDTO.setUpdater(1);
            newUrlLinkDTO.setVisible("Y");

            // 홈페이지 링크 등록
            if("U".equals(flag)) {
                urlLinkMapper.updateUrlLink(newUrlLinkDTO);
            } else {
                urlLinkMapper.addUrlLink(newUrlLinkDTO);
            }
        }

        String[] snsArr = newUrlLinkDTO.getSnsListAll().split(";");
        for(int i = 0; i < snsArr.length; i++) {
            newUrlLinkDTO.setBoardTypeCd("brdt001");
            newUrlLinkDTO.setSortOrder(i+1);
            newUrlLinkDTO.setCreator(1);
            newUrlLinkDTO.setUpdater(1);
            String[] sns = snsArr[i].split(",");
            if(i == 0) {
                if ("Y".equals(sns[1])) {
                    newUrlLinkDTO.setVisible("Y");
                    newUrlLinkDTO.setLinkTypeCd(sns[0]);
                    newUrlLinkDTO.setLinkAddress(sns[2]);
                } else {
                    newUrlLinkDTO.setLinkTypeCd(sns[0]);
                    newUrlLinkDTO.setVisible("N");
                    newUrlLinkDTO.setLinkAddress("");
                }
            } else {
                if ("Y".equals(sns[2])) {
                    newUrlLinkDTO.setVisible("Y");
                    newUrlLinkDTO.setLinkTypeCd(sns[1].replace(",",""));
                    newUrlLinkDTO.setLinkAddress(sns[3]);
                } else {
                    newUrlLinkDTO.setLinkTypeCd(sns[1].replace(",",""));
                    newUrlLinkDTO.setVisible("N");
                    newUrlLinkDTO.setLinkAddress("");
                }
            }

            // snsLink 등록
            if("U".equals(flag)) {
                urlLinkMapper.updateUrlLink(newUrlLinkDTO);
            } else {
                urlLinkMapper.addUrlLink(newUrlLinkDTO);
            }
        }

        return 1;
    }
}
