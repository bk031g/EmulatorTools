package main.emulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ElementalTranscode{
	
	private String ipAddr;
	private String jobInput;
	private String jobOutput;
	private String jobProfile;
	private String jobPriority = "50";
	private boolean isElementalProfile;
	
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public void setJobInput(String jobInput) {
		this.jobInput = jobInput;
	}
	public void setJobOutput(String jobOutput) {
		this.jobOutput = jobOutput;
	}
	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}
	public void setJobPriority(String jobPriority) {
		this.jobPriority = jobPriority;
	}
	public void setIsElementalProfile(boolean isElementalProfile) {
		this.isElementalProfile = isElementalProfile;
	}
	
	public void run(){
		System.out.println("isElemental: " + isElementalProfile);
		if(isElementalProfile)
			runElementalProfile();
		else
			runElementalPreset();
	}
	
	public void runElementalPreset(){
		System.out.println("Elemental Running");
		URL url;
			try {

				url = new URL("http://" + ipAddr + "/jobs");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				//conn.setDoInput(true);
				conn.setUseCaches(false);
				conn.setAllowUserInteraction(false);
				conn.setRequestProperty("content-type", "application/xml");
				OutputStream out = conn.getOutputStream();
				Writer writer = new OutputStreamWriter(out, "UTF-8");
				String paramName ="<job>"
								+ "<priority>"
								+ jobPriority
								+ "</priority>"
								+ "<input>"
								+ "<file_input>"
								+ "<uri>"
								+ jobInput
								+ "</uri>"
								+ "</file_input>"
								+ "<caption_selector>"
								+ "<order>1</order>"
								+ "<source_type>Embedded</source_type>"
								+ "<embedded_source_settings>"
								+ "<source_608_channel_number>1</source_608_channel_number>"
								+ "<source_608_track_number>1</source_608_track_number>"
								+ "<upconvert_608_to_708>false</upconvert_608_to_708>"
								+ "</embedded_source_settings>"
								+ "</caption_selector>"
								+ "</input>"
								+ "<output_group>"
								+ "<order>1</order>"
								+ "<name>anyname</name>"
								+ "<file_group_settings>"
								+ "<destination>"
								+ "<uri>"
								+ jobOutput
								+ "</uri>"
								+ "</destination>"
								+ "</file_group_settings>"
								+ "<output>"
								+ "<stream_assembly_name>stream_assembly_0</stream_assembly_name>"
								+ "<preset>"
								+ jobProfile
								+ "</preset>"
								+ "<order>1</order>"
								+ "</output>"
								+ "</output_group>"
								+ "<stream_assembly>"
								+ "<name>stream_assembly_0</name>"
								+ "<preset>"
								+ jobProfile
								+ "</preset>"
								+ "<caption_description>"
								+ "<destination_type>Embedded</destination_type>"
								+ "<language_code nil=\"true\"/>"
								+ "<language_description nil=\"true\"/>"
								+ "<order>1</order>"
								+ "<caption_source_name>Caption Selector 1</caption_source_name>"
								+ "</caption_description>"
								+ "</stream_assembly>"
								+ "</job>";
				writer.write(paramName);
				writer.close();
				System.out.println(out.toString());
				out.close();
				System.out.print("Job Response Code: ");
				System.out.println(conn.getResponseCode());
				conn.disconnect();
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void runElementalProfile(){
		
		System.out.println("Elemental Running");
		URL url;
			try {

				url = new URL("http://" + ipAddr + "/jobs");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				//conn.setDoInput(true);
				conn.setUseCaches(false);
				conn.setAllowUserInteraction(false);
				conn.setRequestProperty("content-type", "application/xml");
				OutputStream out = conn.getOutputStream();
				Writer writer = new OutputStreamWriter(out, "UTF-8");
				String paramName =
						"<job>"
						+ "<priority>"
						+ jobPriority
						+ "</priority>"
						+ "<input>"
						+ "<file_input>"
						+ "<uri>"
						+ jobInput //"/isilonla3.vod.dtveng.net/ifs/Kevin_Kha/Misc_Projects/Ads/Content/FastOnly/FixedProfile/Boxing/Boxing_3.ts"
						+ "</uri>"
						+ "</file_input>"
						+ "</input>"
						
						+ "<output_group>"
						+ "<order>1</order>"
						+ "<file_group_settings>"
						+ "<destination>"
						+ "<uri>"
						+ jobOutput //"/isilonla3.vod.dtveng.net/ifs/Kevin_Kha/Misc_Projects/Ads/Content/FastOnly/FixedProfile/Boxing/TestingElem/Test3"
						+ "</uri>"
						+ "</destination>"
						+ "</file_group_settings>"
						+ "</output_group>"
						
						+ "<profile>"
						+ jobProfile //"22"
						+ "</profile>"
						
						+ "</job>";
						
						
						
						
						
						
						
						
						
						/*
						 
						"<job>"
						+ "<priority>50</priority>"
								
						+ "<input>"
						
						+ "<file_input>"
						+ "<uri>"
						+ "/isilonla3.vod.dtveng.net/ifs/Kevin_Kha/Misc_Projects/Ads/Content/FastOnly/FixedProfile/Boxing/Boxing_1.ts"
						+ "</uri>"
						+ "</file_input>"
						
						+ "<caption_selector>"
						+ "<order>1</order>"
						+ "<source_type>Embedded</source_type>"
						+ "<embedded_source_settings>"
						+ "<source_608_channel_number>1</source_608_channel_number>"
						+ "<source_608_track_number>1</source_608_track_number>"
						+ "<upconvert_608_to_708>false</upconvert_608_to_708>"
						+ "</embedded_source_settings>"
						+ "</caption_selector>"
						
						+ "</input>"
						
						+ "<output_group>"
						
						+ "<order>1</order>"
						+ "<name>anyname</name>"
						
						+ "<file_group_settings>"
						+ "<destination>"
						+ "<uri>/isilonla3.vod.dtveng.net/ifs/Kevin_Kha/Misc_Projects/Ads/Content/FastOnly/FixedProfile/Boxing/TestingElem/Test1</uri>"
						+ "</destination>"
						+ "</file_group_settings>"
						
						+ "<output>"
						+ "<stream_assembly_name>stream_assembly_0</stream_assembly_name>"
						+ "<preset>DIRECTV_HD_1080p_MP4</preset>"
						+ "<order>1</order>"
						+ "</output>"
						
						+ "</output_group>"
						
						+ "<stream_assembly>"
						+ "<name>stream_assembly_0</name>"
						+ "<preset>DIRECTV_HD_1080p_MP4</preset>"
						
						+ "<caption_description>"
						+ "<destination_type>Embedded</destination_type>"
						+ "<language_code nil=\"true\"/>"
						+ "<language_description nil=\"true\"/>"
						+ "<order>1</order>"
						+ "<caption_source_name>Caption Selector 1</caption_source_name>"
						+ "</caption_description>"
						+ "</stream_assembly>"
						
						+ "</job>";
						
						*/
						
						
						
						
						
						
						
						/*
						"<job>"
						
						+ "<input>"
						+ "<file_input>"
						+ "<uri>/data/mnt/ifs/Kevin_Kha/Misc_Projects/Ads/Content/FastOnly/FixedProfile/Boxing/Boxing_1.ts</uri>"
						+ "</file_input>"
						+ "</input>"
						
		        		+ "<priority>50</priority>"
		        		
		        		+ "<output_group>"
		        		+ "<order>1</order>"
		        		+ "<apple_live_group_settings>"
		        		+ "<destination>"
		        		+ "<uri>/data/mnt/ifs/Kevin_Kha/Misc_Projects/Ads/Content/FastOnly/FixedProfile/Boxing</uri>"
		        		+ "</destination>"
		        		+ "</apple_live_group_settings>"
		        		+ "<type>apple_live_group_settings</type>"
		        		+ "<output><stream_assembly_name>"
		        		+ "DIRECTV_HD_1080p_MP4"
		        		+ "</stream_assembly_name><name_modifier>"
		        		+ "_high"
		        		+ "</name_modifier><order>"
		        		+ "1"
		        		
		        		+ "</order><preset>"
		        		+ "282"
		        		+ "</preset></output><output><stream_assembly_name>"
		        		+ "asd1"
		        		+ "</stream_assembly_name><name_modifier>"
		        		+ "_low"
		        		
		        		+ "</name_modifier><order>"
		        		+ "282"
		        		+ "</order><preset>"
		        		+ "4"
		        		+ "</preset></output></output_group>"
		        		
		        		+ "<stream_assembly><name>"
		        		+ "asd2"
		        		+ "</name><preset>"
		        		+ "282"
		        		+ "</preset></stream_assembly>"
		        		
		        		+ "<stream_assembly><name>"
		        		+ "asd3"
		        		+ "</name><preset>"
		        		+ "282"
		        		+ "</preset></stream_assembly></job>";
		        		
		        		*/
						
						
				writer.write(paramName);
				writer.close();
				System.out.println(out.toString());
				out.close();
				System.out.print("Job Response Code: ");
				System.out.println(conn.getResponseCode());

				conn.disconnect();
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
