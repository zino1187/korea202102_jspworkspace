package com.koreait.shoppingmall.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.shoppingmall.domain.Product;
import com.koreait.shoppingmall.model.service.category.TopCategoryService;

//상품관련 요청을 처리하는 하위 컨트롤러
@Controller
public class ProductController {
	@Autowired
	private TopCategoryService topCategoryService;	
	
	//상품 등록폼 요청처리 
	@GetMapping("/product/registform")
	public String registForm(Model model) {
		//3단계: 최상위 카테고리 가져오기 
		List topList = topCategoryService.selectAll();
		
		//4단계:결과저장 
		model.addAttribute("topList", topList);
		
		return "admin/product/regist";//상품 등록 폼 뷰이름
	}
	
	//상품 등록 요청(파일업로드가 포함되어 있슴)
	@PostMapping("/product/regist")
	public String regist(Product product, HttpServletRequest request) {
		
		//VO에 등록한 MultipartFile 객체에 업로드된 파일이 이미 들어있으므로, 개발자는 이 객체를 이용하여 업로드된 파일을
		//원하는대로 제어하면 된다..
		MultipartFile photo=product.getPhoto();
		System.out.println("자동으로 업로드된 객체로 부터 얻은 파일명은 "+photo.getOriginalFilename());
		
		System.out.println("servlet context="+request.getServletContext());
		ServletContext context = request.getServletContext();
		String realPath=context.getRealPath("/resources/data");
		long time=System.currentTimeMillis();
		
		String filename=photo.getOriginalFilename();
		int lastIndex=filename.lastIndexOf(".");
		String ext= filename.substring(lastIndex+1, filename.length()); //확장자 구하기
		
		//원하는 위치에 파일 저장하기
		try {
			photo.transferTo(new File(realPath+"/"+time+"."+ext));
			System.out.println("최종 저장 경로"+realPath);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}









