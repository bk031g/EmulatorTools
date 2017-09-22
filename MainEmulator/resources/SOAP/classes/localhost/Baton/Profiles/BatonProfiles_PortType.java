/**
 * BatonProfiles_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.Baton.Profiles;

public interface BatonProfiles_PortType extends java.rmi.Remote {
    public java.lang.String profileInfo(java.lang.String profileId) throws java.rmi.RemoteException;
    public java.lang.String profileFile(java.lang.String mediaFilePath) throws java.rmi.RemoteException;
    public java.lang.String[] profileFolder(java.lang.String mediaFilePath) throws java.rmi.RemoteException;
    public java.lang.String deleteProfile(java.lang.String profileId) throws java.rmi.RemoteException;
    public java.lang.String createTestPlanFromProfiles(java.lang.String[] profileIds, java.lang.String testPlanName) throws java.rmi.RemoteException;
}
