package site0617.util;

public class FileManager {
	
	//확장자만 추출하기 , 경로를 넘겨받아 확장자만 추출
	public static String getExt(String path) {
		//test.kkk.jpg 
		return path.substring(path.lastIndexOf(".")+1, path.length());
	}
	
	/*
	public static void main(String[] args) {
		System.out.println(getExt("test.kkk.jpg"));
	}
	*/
}
