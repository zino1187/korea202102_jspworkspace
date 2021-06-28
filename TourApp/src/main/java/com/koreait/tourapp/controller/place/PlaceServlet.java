package com.koreait.tourapp.controller.place;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


public class PlaceServlet extends HttpServlet{
	SAXParserFactory factory;
	SAXParser saxParser;
	CultureHandler handler; 
	
	@Override
	public void init() throws ServletException {
		factory = SAXParserFactory.newInstance();
		try {
			saxParser = factory.newSAXParser(); //파서 생성
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String result = loadData();
		
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		//xml 파싱을 위한 객체는 자바에서 이미 지원
		//요청하기 위한 파라미터 구성
    	String ServiceKey="TPK6sq5VdCOFrijK99CmJHQCEVer9GwK4sxLvP6ED6dBExrBc6FO298QjQadJsw7C4sDZ8yBXJfsYZ%2FVT6LG0A%3D%3D";
    	
        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/locationBasedList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+ServiceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*(A=제목순, B=조회순, C=수정일순, D=생성일순, E=거리순)*/
        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("15", "UTF-8")); /*관광타입(관광지, 숙박 등) ID*/
        urlBuilder.append("&" + URLEncoder.encode("mapX","UTF-8") + "=" + URLEncoder.encode("126.981611", "UTF-8")); /*GPS X좌표(WGS84 경도 좌표)*/
        urlBuilder.append("&" + URLEncoder.encode("mapY","UTF-8") + "=" + URLEncoder.encode("37.568477", "UTF-8")); /*GPS Y좌표(WGS84 위도 좌표)*/
        urlBuilder.append("&" + URLEncoder.encode("radius","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*거리 반경(단위m), Max값 20000m=20Km*/
        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록 구분 (Y=목록, N=개수)*/
        urlBuilder.append("&" + URLEncoder.encode("modifiedtime","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*콘텐츠 수정일*/
        
        //Http 요청을 위한 코드 
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        //요청에 의한 응답정보 가져오기
        //스트림을 이용한 파싱 
        try {
			saxParser.parse(conn.getInputStream(), handler = new CultureHandler());
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
        conn.disconnect();
	}
}
