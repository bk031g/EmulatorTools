/**
 * BatonProfiles_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.Baton.Profiles;

public class BatonProfiles_ServiceLocator extends org.apache.axis.client.Service implements localhost.Baton.Profiles.BatonProfiles_Service {

    public BatonProfiles_ServiceLocator() {
    }


    public BatonProfiles_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BatonProfiles_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BatonProfilesSoap
    private java.lang.String BatonProfilesSoap_address = "http://localhost:8080/Baton/Profiles";

    public java.lang.String getBatonProfilesSoapAddress() {
        return BatonProfilesSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BatonProfilesSoapWSDDServiceName = "BatonProfilesSoap";

    public java.lang.String getBatonProfilesSoapWSDDServiceName() {
        return BatonProfilesSoapWSDDServiceName;
    }

    public void setBatonProfilesSoapWSDDServiceName(java.lang.String name) {
        BatonProfilesSoapWSDDServiceName = name;
    }

    public localhost.Baton.Profiles.BatonProfiles_PortType getBatonProfilesSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BatonProfilesSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBatonProfilesSoap(endpoint);
    }

    public localhost.Baton.Profiles.BatonProfiles_PortType getBatonProfilesSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.Baton.Profiles.BatonProfilesSoapStub _stub = new localhost.Baton.Profiles.BatonProfilesSoapStub(portAddress, this);
            _stub.setPortName(getBatonProfilesSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBatonProfilesSoapEndpointAddress(java.lang.String address) {
        BatonProfilesSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.Baton.Profiles.BatonProfiles_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.Baton.Profiles.BatonProfilesSoapStub _stub = new localhost.Baton.Profiles.BatonProfilesSoapStub(new java.net.URL(BatonProfilesSoap_address), this);
                _stub.setPortName(getBatonProfilesSoapWSDDServiceName());
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
        if ("BatonProfilesSoap".equals(inputPortName)) {
            return getBatonProfilesSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/Baton/Profiles/", "BatonProfiles");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/Baton/Profiles/", "BatonProfilesSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BatonProfilesSoap".equals(portName)) {
            setBatonProfilesSoapEndpointAddress(address);
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
