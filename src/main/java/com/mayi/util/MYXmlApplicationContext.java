package com.mayi.util;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class MYXmlApplicationContext {
	
	private String xmlPath;
	
	public MYXmlApplicationContext(String xmlPath){
		try {
			parserXML(xmlPath);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//解析xml方法
	public void parserXML(String xmlPath) throws ParserConfigurationException, SAXException, IOException{	
		//初始化解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//根据工厂得到解析器
		SAXParser saxParser = factory.newSAXParser();
		//读取器
		XMLReader xmlReader = saxParser.getXMLReader();
		//设置内容读取器
		xmlReader.setContentHandler(new XMLHandler());
		//定义配置文件路径
		String url = System.getProperty("user.dir") + "\\"+ xmlPath;
		 
		xmlReader.parse(url);		
	}
	
	public Object getBean(String key){
		return RegisterHandler.beans.get(key);
	}
}
