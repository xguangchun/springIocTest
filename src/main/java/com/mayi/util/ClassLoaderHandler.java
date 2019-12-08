package com.mayi.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

public class ClassLoaderHandler {
	
	public static List<String> classNames = new ArrayList<String>();
	
	public static void scanPackage(String packPath){
		URL url = ClassLoader.class.getClass().getResource("/" +packPath.replaceAll("\\.", "/"));
		String path = url.getFile();
		System.out.println(path);
		File file = new File(path);
		String[] files = file.list();
		for(String s :files ){
			System.out.println(packPath +"."+ s);
			File f = new File(path +"/"+ s);
			if(f.isDirectory()){
				System.out.println(packPath + "." + f.getName());
				scanPackage(packPath + "." + f.getName());
			}else{
				classNames.add(packPath + "." + s);
			}
		}
	}
	
}
