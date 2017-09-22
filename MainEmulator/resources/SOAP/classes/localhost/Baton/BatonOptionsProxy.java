package localhost.Baton;

public class BatonOptionsProxy implements localhost.Baton.BatonOptions_PortType {
  private String _endpoint = null;
  private localhost.Baton.BatonOptions_PortType batonOptions_PortType = null;
  
  public BatonOptionsProxy() {
    _initBatonOptionsProxy();
  }
  
  public BatonOptionsProxy(String endpoint) {
    _endpoint = endpoint;
    _initBatonOptionsProxy();
  }
  
  private void _initBatonOptionsProxy() {
    try {
      batonOptions_PortType = (new localhost.Baton.BatonOptions_ServiceLocator()).getBatonOptionsSoap();
      if (batonOptions_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)batonOptions_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)batonOptions_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (batonOptions_PortType != null)
      ((javax.xml.rpc.Stub)batonOptions_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.Baton.BatonOptions_PortType getBatonOptions_PortType() {
    if (batonOptions_PortType == null)
      _initBatonOptionsProxy();
    return batonOptions_PortType;
  }
  
  public java.lang.String contents() throws java.rmi.RemoteException{
    if (batonOptions_PortType == null)
      _initBatonOptionsProxy();
    return batonOptions_PortType.contents();
  }
  
  public java.lang.String edition() throws java.rmi.RemoteException{
    if (batonOptions_PortType == null)
      _initBatonOptionsProxy();
    return batonOptions_PortType.edition();
  }
  
  public int majorVersion() throws java.rmi.RemoteException{
    if (batonOptions_PortType == null)
      _initBatonOptionsProxy();
    return batonOptions_PortType.majorVersion();
  }
  
  public int minorVersion() throws java.rmi.RemoteException{
    if (batonOptions_PortType == null)
      _initBatonOptionsProxy();
    return batonOptions_PortType.minorVersion();
  }
  
  public int patchVersion() throws java.rmi.RemoteException{
    if (batonOptions_PortType == null)
      _initBatonOptionsProxy();
    return batonOptions_PortType.patchVersion();
  }
  
  public boolean installationIsComplete() throws java.rmi.RemoteException{
    if (batonOptions_PortType == null)
      _initBatonOptionsProxy();
    return batonOptions_PortType.installationIsComplete();
  }
  
  
}