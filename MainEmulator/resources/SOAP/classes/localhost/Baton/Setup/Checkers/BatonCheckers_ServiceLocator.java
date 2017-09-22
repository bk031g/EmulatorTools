/**
 * BatonCheckers_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.Baton.Setup.Checkers;

public class BatonCheckers_ServiceLocator extends org.apache.axis.client.Service implements localhost.Baton.Setup.Checkers.BatonCheckers_Service {

    public BatonCheckers_ServiceLocator() {
    }


    public BatonCheckers_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BatonCheckers_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BatonCheckersSoap
    private java.lang.String BatonCheckersSoap_address = "http://localhost:8080/Baton/Setup/Checkers";

    public java.lang.String getBatonCheckersSoapAddress() {
        return BatonCheckersSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BatonCheckersSoapWSDDServiceName = "BatonCheckersSoap";

    public java.lang.String getBatonCheckersSoapWSDDServiceName() {
        return BatonCheckersSoapWSDDServiceName;
    }

    public void setBatonCheckersSoapWSDDServiceName(java.lang.String name) {
        BatonCheckersSoapWSDDServiceName = name;
    }

    public localhost.Baton.Setup.Checkers.BatonCheckers_PortType getBatonCheckersSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BatonCheckersSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBatonCheckersSoap(endpoint);
    }

    public localhost.Baton.Setup.Checkers.BatonCheckers_PortType getBatonCheckersSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.Baton.Setup.Checkers.BatonCheckersSoapStub _stub = new localhost.Baton.Setup.Checkers.BatonCheckersSoapStub(portAddress, this);
            _stub.setPortName(getBatonCheckersSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBatonCheckersSoapEndpointAddress(java.lang.String address) {
        BatonCheckersSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.Baton.Setup.Checkers.BatonCheckers_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.Baton.Setup.Checkers.BatonCheckersSoapStub _stub = new localhost.Baton.Setup.Checkers.BatonCheckersSoapStub(new java.net.URL(BatonCheckersSoap_address), this);
                _stub.setPortName(getBatonCheckersSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BatonCheckersSoap".equals(inputPortName)) {
            return getBatonCheckersSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/Baton/Setup/Checkers/", "BatonCheckers");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/Baton/Setup/Checkers/", "BatonCheckersSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BatonCheckersSoap".equals(portName)) {
            setBatonCheckersSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
