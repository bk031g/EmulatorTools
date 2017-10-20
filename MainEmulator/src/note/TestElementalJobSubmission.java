package note;

import java.io.*;
import java.net.*;

public class TestElementalJobSubmission {

	public static void main(String[] args) {
		String urlString = "http://10.26.78.41/jobs";
		URL url;
			try {

				url = new URL(urlString);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				//conn.setDoInput(true);
				conn.setUseCaches(false);
				conn.setAllowUserInteraction(false);
				//conn.setRequestProperty("accept-charset", "UTF-8");
				conn.setRequestProperty("content-type", "application/xml");
				// Create the form content
				OutputStream out = conn.getOutputStream();
				Writer writer = new OutputStreamWriter(out, "UTF-8");
				String paramName =
						
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

				
//				BufferedReader rd = new BufferedReader(
//						new InputStreamReader(conn.getInputStream()));
//				StringBuilder sb = new StringBuilder();
//				String line;
//				while ((line = rd.readLine()) != null) {
//					sb.append(line);
//				}
//				rd.close();
				
				
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
