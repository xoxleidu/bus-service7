package com.zjts.buscenter.web.service;

import com.zjts.buscenter.util.PicUploadResult;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {

	PicUploadResult uploadFile(MultipartFile uploadFile);


    Boolean updatedriverimages(String photoPath);
}
