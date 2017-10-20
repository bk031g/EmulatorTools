package note;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public final class RESTPostAPI {
	
	static String newJob;
	
	
	public static void main(String[] args) throws JDOMException, IOException {
		
		//getJobID("10.27.99.62", "C87F5BCC-3DFC-4BC4-BA35-1E4F5ADDE40C");
		//RESTGet("http://10.27.99.66/restapi/presets");
		/*
		 * GUI Fields
		 */
		
		//System.out.println(RESTGet("http://10.26.78.41/api/jobs"));
		
		
		SAXBuilder sb = new SAXBuilder();
		InputStream stream = new ByteArrayInputStream(RESTGetReturn("http://10.26.78.41/api/presets").getBytes("UTF-8"));
		Document docc = sb.build(stream);
		
		Element testPlan = docc.getRootElement();
        List<Element> currentName = testPlan.getChildren();
        ArrayList<String> listOfTestPlans = new ArrayList<String>();
        for(Element TestPlan : currentName){
        	listOfTestPlans.add(TestPlan.getChildText("name"));
        }
        System.out.println(listOfTestPlans);
        
        String xml = "<message>HELLO!</message>";
        SAXBuilder saxBuilder = new SAXBuilder();
        
        try {
            Document doc = saxBuilder.build(new StringReader(RESTGet("http://10.26.78.41/api/presets")));
            
            
            //System.out.println(doc.getRootElement().getChildren().get(0).getChildText("name"));
            
            //System.out.println(RESTGet("http://10.26.78.41/api/presets"));
            String message = doc.getRootElement().getText();
            //System.out.println(message);
            //System.out.println(doc);
        } catch (JDOMException e) {
            // handle JDOMException
        } catch (IOException e) {
            // handle IOException
        }
        
        //System.out.println(RESTGet("http://10.26.78.41/api/jobs/7630?clean=true"));
        
		//System.out.println(RESTGet("http://10.27.99.181/api/jobs/306?clean=true"));
		
		XMLOutputter xmlOutput = new XMLOutputter();
        
        xmlOutput.setFormat(Format.getPrettyFormat());
        
        //try(OutputStream out = new FileOutputStream(absoluteFilePath+String.format("\\BatonXML_output\\%s",inputFile.getName()))) {
        //    new XMLOutputter().output(document, out);
        //}
		
		/*
		
		SAXBuilder sb = new SAXBuilder();
		InputStream stream = new ByteArrayInputStream(RESTGetReturn("http://10.27.99.66/restapi/presets").getBytes("UTF-8"));
		Document doc = sb.build(stream);
		
		Element testPlan = doc.getRootElement();
        List<Element> currentName = testPlan.getChildren();
        ArrayList<String> listOfTestPlans = new ArrayList<String>();
        for(Element TestPlan : currentName){
        	listOfTestPlans.add(TestPlan.getChildText("name"));
        }
        System.out.println(listOfTestPlans);
        
        */
		
		
		/*
		String jobName = "new job";
		String ipAddr = "10.27.99.62";
		String jobPreset = "DIRECTV_HD_1080i_AD_CUT_30sec_Fast";
		String jobInput = "\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\Projects\\HIC\\mezz_files\\ISCI-30S-79990090.mpg";
		String jobSegmentNumber = "1";
		String jobOutput = "\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\output\\test12345.ts";
		String jobState = "pending";
		*/
		
		/*
		 * Complexity hidden, Post Job.
		 */
		
		
		/*
		String jobID = postJob(ipAddr, jobName);
		
		postPreset(ipAddr, jobID, jobPreset);
		postSegment(ipAddr, jobID);
		postInput(ipAddr, jobID, jobInput, jobSegmentNumber);
		postOutput(ipAddr, jobID, jobOutput);
		postJobState(ipAddr, jobID, jobState);
		*/
		
		
		
		/*
		 * Complexity further hidden, Post Job. Not flexible.
		 */
		
		//launchJob(ipAddr, jobPreset, jobInput, jobSegmentNumber, jobOutput, jobState, jobName);
		
		
		/*
		 * Delete job feature
		 */
		
		//deleteJob("10.27.99.64", "DFE17A2F-1F97-4ED2-A1AE-AB70E3FB86D7");
		
		
	}
	
	public void launchJob(String ipAddr, String jobPreset, String jobInput, String jobSegmentNumber, String jobOutput, String jobState, String jobName){
		
		String jobID = postJob(ipAddr, jobName);
		postPreset(ipAddr, jobID, jobPreset);
		postSegment(ipAddr, jobID);
		postInput(ipAddr, jobID, jobInput, jobSegmentNumber);
		postOutput(ipAddr, jobID, jobOutput);
		postJobState(ipAddr, jobID, jobState);
	}
	
	
	public void getJobList(String ipAddr){
		RESTGet("http://"+ipAddr+"/restapi/jobs");
	}
	
	public static void getJobID(String ipAddr, String jobID){
		RESTGet("http://"+ipAddr+"/restapi/jobs/"+jobID);
	}
	
	public static String postJob(String ipAddr, String xmlDescription){
		return RESTPostJob("http://"+ipAddr+"/restapi/jobs", xmlDescription, "<job><name>", "</name></job>");
	}
	
	public static void deleteJob(String ipAddr, String jobID){
		RESTDelete("http://"+ipAddr+"/restapi/jobs/"+jobID);
	}
	
	public static void postPreset(String ipAddr, String jobID, String xmlDescription){
		RESTPost("http://"+ipAddr+"/restapi/jobs/"+jobID+"/preset", xmlDescription, "<preset><name>", "</name></preset>");
	}
	
	public static void postSegment(String ipAddr, String jobID){
		RESTPost("http://"+ipAddr+"/restapi/jobs/"+jobID+"/segments");
	}
	
	public static void postInput(String ipAddr, String jobID, String xmlDescription, String segmentNumber){
		RESTPost("http://"+ipAddr+"/restapi/jobs/"+jobID+"/segments"+"/"+segmentNumber+"/inputs", xmlDescription, "<input><uri>", "</uri></input>");
	}
	
	public static void postOutput(String ipAddr, String jobID, String xmlDescription){
		RESTPost("http://"+ipAddr+"/restapi/jobs/"+jobID+"/output", xmlDescription, "<output><file>", "</file></output>");
	}
	
	public static void postJobState(String ipAddr, String jobID, String stateValue){
		RESTPost("http://"+ipAddr+"/restapi/jobs/"+jobID+"/state?value="+stateValue);
	}
	
	
	public static void RESTPost(String urlString, String xmlDescription, String paramStart, String paramEnd){
		try{
			System.out.println(urlString);
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
			conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
			OutputStream out = conn.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			String paramName = paramStart+xmlDescription+paramEnd;
			System.out.println(paramName);
			writer.write(paramName);
			
			writer.close();
			out.close();
			System.out.println(conn.getResponseCode());
			conn.disconnect();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String RESTPostJob(String urlString, String xmlDescription, String paramStart, String paramEnd){
		try{
			System.out.println(urlString);
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
			conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
			OutputStream out = conn.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			String paramName = paramStart+xmlDescription+paramEnd;
			System.out.println(paramName);
			writer.write(paramName);
			writer.close();
			out.close();
			
			BufferedReader rd = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
            	sb.append(line);
            }
            rd.close();
            conn.disconnect();
			System.out.println(conn.getResponseCode());
			conn.disconnect();
			return sb.substring(sb.indexOf("/jobs/")+6,sb.indexOf("' />"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error In Job Creation";
	}
	
	public static void RESTPost(String urlString){
		try{
			System.out.println(urlString);
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			System.out.println(conn.getResponseCode());
			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String RESTGet(String urlString){
		try {
			URL url = new URL(urlString);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("content-type", "application/xml");
	        BufferedReader rd = new BufferedReader(
	            new InputStreamReader(conn.getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	          sb.append(line);
	        }
	        
	        //System.out.println(sb);
	        rd.close();
	        conn.disconnect();
	        return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlString;
	}
	
	//conn.setRequestProperty("Accept", "application/xml");
	//conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	public static String RESTGetReturn(String urlString){
		try {
			URL url = new URL(urlString);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/xml");
	        BufferedReader rd = new BufferedReader(
	            new InputStreamReader(conn.getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	          sb.append(line);
	        }
	        
	        rd.close();
	        conn.disconnect();
	        return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Placeholder";
	}
	
	public static void RESTDelete(String urlString){
		try {
			URL url = new URL(urlString);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestMethod("DELETE");
	        System.out.println(conn.getResponseCode());
	        conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
