/**
 * 
 */
package com.axis.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;

import localhost.Baton.Tasks.BatonTasks_PortType;
import localhost.Baton.Tasks.BatonTasks_ServiceLocator;

/**
 * @author saurabhk
 *
 */
public class TestTasks {

	/**
	 * @param args
	 * @throws ServiceException 
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws ServiceException, RemoteException {
		BatonTasks_ServiceLocator locator = new BatonTasks_ServiceLocator();
		BatonTasks_PortType port = locator.getBatonTasksSoap();
		
		((Stub) port)._setProperty(Call.USERNAME_PROPERTY, "admin");
		((Stub) port)._setProperty(Call.PASSWORD_PROPERTY, "admin");
		
		/* will return a JSON formatted string of the Task Information */
		String str = port.taskInfo(new String[]{"000001392ed54cc627face2b00c000a800040065"});
		System.out.println(str);
		
		/*
		 * If the method is successful, a string specifying the Task Id of the
		 * task is returned
		 */
		String verify = port.verifyFile("Audio Test Plan",1,"High","C:\\Documents and Settings\\All Users\\Documents\\My Music\\Sample Music\\New Stories (Highway Blues).wma",new int[] {1});
		System.out.println(verify);
	}

}
