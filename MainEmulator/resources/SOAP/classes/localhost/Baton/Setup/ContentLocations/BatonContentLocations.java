/**
 * BatonContentLocations.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.Baton.Setup.ContentLocations;

public interface BatonContentLocations extends java.rmi.Remote {
    public boolean remove(java.lang.String locationName) throws java.rmi.RemoteException;
    public boolean registerUNCLocation(java.lang.String location, java.lang.String login, java.lang.String password, java.math.BigInteger tasklimit) throws java.rmi.RemoteException;
    public boolean registerFTPLocation(java.lang.String address, int port, java.lang.String login, java.lang.String password, java.lang.String ftpservertype, java.math.BigInteger tasklimit) throws java.rmi.RemoteException;
    public boolean registerAMPLocation(java.lang.String address, java.lang.String transfertype, java.lang.String drive, java.lang.String ftpAddress, java.math.BigInteger tasklimit) throws java.rmi.RemoteException;
    public boolean registerFSLocation(java.lang.String location, java.math.BigInteger tasklimit) throws java.rmi.RemoteException;
}
