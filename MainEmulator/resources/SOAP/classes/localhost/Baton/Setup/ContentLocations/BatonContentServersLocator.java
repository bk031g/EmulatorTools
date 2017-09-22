/**
 * BatonContentServersLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.Baton.Setup.ContentLocations;

public class BatonContentServersLocator extends org.apache.axis.client.Service implements localhost.Baton.Setup.ContentLocations.BatonContentServers {

    public BatonContentServersLocator() {
    }


    public BatonContentServersLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BatonContentServersLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BatonContentServerSoap
    private java.lang.String BatonContentServerSoap_address = "http://localhost:8080/Baton/Setup/ContentLocations";

    public java.lang.String getBatonContentServerSoapAddress() {
        return BatonContentServerSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BatonContentServerSoapWSDDServiceName = "BatonContentServerSoap";

    public java.lang.String getBatonContentServerSoapWSDDServiceName() {
        return BatonContentServerSoapWSDDServiceName;
    }

    public void setBatonContentServerSoapWSDDServiceName(java.lang.String name) {
        BatonContentServerSoapWSDDServiceName = name;
    }

    public localhost.Baton.Setup.ContentLocations.BatonContentLocations getBatonContentServerSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BatonContentServerSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBatonContentServerSoap(endpoint);
    }

    public localhost.Baton.Setup.ContentLocations.BatonContentLocations getBatonContentServerSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.Baton.Setup.ContentLocations.BatonContentServerSoapStub _stub = new localhost.Baton.Setup.ContentLocations.BatonContentServerSoapStub(portAddress, this);
            _stub.setPortName(getBatonContentServerSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBatonContentServerSoapEndpointAddress(java.lang.String address) {
        BatonContentServerSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.Baton.Setup.ContentLocations.BatonContentLocations.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.Baton.Setup.ContentLocations.BatonContentServerSoapStub _stub = new localhost.Baton.Setup.ContentLocations.BatonContentServerSoapStub(new java.net.URL(BatonContentServerSoap_address), this);
                _stub.setPortName(getBatonContentServerSoapWSDDServiceName());
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
        if ("BatonContentServerSoap".equals(inputPortName)) {
            return getBatonContentServerSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/Baton/Setup/ContentLocations/", "BatonContentServers");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/Baton/Setup/ContentLocations/", "BatonContentServerSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BatonContentServerSoap".equals(portName)) {
            setBatonContentServerSoapEndpointAddress(address);
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
