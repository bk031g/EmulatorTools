package localhost.Baton.Profiles;

public class BatonProfilesProxy implements localhost.Baton.Profiles.BatonProfiles_PortType {
  private String _endpoint = null;
  private localhost.Baton.Profiles.BatonProfiles_PortType batonProfiles_PortType = null;
  
  public BatonProfilesProxy() {
    _initBatonProfilesProxy();
  }
  
  public BatonProfilesProxy(String endpoint) {
    _endpoint = endpoint;
    _initBatonProfilesProxy();
  }
  
  private void _initBatonProfilesProxy() {
    try {
      batonProfiles_PortType = (new localhost.Baton.Profiles.BatonProfiles_ServiceLocator()).getBatonProfilesSoap();
      if (batonProfiles_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)batonProfiles_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)batonProfiles_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (batonProfiles_PortType != null)
      ((javax.xml.rpc.Stub)batonProfiles_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.Baton.Profiles.BatonProfiles_PortType getBatonProfiles_PortType() {
    if (batonProfiles_PortType == null)
      _initBatonProfilesProxy();
    return batonProfiles_PortType;
  }
  
  public java.lang.String profileInfo(java.lang.String profileId) throws java.rmi.RemoteException{
    if (batonProfiles_PortType == null)
      _initBatonProfilesProxy();
    return batonProfiles_PortType.profileInfo(profileId);
  }
  
  public java.lang.String profileFile(java.lang.String mediaFilePath) throws java.rmi.RemoteException{
    if (batonProfiles_PortType == null)
      _initBatonProfilesProxy();
    return batonProfiles_PortType.profileFile(mediaFilePath);
  }
  
  public java.lang.String[] profileFolder(java.lang.String mediaFilePath) throws java.rmi.RemoteException{
    if (batonProfiles_PortType == null)
      _initBatonProfilesProxy();
    return batonProfiles_PortType.profileFolder(mediaFilePath);
  }
  
  public java.lang.String deleteProfile(java.lang.String profileId) throws java.rmi.RemoteException{
    if (batonProfiles_PortType == null)
      _initBatonProfilesProxy();
    return batonProfiles_PortType.deleteProfile(profileId);
  }
  
  public java.lang.String createTestPlanFromProfiles(java.lang.String[] profileIds, java.lang.String testPlanName) throws java.rmi.RemoteException{
    if (batonProfiles_PortType == null)
      _initBatonProfilesProxy();
    return batonProfiles_PortType.createTestPlanFromProfiles(profileIds, testPlanName);
  }
  
  
}