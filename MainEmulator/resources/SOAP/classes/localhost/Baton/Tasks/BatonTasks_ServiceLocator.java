/**
 * BatonTasks_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.Baton.Tasks;

public class BatonTasks_ServiceLocator extends org.apache.axis.client.Service implements localhost.Baton.Tasks.BatonTasks_Service {

    public BatonTasks_ServiceLocator() {
    }


    public BatonTasks_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BatonTasks_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BatonTasksSoap
    private java.lang.String BatonTasksSoap_address = "http://localhost:8080/Baton/Tasks";

    public java.lang.String getBatonTasksSoapAddress() {
        return BatonTasksSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BatonTasksSoapWSDDServiceName = "BatonTasksSoap";

    public java.lang.String getBatonTasksSoapWSDDServiceName() {
        return BatonTasksSoapWSDDServiceName;
    }

    public void setBatonTasksSoapWSDDServiceName(java.lang.String name) {
        BatonTasksSoapWSDDServiceName = name;
    }

    public localhost.Baton.Tasks.BatonTasks_PortType getBatonTasksSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BatonTasksSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBatonTasksSoap(endpoint);
    }

    public localhost.Baton.Tasks.BatonTasks_PortType getBatonTasksSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.Baton.Tasks.BatonTasksSoapStub _stub = new localhost.Baton.Tasks.BatonTasksSoapStub(portAddress, this);
            _stub.setPortName(getBatonTasksSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBatonTasksSoapEndpointAddress(java.lang.String address) {
        BatonTasksSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.Baton.Tasks.BatonTasks_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.Baton.Tasks.BatonTasksSoapStub _stub = new localhost.Baton.Tasks.BatonTasksSoapStub(new java.net.URL(BatonTasksSoap_address), this);
                _stub.setPortName(getBatonTasksSoapWSDDServiceName());
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
        if ("BatonTasksSoap".equals(inputPortName)) {
            return getBatonTasksSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/Baton/Tasks/", "BatonTasks");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/Baton/Tasks/", "BatonTasksSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BatonTasksSoap".equals(portName)) {
            setBatonTasksSoapEndpointAddress(address);
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
