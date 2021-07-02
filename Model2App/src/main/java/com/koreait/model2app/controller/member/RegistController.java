package com.koreait.model2app.controller.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.util.FileManager;

//회원의 등록 요청을 처리하는 하위 컨트롤러
public class RegistController implements Controller{
	//3단계: 알맞는 로직객체에 일 시킨다 , 4단계: 결과가 있을때는 저장 (X)
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//아파치 파일 업로드를 이용한 파일 저장 및 파라미터 처리 
		DiskFileItemFactory factory=new DiskFileItemFactory();//업로드 설정 객체
		ServletContext context=request.getServletContext();//어플리케이션의 정보를 가진 객체를 얻기 jsp에서의 application내장객체임
		String realPath=context.getRealPath("/data");//실제 물리적 저장 경로얻기
		factory.setRepository(new File(realPath));
		factory.setSizeThreshold(2*1024*1024); // 2M제한
		
		ServletFileUpload upload=new ServletFileUpload(factory);
		
		try {
			List<FileItem> items=upload.parseRequest(request);//요청 분석하여 업로드 실행
			Member member=new Member(); //empty vo
			
			for(FileItem item:items) {
				if(item.isFormField()) { //text필드라면..
					if(item.getFieldName().equals("name")) {
						member.setName(item.getString("utf-8"));//이름 대입 
					}else if(item.getFieldName().equals("phone")) {
						member.setPhone(item.getString("utf-8"));//연락처 대입
					}else if(item.getFieldName().equals("addr")) {
						member.setAddr(item.getString("utf-8"));//주소대입
					}else if(item.getFieldName().equals("title")) {
						License license=new License(); //empty vo
						license.setTitle(item.getString("utf-8"));//자격증 대입
					}
				}else {//파일 필드라면...
					try {
						String ext=FileManager.getExt(item.getName());
						String newName=System.currentTimeMillis()+"."+ext;
						
						System.out.println(realPath+"/"+newName);
						
						item.write(new File(realPath+"/"+newName)); //파일저장!!
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public String getViewName() {
		return null;
	}

	@Override
	public boolean isForward() {
		return false;
	}	
}
