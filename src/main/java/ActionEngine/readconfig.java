package ActionEngine;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class readconfig  {

	Properties pro;
	public readconfig() {
		
		File src = new  File("configuration/configuration.properties");
		try {
			FileInputStream fls= new FileInputStream(src);
			pro = new Properties();
			pro.load(fls);
		}
		 catch (Exception e) {
			 System.out.println("exception is "+ e.getMessage());
			
		}
	}
	
	
	public String getbaseurl() 
	{
		String url= pro.getProperty("crmURL");
		
		return url;
		
	}
	

	public String getchromepath() 
	{
		String chrome_path= pro.getProperty("chromepath");
		
		return chrome_path;
		
	}
	
	public String getusername() 
	{
		String crmUsername= pro.getProperty("crmUsername");
		
		return crmUsername;
		
	}
	

	public String getcrmPwd() 
	{
		String crmPwd= pro.getProperty("crmPwd");
		
		return crmPwd;
		
	
	}
	public String getstagingUrl() 
	{
		String stagingUrl= pro.getProperty("stagingUrl");
		
		return stagingUrl;
		
	}
	
}
