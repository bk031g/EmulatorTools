/**
 * BatonTestPlans_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.Baton.Planner.TestPlans;

public interface BatonTestPlans_PortType extends java.rmi.Remote {
    public java.lang.String xmlExport(java.lang.String testPlanName) throws java.rmi.RemoteException;
    public java.lang.String xmlImport(java.lang.String xml, boolean overwriteFlag) throws java.rmi.RemoteException;
}
