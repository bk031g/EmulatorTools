package note;

import java.io.*;
import java.net.*;

public class QuickAdSubmission {

	public static void main(String[] args) {
		String urlString = "http://10.27.99.62/restapi/jobs_quick";
		int adnum=0;
		URL url;
		String jobName ="";
		String preset = "";//ex: \\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\Content\\Ads\\RL10300008_H_30sec.mpg
		String input = "";
		String output ="";//ex: \\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\output\\test123.ts
		String priority ="normal";//low, normal (default), high, urgent
		
		for (int i=1;i<=20;i++)
		{
			try {

				url = new URL(urlString);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				conn.setDoInput(true);
				conn.setUseCaches(false);
				conn.setAllowUserInteraction(false);
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//				preset = "ad_fastest_3-5";
//				preset = "ad_fast_3-5";
//				preset = "ad_default_3-5";
				preset = "ad_best_3-5";
//				preset = "ad_ultra_3-5";
//				preset = "ad_best_5";
				if(adnum==0)
                {
                    jobName = preset+" ad1";
                    input = "\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\Projects\\HIC\\mezz_files\\ISCI-30S-79990090.mpg";
                    output = "\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\output\\AdTest\\"+preset+"SB_ISCI-30S-79990090_0"+i+".ts";
                    adnum=1;
                } else if (adnum==1)
                {
                	jobName = preset+" ad2";
                    input = "\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\Projects\\HIC\\mezz_files\\JAZ41617_I_H.mpg";
                    output = "\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\output\\AdTest\\"+preset+"SB_JAZ41617_I_H_0"+i+".ts";
                    adnum=2;
                } else if (adnum==2)
                {
                	jobName = preset+" ad3";
                    input = "\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\Content\\Ads\\RL10300008_H_30sec.mpg";
                    output = "\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\output\\AdTest\\"+preset+"SB_RL10300008_H_30sec_0"+i+".ts";
                    adnum=3;
                } else 
                {
                	jobName = preset+" ad4";
                    input = "\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\ProductionIssues\\AddressableAds_issue\\Bowlmor_macropixel\\TL0DB47VW_I_H.mpg";
                    output = "\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\output\\AdTest\\"+preset+"SB_TL0DB47VW_I_H_0"+i+".ts";
                    adnum=0;
                }
				// Create the form content
				OutputStream out = conn.getOutputStream();
				Writer writer = new OutputStreamWriter(out, "UTF-8");
				String paramName = "<job_quick>"+
						"<name>"+jobName+"</name>" +
						"<preset>"+preset+"</preset>"+
						"<segments>"+
						"<segment>"+
						"<input>"+input+"</input>"+
						"</segment>"+
						"</segments>"+
						"<output>"+output+"</output>"+
						"<priority>"+priority+"</priority>"+
						"</job_quick>";
				writer.write(paramName);
				writer.close();
				//			System.out.println(out.toString());
				out.close();
				//			System.out.print("Job Response Code: ");
				//			System.out.println(conn.getResponseCode());

				// Buffer the result into a string
				BufferedReader rd = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = rd.readLine()) != null) {
					sb.append(line);
				}
				rd.close();
				conn.disconnect();
				System.out.println(sb);

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
