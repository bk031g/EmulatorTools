package main.emulator;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class PopulateGUI {
	
	static ArrayList<String> listOfAtemePresets;
	static Vector<String> listOfTestPlans;
	static ArrayList<String> listOfElementalPresets;
	static Map<String, String> elementalProfilesHMap = new HashMap<String,String>();
	
	static JFileChooser atemeChooser = new JFileChooser();
	static JFileChooser elementalChooser = new JFileChooser();
	
	
	//listOfElementalPresets, elementalProfilesHMap
	public static Vector<String> populateElemental(String ipAddr, String requestType) throws JDOMException, IOException{
		SAXBuilder sb = new SAXBuilder();
		InputStream stream = new ByteArrayInputStream(RESTGetReturn("http://" + ipAddr + requestType).getBytes("UTF-8"));
		Document doc = sb.build(stream);
		
		Element testPlan = doc.getRootElement();
        List<Element> currentName = testPlan.getChildren();
        listOfElementalPresets = new ArrayList<String>();
        for(Element TestPlan : currentName){
        	listOfElementalPresets.add(TestPlan.getChildText("name"));
        	elementalProfilesHMap.put(TestPlan.getChildText("name"), TestPlan.getAttributeValue("href").substring(TestPlan.getAttributeValue("href").lastIndexOf("/") +1).trim());
        }
        java.util.Collections.sort(listOfElementalPresets);
		Vector<String> testPlansList = new Vector<String>(listOfElementalPresets);
		return testPlansList;
	}
	
	//listOfAtemePresets
	public static Vector<String> populateAteme(String ipAddr) throws JDOMException, IOException{
		SAXBuilder sb = new SAXBuilder();
		InputStream stream = new ByteArrayInputStream(RESTGetReturn("http://" + ipAddr + "/restapi/presets").getBytes("UTF-8"));
		Document doc = sb.build(stream);
	
		Element testPlan = doc.getRootElement();
		List<Element> currentName = testPlan.getChildren();
		listOfAtemePresets = new ArrayList<String>();
		for (Element TestPlan : currentName)
			listOfAtemePresets.add(TestPlan.getChildText("name"));
	
		java.util.Collections.sort(listOfAtemePresets);
		Vector<String> testPlansList = new Vector<String>(listOfAtemePresets);
		return testPlansList;
	}
	
	//listOfTestPlans
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static Vector<String> populateBaton(String ipAddr) throws JDOMException, IOException, XmlRpcException{
	    XmlRpcClient baton = new XmlRpcClient("http://"+ipAddr+":8080");
	    baton.setBasicAuthentication("admin", "admin");
	    Object testPlans = baton.execute("Baton.Planner.TestPlans.contents",new Vector<Object>());
	    listOfTestPlans = (Vector<String>) testPlans;
	    return (Vector<String>) testPlans;
	}
	
	//filter listOfAtemePresets
	public static Vector<String> filterAteme(String filterText) throws JDOMException, IOException, XmlRpcException{
		ArrayList<String> newListOfPresets = new ArrayList<String>();
		for(int i = 0; i < listOfAtemePresets.size(); i++){
			if(listOfAtemePresets.get(i).toLowerCase().contains((filterText).toLowerCase())){
				newListOfPresets.add(listOfAtemePresets.get(i));
			}
		}
		Vector<String> presetsList = new Vector<String>(newListOfPresets);
        return presetsList;
	}
	
	//filter listOfElementalPresets
	public static Vector<String> filterElemental(String filterText) throws JDOMException, IOException, XmlRpcException{
		ArrayList<String> newListOfPresets = new ArrayList<String>();
		for(int i = 0; i < listOfElementalPresets.size(); i++){
			if(listOfElementalPresets.get(i).toLowerCase().contains((filterText).toLowerCase())){
				newListOfPresets.add(listOfElementalPresets.get(i));
			}
		}
		Vector<String> presetsList = new Vector<String>(newListOfPresets);
        return presetsList;
	}
	
	//filter listOfTestPlans
	public static Vector<String> filterBaton(String filterText) throws JDOMException, IOException, XmlRpcException{
		ArrayList<String> newListOfPresets = new ArrayList<String>();
		for(int i = 0; i < listOfTestPlans.size(); i++){
			if(listOfTestPlans.get(i).toLowerCase().contains((filterText).toLowerCase())){
				newListOfPresets.add(listOfTestPlans.get(i));
			}
		}
		Vector<String> presetsList = new Vector<String>(newListOfPresets);
        return presetsList;
	}
	
	//listOfAtemePresets
	public static Vector<String> folderPopulateAteme(){
		atemeChooser.setCurrentDirectory(new File("\\\\isilonla3.vod.dtveng.net\\ifs\\ATEME"));
		atemeChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser();

		listFilesForFolder(atemeChooser.getSelectedFile());
		java.util.Collections.sort(listOfAtemePresets);
		Vector<String> testPlansList = new Vector<String>(listOfAtemePresets);
		return testPlansList;
    }
	
	private static void fileChooser() {
		atemeChooser.getActionMap().get("viewTypeDetails").actionPerformed(null);
		atemeChooser.setDialogTitle("Choose Directory");
		atemeChooser.setAcceptAllFileFilterUsed(false);

		if (atemeChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): "
					+ atemeChooser.getCurrentDirectory());
			System.out.println("getSelectedFile() : "
					+ atemeChooser.getSelectedFile());
		} else {
			System.out.println("No Selection ");
		}
	}
	
	private static void listFilesForFolder(final File folder){
		listOfAtemePresets = new ArrayList<String>();
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.getName().contains(".kpreset")){
				listOfAtemePresets.add(fileEntry.getName().substring(0, fileEntry.getName().indexOf(".")));
			}
		}
	}
	
	public static String folderOutputAteme(){
		atemeChooser.setCurrentDirectory(new File("\\\\isilonla3.vod.dtveng.net\\ifs"));
		atemeChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser();
		atemeChooser.getSelectedFile().toString().length();
		return atemeChooser.getSelectedFile().toString();
	}
	
	public static String folderOutputElemental(){
		elementalChooser.setCurrentDirectory(new File("\\\\isilonla3.vod.dtveng.net\\ifs"));
		elementalChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser();
		elementalChooser.getSelectedFile().toString().length();
		return elementalChooser.getSelectedFile().toString();
	}
	
	
	
	private static String RESTGetReturn(String urlString){
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
			JOptionPane.showMessageDialog(null, "ERROR 404, unable to reach: " + urlString);
			e.printStackTrace();
		}
		return "Placeholder";
	}

}
