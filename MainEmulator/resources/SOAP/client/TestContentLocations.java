/**
 * 
 */
package com.axis.client;

import java.math.BigInteger;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import localhost.Baton.Setup.ContentLocations.BatonContentLocations;
import localhost.Baton.Setup.ContentLocations.BatonContentServersLocator;

import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;

/**
 * @author saurabhk
 * 
 */
public class TestContentLocations {

	/**
	 * @param args
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws ServiceException,
			RemoteException {
		BatonContentServersLocator contentLocator = new BatonContentServersLocator();
		BatonContentLocations contentPort = contentLocator
				.getBatonContentServerSoap();

		((Stub) contentPort)._setProperty(Call.USERNAME_PROPERTY, "admin");
		((Stub) contentPort)._setProperty(Call.PASSWORD_PROPERTY, "admin");

		BigInteger taskLimit = new BigInteger("10");

		/* will return true if FTP location is registered successfully */
		System.out.println(contentPort.registerFTPLocation("192.168.4.101", 21,
				"media", "xp2kal1", "Standard", taskLimit));
	}

}
