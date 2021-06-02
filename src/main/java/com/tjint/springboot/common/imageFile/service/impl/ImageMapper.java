package com.tjint.springboot.common.imageFile.service.impl;

import com.tjint.springboot.common.imageFile.NewImageDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageMapper {

    public String addImageFile(NewImageDTO newImageDTO) throws Exception;
}
