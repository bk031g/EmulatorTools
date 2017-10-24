package main.emulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

public class BatonFullQC {
	
	private XmlRpcClient baton;
	private ArrayList<String> TestPlan = new ArrayList<String>();
	private ArrayList<String> TestPlanVersion = new ArrayList<String>();
	private ArrayList<String> Priority = new ArrayList<String>();
	private ArrayList<String> selectedDirectory = new ArrayList<String>();
	private ArrayList<String> ipAddr = new ArrayList<String>();
	private int jobCount = 0;
	
	private ArrayList<String> taskID = new ArrayList<String>();

	@SuppressWarnings("deprecation")
	public void run() throws XmlRpcException, IOException {
		
		System.out.println(TestPlan);
		System.out.println(TestPlanVersion);
		System.out.println(Priority);
		System.out.println(selectedDirectory);
		System.out.println(ipAddr);
		
		for (int i = 0; i < jobCount; i++){
			Vector<String> verifyFileParams = new Vector<String>();
			baton = new XmlRpcClient("http://" + ipAddr.get(i) + ":8080");
			baton.setBasicAuthentication("baton", "directv7s");
			verifyFileParams.addElement(TestPlan.get(i));
			verifyFileParams.addElement(TestPlanVersion.get(i));
			verifyFileParams.addElement(Priority.get(i));
			verifyFileParams.addElement(selectedDirectory.get(i));
			Object result = baton.execute("Baton.Tasks.verifyFile", verifyFileParams);
			
			taskID.add(result.toString());
			System.out.println(taskID);
		}
		
	}

	
	public void setTestPlan(String testPlan) {
		TestPlan.add(testPlan);
		jobCount++;
	}
	public void setTestPlanVersion(String testPlanVersion) {
		TestPlanVersion.add(testPlanVersion);
	}
	public void setPriority(String priority) {
		Priority.add(priority);
	}
	public void setSelectedDirectory(String selectedDirectory) {
		this.selectedDirectory.add(selectedDirectory);
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr.add(ipAddr);
	}
	public String getTaskID(int count) {
		return taskID.get(count);
	}
}
