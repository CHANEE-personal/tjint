package com.tjint.springboot.common.urlLink.service.impl;

import com.tjint.springboot.app.api.brand.service.NewBrandDTO;
import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import com.tjint.springboot.common.urlLink.service.UrlLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("UrlLinkService")
@RequiredArgsConstructor
public class UrlLinkServiceImpl implements UrlLinkService {
    private final UrlLinkMapper urlLinkmapper;

    public String addUrlLink(NewUrlLinkDTO newUrlLinkDTO) throws Exception {

        NewBrandDTO newBrandDTO = new NewBrandDTO();
        newUrlLinkDTO.setBrandSeq(newBrandDTO.getBrandSeq());
        newUrlLinkDTO.setBoardTypeCd("brdt001");
        newUrlLinkDTO.setLinkTypeCd("lnkt001");
        newUrlLinkDTO.setSortOrder(1);

        // 홈페이지 링크 등록
        urlLinkmapper.addUrlLink(newUrlLinkDTO);

        for(int i = 1; i < 6; i++) {
            newUrlLinkDTO.setBoardTypeCd("lnkt00"+(i+2));
            newUrlLinkDTO.setSortOrder(i);

            // snsLink 등록
            urlLinkmapper.addUrlLink(newUrlLinkDTO);
        }

        return urlLinkmapper.addUrlLink(newUrlLinkDTO);
    }
}
