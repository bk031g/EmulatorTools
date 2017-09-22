/**
 * 
 */
package com.axis.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import localhost.Baton.Planner.TestPlans.BatonTestPlans_PortType;
import localhost.Baton.Planner.TestPlans.BatonTestPlans_ServiceLocator;

import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;

/**
 * @author saurabhk
 * 
 */
public class TestTestPlans {

	/**
	 * @param args
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws ServiceException,
			RemoteException {
		BatonTestPlans_ServiceLocator testPlansLocator = new BatonTestPlans_ServiceLocator();
		BatonTestPlans_PortType testPlansPort = testPlansLocator
				.getBatonTestPlansSoap();

		((Stub) testPlansPort)._setProperty(Call.USERNAME_PROPERTY, "admin");
		((Stub) testPlansPort)._setProperty(Call.PASSWORD_PROPERTY, "admin");

		/* will return an xml of the Test Plan */
		String xmlTestPlan = testPlansPort.xmlExport("Audio Test Plan");
		System.out.println(xmlTestPlan);
	}

}
