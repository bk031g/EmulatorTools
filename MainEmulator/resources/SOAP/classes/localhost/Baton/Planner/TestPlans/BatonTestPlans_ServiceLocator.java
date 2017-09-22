/**
 * BatonTestPlans_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.Baton.Planner.TestPlans;

public class BatonTestPlans_ServiceLocator extends org.apache.axis.client.Service implements localhost.Baton.Planner.TestPlans.BatonTestPlans_Service {

    public BatonTestPlans_ServiceLocator() {
    }


    public BatonTestPlans_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BatonTestPlans_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BatonTestPlansSoap
    private java.lang.String BatonTestPlansSoap_address = "http://localhost:8080/Baton/Planner/TestPlans";

    public java.lang.String getBatonTestPlansSoapAddress() {
        return BatonTestPlansSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BatonTestPlansSoapWSDDServiceName = "BatonTestPlansSoap";

    public java.lang.String getBatonTestPlansSoapWSDDServiceName() {
        return BatonTestPlansSoapWSDDServiceName;
    }

    public void setBatonTestPlansSoapWSDDServiceName(java.lang.String name) {
        BatonTestPlansSoapWSDDServiceName = name;
    }

    public localhost.Baton.Planner.TestPlans.BatonTestPlans_PortType getBatonTestPlansSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BatonTestPlansSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBatonTestPlansSoap(endpoint);
    }

    public localhost.Baton.Planner.TestPlans.BatonTestPlans_PortType getBatonTestPlansSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.Baton.Planner.TestPlans.BatonTestPlansSoapStub _stub = new localhost.Baton.Planner.TestPlans.BatonTestPlansSoapStub(portAddress, this);
            _stub.setPortName(getBatonTestPlansSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBatonTestPlansSoapEndpointAddress(java.lang.String address) {
        BatonTestPlansSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.Baton.Planner.TestPlans.BatonTestPlans_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.Baton.Planner.TestPlans.BatonTestPlansSoapStub _stub = new localhost.Baton.Planner.TestPlans.BatonTestPlansSoapStub(new java.net.URL(BatonTestPlansSoap_address), this);
                _stub.setPortName(getBatonTestPlansSoapWSDDServiceName());
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
        if ("BatonTestPlansSoap".equals(inputPortName)) {
            return getBatonTestPlansSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/Baton/Planner/TestPlans/", "BatonTestPlans");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/Baton/Planner/TestPlans/", "BatonTestPlansSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BatonTestPlansSoap".equals(portName)) {
            setBatonTestPlansSoapEndpointAddress(address);
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
