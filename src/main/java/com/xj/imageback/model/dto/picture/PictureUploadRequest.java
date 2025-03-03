package com.xj.imageback.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

/**
 * 图片支持重复上传（基础信息不变，只改变图片文件）
 */
@Data
public class PictureUploadRequest implements Serializable {
  
    /**  
     * 图片 id（用于修改）  
     */  
    private Long id;  
  
    private static final long serialVersionUID = 1L;  
}
