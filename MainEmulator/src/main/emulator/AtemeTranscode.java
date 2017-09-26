package main.emulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AtemeTranscode{
	
	private String ipAddr;
	private String jobPreset;
	private String jobInput;
	private String jobSegmentNumber;
	private String jobOutput;
	private String jobState;
	private String jobName;
	private String jobPriority;
	Document document;
	
	private String jobID;
	private String jobURL;
	
	public String getID(){
		return jobID;
	}

	public void run(){
		launchJob(ipAddr, jobPreset, jobInput, jobSegmentNumber, jobOutput, jobState, jobName);
	}
	
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getJobPreset() {
		return jobPreset;
	}
	public void setJobPreset(String jobPreset) {
		this.jobPreset = jobPreset;
	}
	public String getJobInput() {
		return jobInput;
	}
	public void setJobInput(String jobInput) {
		this.jobInput = jobInput;
	}
	public String getJobSegmentNumber() {
		return jobSegmentNumber;
	}
	public void setJobSegmentNumber(String jobSegmentNumber) {
		this.jobSegmentNumber = jobSegmentNumber;
	}
	public String getJobOutput() {
		return jobOutput;
	}
	public void setJobOutput(String jobOutput) {
		this.jobOutput = jobOutput;
	}
	public String getJobState() {
		return jobState;
	}
	public void setJobState(String jobState) {
		this.jobState = jobState;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobPriority() {
		return jobPriority;
	}
	public void setJobPriority(String jobPriority) {
		this.jobPriority = jobPriority;
	}
	
	
	
	
	
	private void launchJob(String ipAddr, String jobPreset, String jobInput, String jobSegmentNumber, String jobOutput, String jobState, String jobName){
		
		jobID = postJob(ipAddr, jobName);
		jobURL = "http://" + ipAddr + "/restapi/jobs/" + jobID;
		
		postPreset(jobPreset);
		postSegment();
		postInput(jobInput, jobSegmentNumber);
		postOutput(jobOutput);
		postPriority(jobPriority);
		postJobState(jobState);
		
		fetchXML();
        
        System.out.println(document.getRootElement().getChildText("state"));
        System.out.println(document.getRootElement().getChildText("name"));
        
	}
	
	void fetchXML(){
		SAXBuilder saxBuilder = new SAXBuilder();
        try {
			document = saxBuilder.build(jobURL);
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void getJobList(String ipAddr) {
		RESTGet("http://" + ipAddr + "/restapi/jobs");
	}
	@SuppressWarnings("unused")
	private void getJobID(String ipAddr, String jobID) {
		RESTGet("http://" + ipAddr + "/restapi/jobs/" + jobID);
	}
	@SuppressWarnings("unused")
	private void deleteJob(String ipAddr, String jobID) {
		RESTDelete("http://" + ipAddr + "/restapi/jobs/" + jobID);
	}

	private String postJob(String ipAddr, String xmlDescription) {
		return RESTPostJob("http://" + ipAddr + "/restapi/jobs", xmlDescription, "<job><name>", "</name></job>");
	}
	
	private void postPreset(String xmlDescription) {
		RESTPost(jobURL + "/preset", xmlDescription, "<preset><name>", "</name></preset>");
	}
	private void postSegment() {
		RESTPost(jobURL + "/segments");
	}
	private void postInput(String xmlDescription, String segmentNumber) {
		RESTPost(jobURL + "/segments" + "/" + segmentNumber + "/inputs", xmlDescription, "<input><uri>", "</uri></input>");
	}
	private void postOutput(String xmlDescription) {
		RESTPost(jobURL + "/output", xmlDescription, "<output><file>", "</file></output>");
	}
	private void postJobState(String stateValue) {
		RESTPost(jobURL + "/state?value=" + stateValue);
	}
	private void postPriority(String stateValue){
		RESTPost(jobURL + "/priority?value=" + stateValue);
	}

	
	private void RESTPost(String urlString, String xmlDescription,
			String paramStart, String paramEnd) {
		try {
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
			String paramName = paramStart + xmlDescription + paramEnd;
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

	private String RESTPostJob(String urlString, String xmlDescription,
			String paramStart, String paramEnd) {
		try {
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
			String paramName = paramStart + xmlDescription + paramEnd;
			System.out.println(paramName);
			writer.write(paramName);
			writer.close();
			out.close();

			BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			System.out.println(conn.getResponseCode());
			conn.disconnect();
			return sb.substring(sb.indexOf("/jobs/") + 6, sb.indexOf("' />"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error In Job Creation";
	}

	private void RESTPost(String urlString) {
		try {
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
			System.out.println(conn.getResponseCode());
			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void RESTGet(String urlString) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}

			System.out.println(sb);
			rd.close();
			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// conn.setRequestProperty("Accept", "application/xml");
	// conn.setRequestProperty("Content-Type",
	// "application/x-www-form-urlencoded");
	

	private void RESTDelete(String urlString) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setRequestMethod("DELETE");
			System.out.println(conn.getResponseCode());
			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
