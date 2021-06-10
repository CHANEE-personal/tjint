package com.tjint.springboot.common.imageFile.service.impl;

import com.tjint.springboot.common.imageFile.AttachFileDTO;
import com.tjint.springboot.common.imageFile.NewImageDTO;
import org.apache.ibatis.annotations.Mapper;

import javax.transaction.Transactional;

@Mapper
public interface ImageMapper {

    @Transactional
    public Integer addImageFile(NewImageDTO newImageDTO) throws Exception;

    @Transactional
    public Integer addAttachFile(AttachFileDTO attachFileDTO) throws Exception;
}
