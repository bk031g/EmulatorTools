/**
 * BatonCheckers_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.Baton.Setup.Checkers;

public interface BatonCheckers_PortType extends java.rmi.Remote {
    public boolean register(java.lang.String address, int port) throws java.rmi.RemoteException;
    public boolean remove(java.lang.String address, int port) throws java.rmi.RemoteException;
    public boolean makePrimaryChecker(java.lang.String checker) throws java.rmi.RemoteException;
    public boolean makeSecondaryChecker(java.lang.String checker) throws java.rmi.RemoteException;
}
