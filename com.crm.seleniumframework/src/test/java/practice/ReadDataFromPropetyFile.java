package practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropetyFile {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata1.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value=pobj.getProperty("un");
		System.out.println(value);
	}

}
