//package com.zjts.buscenter.web.controller;
//
//import com.zjts.buscenter.common.constant.CodeEnum;
//import com.zjts.buscenter.common.model.APIResponse;
//import com.zjts.buscenter.util.PicUploadResult;
//import com.zjts.buscenter.web.service.FileService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//@Api(tags = "文件上传接口")
//@Controller("/drivermange")
//public class FileController  {
//
//	@Autowired
//	private FileService fileService;
//
//
//	处理文件上传  {"error":0,"url":"图片的保存路径","width":图片的宽度,"height":图片的高度}
//	@ApiOperation("文件上传接口")
//	@PostMapping("/pic/upload")
//	@ResponseBody
//	public APIResponse uploadFile(
//			@ApiParam(name = "uploadFile", value = "MultipartFile上传类") MultipartFile  uploadFile){
//		PicUploadResult picUploadResult =  fileService.uploadFile(uploadFile);
//        if (uploadFile.isEmpty()) {
//            return APIResponse.error(CodeEnum.ERROR,"上传文件不能为空");
//        }
//
//		if(picUploadResult.getError() != 0 )
//		return  APIResponse.error(CodeEnum.SAVE_PIC_ERROR);
//
//		return APIResponse.success(picUploadResult);
//
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
