package com.koreait.tourapp.controller.place;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CultureHandler extends DefaultHandler{
	//시작태그
	@Override
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		System.out.println(tag);
	}
	
	//태그사이 문자열 발견
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

	}
	
	//닫는 태그
	@Override
	public void endElement(String uri, String localName, String tag) throws SAXException {

	}
	
	//문서 종료 태그 
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}
	
}
