package localhost.Baton.Setup.ContentLocations;

public class BatonContentLocationsProxy implements localhost.Baton.Setup.ContentLocations.BatonContentLocations {
  private String _endpoint = null;
  private localhost.Baton.Setup.ContentLocations.BatonContentLocations batonContentLocations = null;
  
  public BatonContentLocationsProxy() {
    _initBatonContentLocationsProxy();
  }
  
  public BatonContentLocationsProxy(String endpoint) {
    _endpoint = endpoint;
    _initBatonContentLocationsProxy();
  }
  
  private void _initBatonContentLocationsProxy() {
    try {
      batonContentLocations = (new localhost.Baton.Setup.ContentLocations.BatonContentServersLocator()).getBatonContentServerSoap();
      if (batonContentLocations != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)batonContentLocations)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)batonContentLocations)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (batonContentLocations != null)
      ((javax.xml.rpc.Stub)batonContentLocations)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.Baton.Setup.ContentLocations.BatonContentLocations getBatonContentLocations() {
    if (batonContentLocations == null)
      _initBatonContentLocationsProxy();
    return batonContentLocations;
  }
  
  public boolean remove(java.lang.String locationName) throws java.rmi.RemoteException{
    if (batonContentLocations == null)
      _initBatonContentLocationsProxy();
    return batonContentLocations.remove(locationName);
  }
  
  public boolean registerUNCLocation(java.lang.String location, java.lang.String login, java.lang.String password, java.math.BigInteger tasklimit) throws java.rmi.RemoteException{
    if (batonContentLocations == null)
      _initBatonContentLocationsProxy();
    return batonContentLocations.registerUNCLocation(location, login, password, tasklimit);
  }
  
  public boolean registerFTPLocation(java.lang.String address, int port, java.lang.String login, java.lang.String password, java.lang.String ftpservertype, java.math.BigInteger tasklimit) throws java.rmi.RemoteException{
    if (batonContentLocations == null)
      _initBatonContentLocationsProxy();
    return batonContentLocations.registerFTPLocation(address, port, login, password, ftpservertype, tasklimit);
  }
  
  public boolean registerAMPLocation(java.lang.String address, java.lang.String transfertype, java.lang.String drive, java.lang.String ftpAddress, java.math.BigInteger tasklimit) throws java.rmi.RemoteException{
    if (batonContentLocations == null)
      _initBatonContentLocationsProxy();
    return batonContentLocations.registerAMPLocation(address, transfertype, drive, ftpAddress, tasklimit);
  }
  
  public boolean registerFSLocation(java.lang.String location, java.math.BigInteger tasklimit) throws java.rmi.RemoteException{
    if (batonContentLocations == null)
      _initBatonContentLocationsProxy();
    return batonContentLocations.registerFSLocation(location, tasklimit);
  }
  
  
}