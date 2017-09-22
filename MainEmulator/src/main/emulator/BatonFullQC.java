package main.emulator;

import java.io.IOException;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

public class BatonFullQC {
	
	private XmlRpcClient baton;
	private Vector<String> verifyFileParams = new Vector<String>();
	
	private String TestPlan;
	private String TestPlanVersion;
	private String Priority;
	private String selectedDirectory;
	private String ipAddr;
	
	private String taskID;

	@SuppressWarnings("deprecation")
	public void run() throws XmlRpcException, IOException {
		baton = new XmlRpcClient("http://" + ipAddr + ":8080");
		baton.setBasicAuthentication("baton", "directv7s");
		verifyFileParams.addElement(TestPlan);
		verifyFileParams.addElement(TestPlanVersion);
		verifyFileParams.addElement(Priority);
		verifyFileParams.addElement(selectedDirectory);
		Object result = baton.execute("Baton.Tasks.verifyFile", verifyFileParams);
		
		taskID = result.toString();
		System.out.println(taskID);
	}

	public String getTestPlan() {
		return TestPlan;
	}
	public void setTestPlan(String testPlan) {
		TestPlan = testPlan;
	}
	public String getTestPlanVersion() {
		return TestPlanVersion;
	}
	public void setTestPlanVersion(String testPlanVersion) {
		TestPlanVersion = testPlanVersion;
	}
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		Priority = priority;
	}
	public String getSelectedDirectory() {
		return selectedDirectory;
	}
	public void setSelectedDirectory(String selectedDirectory) {
		this.selectedDirectory = selectedDirectory;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public Vector<String> getVerifyFileParams() {
		return verifyFileParams;
	}
	public void setVerifyFileParams(Vector<String> verifyFileParams) {
		this.verifyFileParams = verifyFileParams;
	}
	public String getTaskID() {
		return taskID;
	}
}
