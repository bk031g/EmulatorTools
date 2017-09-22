package localhost.Baton.Planner.TestPlans;

public class BatonTestPlansProxy implements localhost.Baton.Planner.TestPlans.BatonTestPlans_PortType {
  private String _endpoint = null;
  private localhost.Baton.Planner.TestPlans.BatonTestPlans_PortType batonTestPlans_PortType = null;
  
  public BatonTestPlansProxy() {
    _initBatonTestPlansProxy();
  }
  
  public BatonTestPlansProxy(String endpoint) {
    _endpoint = endpoint;
    _initBatonTestPlansProxy();
  }
  
  private void _initBatonTestPlansProxy() {
    try {
      batonTestPlans_PortType = (new localhost.Baton.Planner.TestPlans.BatonTestPlans_ServiceLocator()).getBatonTestPlansSoap();
      if (batonTestPlans_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)batonTestPlans_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)batonTestPlans_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (batonTestPlans_PortType != null)
      ((javax.xml.rpc.Stub)batonTestPlans_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.Baton.Planner.TestPlans.BatonTestPlans_PortType getBatonTestPlans_PortType() {
    if (batonTestPlans_PortType == null)
      _initBatonTestPlansProxy();
    return batonTestPlans_PortType;
  }
  
  public java.lang.String xmlExport(java.lang.String testPlanName) throws java.rmi.RemoteException{
    if (batonTestPlans_PortType == null)
      _initBatonTestPlansProxy();
    return batonTestPlans_PortType.xmlExport(testPlanName);
  }
  
  public java.lang.String xmlImport(java.lang.String xml, boolean overwriteFlag) throws java.rmi.RemoteException{
    if (batonTestPlans_PortType == null)
      _initBatonTestPlansProxy();
    return batonTestPlans_PortType.xmlImport(xml, overwriteFlag);
  }
  
  
}