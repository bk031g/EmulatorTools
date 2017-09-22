/**
 * 
 */
package com.axis.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import localhost.Baton.Setup.Checkers.BatonCheckers_PortType;
import localhost.Baton.Setup.Checkers.BatonCheckers_ServiceLocator;

import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;

/**
 * @author saurabhk
 * 
 */
public class TestCheckers {

	/**
	 * @param args
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws ServiceException,
			RemoteException {
		BatonCheckers_ServiceLocator checkersLocator = new BatonCheckers_ServiceLocator();
		BatonCheckers_PortType checkersPort = checkersLocator
				.getBatonCheckersSoap();

		((Stub) checkersPort)._setProperty(Call.USERNAME_PROPERTY, "admin");
		((Stub) checkersPort)._setProperty(Call.PASSWORD_PROPERTY, "admin");

		/* will return true if checker registered successfully */
		System.out.println(checkersPort.register("192.168.4.101", 9000));

	}

}
