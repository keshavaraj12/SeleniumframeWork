package com.crm.generic_utilitie;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
public  String PropertyFile(String key) throws Throwable {
	FileInputStream fis=new FileInputStream("./src/test/resources/commondata1.properties");
	//FileInputStream fis=new FileInputStream(ipathConstant.PROPERTYFILE_PATH);
	Properties pobj=new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value;
}
}
