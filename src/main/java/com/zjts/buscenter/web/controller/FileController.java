package com.zjts.buscenter.web.controller;

import com.zjts.buscenter.common.constant.CodeEnum;
import com.zjts.buscenter.common.model.APIResponse;
import com.zjts.buscenter.util.PicUploadResult;
import com.zjts.buscenter.web.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Api(tags = "文件上传接口")
@RestController
public class FileController  {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private FileService fileService;


	@ApiOperation("上传驾驶员照片,体检信息")
	@PostMapping("/uploaddriverimages")
	public APIResponse uploadFile(@ApiParam(value = "MultipartFile上传类",required = true)  MultipartFile  file){
        if (file.isEmpty()) {
			return APIResponse.error(CodeEnum.ERROR,"上传文件不能为空");
        }
		try{
			System.out.println(file.getSize());
			System.out.flush();
			PicUploadResult picUploadResult =  fileService.uploadFile(file);
			if(picUploadResult.getError() == 0 ){
				return APIResponse.success(picUploadResult);
			}
		}catch (Exception e){
			logger.error("出现异常 : "+e.getMessage());
			e.printStackTrace();
			return APIResponse.error(CodeEnum.ERROR,"上传失败请稍后再试");
		}
			return APIResponse.error(CodeEnum.ERROR,"上传失败请稍后再试");
	}

	@ApiOperation("删除照片")
	@PostMapping("/updatedriverimages")
	public APIResponse updatedriverimages(@RequestBody(required = false)  String photoPath){
		try{
			logger.info(photoPath);
			Boolean flag = fileService.updatedriverimages(photoPath);
			return APIResponse.success();

		}catch (Exception e){
			logger.error("出现异常 : "+e.getMessage());
			e.printStackTrace();
			return APIResponse.error(CodeEnum.ERROR,"更新失败请稍后再试");
		}

	}





















}
