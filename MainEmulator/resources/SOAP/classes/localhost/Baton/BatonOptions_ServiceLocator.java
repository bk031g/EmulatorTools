/**
 * BatonOptions_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.Baton;

public class BatonOptions_ServiceLocator extends org.apache.axis.client.Service implements localhost.Baton.BatonOptions_Service {

    public BatonOptions_ServiceLocator() {
    }


    public BatonOptions_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BatonOptions_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BatonOptionsSoap
    private java.lang.String BatonOptionsSoap_address = "http://localhost:8080/Baton";

    public java.lang.String getBatonOptionsSoapAddress() {
        return BatonOptionsSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BatonOptionsSoapWSDDServiceName = "BatonOptionsSoap";

    public java.lang.String getBatonOptionsSoapWSDDServiceName() {
        return BatonOptionsSoapWSDDServiceName;
    }

    public void setBatonOptionsSoapWSDDServiceName(java.lang.String name) {
        BatonOptionsSoapWSDDServiceName = name;
    }

    public localhost.Baton.BatonOptions_PortType getBatonOptionsSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BatonOptionsSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBatonOptionsSoap(endpoint);
    }

    public localhost.Baton.BatonOptions_PortType getBatonOptionsSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.Baton.BatonOptionsSoapStub _stub = new localhost.Baton.BatonOptionsSoapStub(portAddress, this);
            _stub.setPortName(getBatonOptionsSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBatonOptionsSoapEndpointAddress(java.lang.String address) {
        BatonOptionsSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.Baton.BatonOptions_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.Baton.BatonOptionsSoapStub _stub = new localhost.Baton.BatonOptionsSoapStub(new java.net.URL(BatonOptionsSoap_address), this);
                _stub.setPortName(getBatonOptionsSoapWSDDServiceName());
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
        if ("BatonOptionsSoap".equals(inputPortName)) {
            return getBatonOptionsSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/Baton/", "BatonOptions");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/Baton/", "BatonOptionsSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BatonOptionsSoap".equals(portName)) {
            setBatonOptionsSoapEndpointAddress(address);
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
