package localhost.Baton.Setup.Checkers;

public class BatonCheckersProxy implements localhost.Baton.Setup.Checkers.BatonCheckers_PortType {
  private String _endpoint = null;
  private localhost.Baton.Setup.Checkers.BatonCheckers_PortType batonCheckers_PortType = null;
  
  public BatonCheckersProxy() {
    _initBatonCheckersProxy();
  }
  
  public BatonCheckersProxy(String endpoint) {
    _endpoint = endpoint;
    _initBatonCheckersProxy();
  }
  
  private void _initBatonCheckersProxy() {
    try {
      batonCheckers_PortType = (new localhost.Baton.Setup.Checkers.BatonCheckers_ServiceLocator()).getBatonCheckersSoap();
      if (batonCheckers_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)batonCheckers_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)batonCheckers_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (batonCheckers_PortType != null)
      ((javax.xml.rpc.Stub)batonCheckers_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.Baton.Setup.Checkers.BatonCheckers_PortType getBatonCheckers_PortType() {
    if (batonCheckers_PortType == null)
      _initBatonCheckersProxy();
    return batonCheckers_PortType;
  }
  
  public boolean register(java.lang.String address, int port) throws java.rmi.RemoteException{
    if (batonCheckers_PortType == null)
      _initBatonCheckersProxy();
    return batonCheckers_PortType.register(address, port);
  }
  
  public boolean remove(java.lang.String address, int port) throws java.rmi.RemoteException{
    if (batonCheckers_PortType == null)
      _initBatonCheckersProxy();
    return batonCheckers_PortType.remove(address, port);
  }
  
  public boolean makePrimaryChecker(java.lang.String checker) throws java.rmi.RemoteException{
    if (batonCheckers_PortType == null)
      _initBatonCheckersProxy();
    return batonCheckers_PortType.makePrimaryChecker(checker);
  }
  
  public boolean makeSecondaryChecker(java.lang.String checker) throws java.rmi.RemoteException{
    if (batonCheckers_PortType == null)
      _initBatonCheckersProxy();
    return batonCheckers_PortType.makeSecondaryChecker(checker);
  }
  
  
}