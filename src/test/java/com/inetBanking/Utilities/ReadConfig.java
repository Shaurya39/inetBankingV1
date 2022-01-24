package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro = new Properties();
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getUsername()
	{
		String username = pro.getProperty("UserName");
		return username;
		
	}
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	public String getchromepath()
	{
		String chropath = pro.getProperty("chromepath");
		return chropath;
	}
	public String getedgepath()
	{
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}
	public String getfirefoxpath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

}
