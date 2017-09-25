package note;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RESTPost {


    public static void main(String[] args) {
        String urlString = "http://10.27.99.64/restapi/jobs";
        int adnum=0;
        URL url;
        
        for(int j = 1; j <= 1; j++) {
        	System.out.println("job number: "+j);
        	try {
                
                /***********************Create job*******************************/
                url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                conn.setAllowUserInteraction(false);
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                // Create the form content
                OutputStream out = conn.getOutputStream();
                Writer writer = new OutputStreamWriter(out, "UTF-8");
                String paramName = "<job><name>AdBest30secBest_"+adnum+"_"+j+"</name></job>";
                writer.write(paramName);
                writer.close();
                System.out.println(out.toString());
                out.close();
                System.out.print("Job created: ");
                System.out.println(conn.getResponseCode());

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
                System.out.println(sb.substring(sb.indexOf("http"),sb.indexOf("' />")));
                StringBuilder newJob = new StringBuilder();
                newJob.append(sb.substring(sb.indexOf("http"),sb.indexOf("' />")));


                /***********************Add preset*******************************/
                url = new URL (newJob + "/preset");
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                conn.setAllowUserInteraction(false);
                conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

                // Create the form content
                out = conn.getOutputStream();
                writer = new OutputStreamWriter(out, "UTF-8");
                paramName = "<preset><name>DIRECTV_HD_1080i_AD_CUT_30sec_Fast</name></preset>";
//                paramName = "<preset><name>DIRECTV_HD_1080i_AD_CUT_30sec_Best_Turbo</name></preset>";
//                paramName = "<preset><name>DIRECTV_HD_1080i_AD_CUT_30sec_Best</name></preset>";
//                paramName = "<preset><name>DIRECTV_HD_720p</name></preset>";
                writer.write(paramName);
                writer.close();
                out.close();
                System.out.print("Preset added: ");
                System.out.println(conn.getResponseCode());
                conn.disconnect();

                /***********************Add segment*******************************/
                url = new URL (newJob + "/segments");
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                conn.setAllowUserInteraction(false);
                conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
                System.out.print("Segment added: ");
                System.out.println(conn.getResponseCode());
                conn.disconnect();

                /***********************Add Inputs*******************************/
                url = new URL (newJob + "/segments/1/inputs");
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                conn.setAllowUserInteraction(false);
                conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

                // Create the form content
                out = conn.getOutputStream();
                writer = new OutputStreamWriter(out, "UTF-8");
                if(adnum==0)
                {
                    paramName = "<input><uri>\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\Projects\\HIC\\mezz_files\\ISCI-30S-79990090.mpg</uri></input>";
                    adnum=1;
                } else if (adnum==1)
                {
                	paramName = "<input><uri>\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\Projects\\HIC\\mezz_files\\JAZ41617_I_H.mpg</uri></input>";
                	adnum=2;
                } else 
                {
                	paramName = "<input><uri>\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\Content\\Ads\\RL10300008_H_30sec.mpg</uri></input>";
                	adnum=0;
                }
                writer.write(paramName);
                writer.close();
                out.close();
                System.out.print("Input added: ");
                System.out.println(conn.getResponseCode());
                conn.disconnect();

                /***********************Add output*******************************/
                url = new URL (newJob + "/output");
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                conn.setAllowUserInteraction(false);
                conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

                // Create the form content
                out = conn.getOutputStream();
                writer = new OutputStreamWriter(out, "UTF-8");
//                paramName = "<output><file>\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\Projects\\HIC\\labLoadTest\\ad1080i30Sec_Best"+adnum+"_"+j+"</file></output>";
//                paramName = "<output><file>\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\Projects\\HIC\\labLoadTest\\ad1080i30Sec_Best"+j%20+"</file></output>";
                paramName = "<output><file>\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\output\\test12345.ts</file></output>";
                writer.write(paramName);
                writer.close();
                out.close();
                System.out.print("Output added: ");
                System.out.println(conn.getResponseCode());
                conn.disconnect();

                /***********************Start job*******************************/
                url = new URL (newJob + "/state?value=pending");
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setUseCaches(false);
                conn.setAllowUserInteraction(false);
                conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

                int response = conn.getResponseCode();
                conn.disconnect();
                System.out.print("Started job: ");
                System.out.println(response);
//                if(response!=204)
//                	break;
        
        	/************ Create quick job *******************/
//        		url = new URL("http://10.27.99.62/restapi/jobs_quick");
//        		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        		conn.setRequestMethod("POST");
//        		conn.setDoOutput(true);
//        		conn.setDoInput(true);
//        		conn.setUseCaches(false);
//        		conn.setAllowUserInteraction(false);
//        		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//
//        		// Create the form content
//        		OutputStream out = conn.getOutputStream();
//        		Writer writer = new OutputStreamWriter(out, "UTF-8");
//        		String paramName = "<job_quick>"+
//        				"<name>job_name</name>" +
//        				"<preset>directv_hd_fast</preset>"+
//        				"<segments>"+
//        				"<segment>"+
//        				"<input>\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\Content\\Ads\\RL10300008_H_30sec.mpg</input>"+
//        				"</segment>"+
//        				"</segments>"+
//        				"<output>\\\\isilonla3.vod.dtveng.net\\ifs\\Jeong\\output\\test123.ts</output>"+
//        				"<priority>urgent</priority>"+
//        				"</job_quick>";
//        		writer.write(paramName);
//        		writer.close();
//        		System.out.println(out.toString());
//        		out.close();
//        		System.out.print("Job created: ");
//        		System.out.println(conn.getResponseCode());
//
//        		// Buffer the result into a string
//        		BufferedReader rd = new BufferedReader(
//        				new InputStreamReader(conn.getInputStream()));
//        		StringBuilder sb = new StringBuilder();
//        		String line;
//        		while ((line = rd.readLine()) != null) {
//        			sb.append(line);
//        		}
//        		rd.close();
//        		conn.disconnect();
//        		System.out.println(sb);
/********************************************************************************************/
        	} catch (MalformedURLException ex) {
        		Logger.getLogger(RESTPost.class.getName()).log(Level.SEVERE, null, ex);
        		System.out.println(ex);
        	} catch (IOException ex) {
        		Logger.getLogger(RESTPost.class.getName()).log(Level.SEVERE, null, ex);
        		System.out.println(ex);
        	}
//            if(j%8==0)
//                try {
//                    Thread.sleep(60000);
//                } catch (InterruptedException ex) {
//                    System.out.println("Thread Interrupted");
//                }
        	System.out.println("end of loop");
        }

       
    }  
}
