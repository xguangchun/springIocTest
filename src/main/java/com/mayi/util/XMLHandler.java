package com.mayi.util;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class XMLHandler implements ContentHandler {

	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub

	}

	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.println(qName);
		if(qName != null){
			if(qName.equals("beans")){
				
				System.out.println("-------------开始加载配置文件--------------");
				
			}else if(qName.equals("conext:annotation-config")){
				
				System.out.println("-------------申明注解支持--------------");
				
			}else if(qName.equals("conext:component-scan")){
				for(int i=0;i< atts.getLength();i++){
					String key = atts.getQName(i);
					if(key != null){
						String value = atts.getValue(i);
						//通过类加载器收集所有的类路径
						ClassLoaderHandler.scanPackage(value);
						try {
							//定义注册器，通过类路径反射生成bean
							RegisterHandler.registerBean();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (InstantiationException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}else if(qName.equals("bean")){
				
				System.out.println("-------------读取到注入的javabean配置--------------");
				
			}else if(qName.equals("properties")){
				
				System.out.println("-------------读取到注入的setting注入配置--------------");
				
			} else{
				try {
					throw new Exception("找不到元素："+qName+"的声明约束");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub

	}

}
