/**
* This is a part of the BATON product.
* Copyright (c) Interra Systems Inc.  All rights reserved.
*
* This source code is only intended as a supplement to the BATON API Reference
* and related electronic documentation provided with BATON.
* See these sources for detailed information regarding the BATON product.
*/

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Vector;
import java.lang.Thread;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcClientException;

/**
 * This program demonstrates how to submit a task to Baton and get back the results in Java
 * using Baton XMLRPC API.
 *
 * The steps are as follows:
 *  - Setup an XMLRPC Client for Baton server
 *  - Submit a file for verification to Baton and get back a task id
 *  - Poll Baton for the status of the task till its complete
 *  - Get back the result
 * @author Shailesh
 *
 */
class VerifyFile
{
	//! The URL of Baton Application (http://ip_address:port)
	public static final String BATON_URL  = "http://localhost:8080";
	//! User Name (for authentication)
	public static final String USERNAME  = "admin";
	//! Password (for authentication)
	public static final String PASSWORD = "admin";
	//! Name of the file to be verified (is in the Content folder inside BatonAPISamples)
	public static final String MEDIA_FILE_NAME = "MPEG2PS_MPEG2v_720x480_MPEG1a.vob";
	//! Name of the test plan to be used for verification (should be lying in Baton System)
	public static final String TEST_PLAN_NAME = "MPEG2PS Test Plan";
	//! Version of the test plan to be used for verification (we will use draft version)
	public static final String TEST_PLAN_VERSION = "";
	//! Priority with which the file will be submitted to Baton
	public static final String PRIORITY = "High";

	/**
	 * Main function
	 * @param args
	 */
	public static void main(String args[])
	{
		String curDir = System.getProperty("user.dir");
		File currentDirectory = new File(curDir);
		File parentDirectory = currentDirectory.getParentFile();
		File contentDirectory = new File(parentDirectory + File.separator + "Content");
		System.out.println("Current Directory: " + curDir);
		System.out.println("Parent Directory: " + parentDirectory);
		System.out.println("Content Directory: " + contentDirectory);
		File mediaFilePath = new File(contentDirectory + File.separator + MEDIA_FILE_NAME);
		try
		{
			//! We create an instance of XmlRpcClient class and pass on the Baton application URL to it
			XmlRpcClient baton = new XmlRpcClient(BATON_URL);
			//! We specify the user name and password which will be used for HTTP Basic Authentication
			//! during XMLRPC calls
			baton.setBasicAuthentication(USERNAME, PASSWORD);


			/**
			 * Lets first ensure that the content location in which the Content is stored
			 * is registered with Baton
			 */
			Vector location = new Vector();
			location.addElement(contentDirectory.toString());
			baton.execute("Baton.Setup.ContentLocations.registerFSLocation", location);

			System.out.println("Verifying file: " + mediaFilePath + " With Test Plan: " + TEST_PLAN_NAME);
			/**
			 * Lets now try to schedule a file in the Contents directory to Baton
			 * for verification.
			 */
			//! The following vector will store parameters for verifyFile RPC call.
			Vector verifyFileParams = new Vector();
			verifyFileParams.addElement(TEST_PLAN_NAME);
			verifyFileParams.addElement(TEST_PLAN_VERSION);
			verifyFileParams.addElement(PRIORITY);
			verifyFileParams.addElement(mediaFilePath.toString());
			//! for the following calls, the vector is empty
			//! We execute the call Baton.contents and get the result. The result is a list
			Object result = baton.execute("Baton.Tasks.verifyFile", verifyFileParams);
			String taskId = (String) result;
			System.out.println("Task Id: " + taskId);


			//! Now lets wait till the task is complete
			Thread.sleep( 1000 );
			waitForTaskToComplete(baton, taskId);

		}
		catch (MalformedURLException e)
		{
			/**
			 * This exception would be thrown during the creation of XmlRpcClient.
			 * This means that the URL passed is not a well formed URL.
			 */
			System.out.println("URL of BATON Application is invalid.");
		}
		catch (XmlRpcClientException e)
		{
			/**
			 * This exception is thrown if the XMLRPC call has any problems.
			 */
			System.out.println("Problem with XMLRPC method call from client side.");
		}
		catch (IOException e)
		{
			/**
			 * This exception is typically thrown if Client is not able to make a connection
			 * with the Baton applicaiton (XMLRPC Server).
			 */
			System.out.println("Couldn't connect to Baton XMLRPC Server.");
		}
		catch (XmlRpcException e)
		{
			/**
			 * This exception is thrown if the XMLRPC call has any problems.
			 */
			System.out.println("Problem with XMLRPC method call.");
		}
		catch ( InterruptedException e )
		{
			/**
			 * We reach here only if any of the sleep calls above gets interrupted prematurely.
			 */
			System.out.println("Awakened Prematurely.");
		}
		catch ( Exception e )
		{
			System.out.println("Unknown exception.");
		}

	}

	/**
	 *  This function demonstrates how to wait for a task to complete whose task id is known.
	 * @param baton
	 * @param taskId
	 */
	private static void waitForTaskToComplete(XmlRpcClient baton, String taskId) throws Exception
	{

		/**
		 * lets just ensure that Task schedule is woken up and handles
		 * this task immediately
		 */
		Vector params = new Vector();
		baton.execute("Baton.wakeupTaskScheduler", params);

		String status = "Ready";
		//! Lets wait till the task has started running
		while (status.equals("Ready"))
		{
			status = taskStatusProgress(baton, taskId);
			Thread.sleep(1000);
		}
		System.out.println("The task is running now.");
		status = "Running";
		//! Lets wait till the task has completed
		while (status.equals("Running"))
		{
			status = taskStatusProgress(baton, taskId);
			Thread.sleep(1000);
		}
		System.out.println("The task is finished now.");
	}

	/**
	 *  This function queries the current status and progress of a task from  Baton
	 * @param baton
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	private static String taskStatusProgress(XmlRpcClient baton, String taskId) throws Exception
	{
		//! We create the parameters for status call
		Vector params = new Vector();
		params.addElement(taskId);
		//! lets get the task status
		Object result = baton.execute("Baton.Tasks.status", params);
		//! the result is actually a list containing two elements (status, description)
		List resultList = (List) result;
		//! lets get the status
		String status = (String) resultList.get(0);
		//! lets get status description
		String statusDescrption = (String) resultList.get(1);

		//! lets query Baton for how much progress has happened for this task
		result = baton.execute("Baton.Tasks.progress", params);
		//! result is an integer between 0 - 100
		Integer progress = (Integer) result;

		//! lets just print out this information for everybody's benefit
		System.out.println("Current Status: " + status + " Progress: " + progress);

		return status;
	}
}