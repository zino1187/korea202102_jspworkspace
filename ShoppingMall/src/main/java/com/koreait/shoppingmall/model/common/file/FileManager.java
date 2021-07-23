package com.koreait.shoppingmall.model.common.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.shoppingmall.exception.UploadException;

//비즈니스 파트에서 파일과 관련된 업무를 전담하는 객체
@Component
public class FileManager {
	String savePath="/resources/data/";
	
	//확장자 구하기
	public String getExt(String path) {
		int lastIndex = path.lastIndexOf(".");
		return path.substring(lastIndex+1, path.length());
	}
	
	//지정된 경로로 파일 저장 
	public void saveFile(ServletContext context, String filename, MultipartFile multi) throws UploadException{
		System.out.println(context.getRealPath(savePath));
		
		try {
			multi.transferTo(new File(context.getRealPath(savePath)+filename));//저장
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new UploadException("업로드 실패", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new UploadException("업로드 실패", e);
		}
	}
	
}







