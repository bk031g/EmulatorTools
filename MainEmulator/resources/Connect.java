/**
* This is a part of the BATON product.
* Copyright (c) Interra Systems Inc.  All rights reserved.
*
* This source code is only intended as a supplement to the BATON API Reference
* and related electronic documentation provided with BATON.
* See these sources for detailed information regarding the BATON product.
*/


import java.net.MalformedURLException;
import java.util.Vector;
import java.io.IOException;
import java.util.List;

import org.apache.xmlrpc.*;

/**
 * This simple application demonstrates how to connect to Baton Application
 * using Baton XMLRPC API.
 *
 * The application uses Helma's XMLRPC library for Java.
 *
 * See comments below to understand the details of this program.
 *
 * @author Shailesh
 *
 */
class Connect
{
	//! The URL of Baton Application (http://ip_address:port)
	public static final String BATON_URL  = "http://localhost:8080";
	//! User Name (for authentication)
	public static final String USERNAME  = "admin";
	//! Password (for authentication)
	public static final String PASSWORD = "admin";
	public static void main(String args[])
	{
		System.out.println("Testing BATON XMLRPC API.");
		try
		{
			//! We create an instance of XmlRpcClient class and pass on the Baton application URL to it
			XmlRpcClient baton = new XmlRpcClient(BATON_URL);
			//! We specify the user name and password which will be used for HTTP Basic Authentication
			//! during XMLRPC calls
			baton.setBasicAuthentication(USERNAME, PASSWORD);
			//! We create a vector in which parameters for XMLRPC calls will be stored.
			Vector parameters = new Vector();
			//! for the following calls, the vector is empty
			//! We execute the call Baton.contents and get the result. The result is a list
			Object result = baton.execute("Baton.contents", parameters);
			if (result instanceof List)
			{
				System.out.println("Result is a list.");
			}
			//! We print the result
			System.out.println(result);
			//! We try to query the edition of Baton application that is running at the moment
			result = baton.execute("Baton.edition", parameters);
			//! Result is a String
			//! Lets print the result
			System.out.println(result);
		}
		catch (MalformedURLException e)
		{
			/**
			 * This exception would be thrown during the creation of XmlRpcClient.
			 * This means that the URL passed is not a well formed URL.
			 */
			System.out.println("URL of BATON Application is invalid.");
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
	}

}