package main.emulator;

import java.io.File;
import java.io.IOException;

import org.jdom2.JDOMException;

public class sandbox {
	
	static String absoluteFilePath = new File("").getAbsolutePath();

	public static void main(String[] args) throws JDOMException, IOException {
		
		XmlToExcel xmltoexcel = new XmlToExcel();
		//System.out.println(absoluteFilePath);
		//xmltoexcel.start("http://10.27.99.62/restapi/jobs/F9E0FFBE-3BE5-4014-8CC4-CA73ABCFEA94");
		//xmltoexcel.start("http://10.27.99.62/restapi/jobs/F9E0FFBE-3BE5-4014-8CC4-CA73ABCFEA94");
		
	}
}
