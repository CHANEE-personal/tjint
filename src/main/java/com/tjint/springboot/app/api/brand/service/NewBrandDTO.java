package com.tjint.springboot.app.api.brand.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewBrandDTO {

    @Getter
    @Setter
    @RequiredArgsConstructor
    public class BrandDTO {
        private Integer brandSeq;
        private String categoryCd;
        private String menuCategoryCd;
        private String menuCategoryNm;
        private String brandName;
        private String brandDescription;
        private String visible;
        private Integer creator;
        private String createTime;
        private Integer updater;
        private String updateTime;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public class ImageDTO {
        private Integer imageFileInfoSeq;
        private String boardTypeCd;
        private String imageTypeCd;
        private String imageFileId;
        private Integer imageFileSeq;
    }
}
