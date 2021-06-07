package com.tjint.springboot.common.urlLink.service.impl;

import com.tjint.springboot.common.urlLink.service.NewUrlLinkDTO;
import com.tjint.springboot.common.urlLink.service.UrlLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("UrlLinkService")
@RequiredArgsConstructor
public class UrlLinkServiceImpl implements UrlLinkService {
    private final UrlLinkMapper urlLinkmapper;

    public String addUrlLink(NewUrlLinkDTO newUrlLinkDTO) throws Exception {
        return urlLinkmapper.addUrlLink(newUrlLinkDTO);
    }
}
