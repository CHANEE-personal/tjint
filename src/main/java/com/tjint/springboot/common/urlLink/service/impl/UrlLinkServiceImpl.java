package com.tjint.springboot.common.urlLink.service.impl;

import com.tjint.springboot.common.urlLink.service.UrlLinkService;
import com.tjint.springboot.common.urlLink.service.UrlLinkVo;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UrlLinkService")
public class UrlLinkServiceImpl extends EgovAbstractServiceImpl implements UrlLinkService {
    @Resource(name = "UrlLinkMapper")
    private UrlLinkMapper urlLinkDAO;

    public List<UrlLinkVo> selectUrlLinkList(UrlLinkVo urlLinkVo) throws Exception {
        return this.urlLinkDAO.selectUrlLinkList(urlLinkVo);
    }
}
