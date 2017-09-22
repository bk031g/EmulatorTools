package localhost.Baton.Tasks;

public class BatonTasksProxy implements localhost.Baton.Tasks.BatonTasks_PortType {
  private String _endpoint = null;
  private localhost.Baton.Tasks.BatonTasks_PortType batonTasks_PortType = null;
  
  public BatonTasksProxy() {
    _initBatonTasksProxy();
  }
  
  public BatonTasksProxy(String endpoint) {
    _endpoint = endpoint;
    _initBatonTasksProxy();
  }
  
  private void _initBatonTasksProxy() {
    try {
      batonTasks_PortType = (new localhost.Baton.Tasks.BatonTasks_ServiceLocator()).getBatonTasksSoap();
      if (batonTasks_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)batonTasks_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)batonTasks_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (batonTasks_PortType != null)
      ((javax.xml.rpc.Stub)batonTasks_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.Baton.Tasks.BatonTasks_PortType getBatonTasks_PortType() {
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType;
  }
  
  public int numAllTasks() throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.numAllTasks();
  }
  
  public java.util.Calendar schedulingTime(java.lang.String taskId) throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.schedulingTime(taskId);
  }
  
  public java.util.Calendar startTime(java.lang.String taskId) throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.startTime(taskId);
  }
  
  public java.util.Calendar finishTime(java.lang.String taskId) throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.finishTime(taskId);
  }
  
  public java.lang.String[] allTasks() throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.allTasks();
  }
  
  public int numTasksInQueue() throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.numTasksInQueue();
  }
  
  public int numTasksInProgress() throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.numTasksInProgress();
  }
  
  public int numTasksCompleted() throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.numTasksCompleted();
  }
  
  public java.lang.String taskInfo(java.lang.String[] taskIds) throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.taskInfo(taskIds);
  }
  
  public java.lang.String[] tasksInQueue() throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.tasksInQueue();
  }
  
  public java.lang.String[] tasksInProgress() throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.tasksInProgress();
  }
  
  public java.lang.String[] tasksCompleted() throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.tasksCompleted();
  }
  
  public int numRecentTasks() throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.numRecentTasks();
  }
  
  public java.lang.String[] recentTasks() throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.recentTasks();
  }
  
  public java.lang.String verifyFile(java.lang.String testPlan, int testPlanVersionNum, java.lang.String priority, java.lang.String mediaFilePath, int[] checkers) throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.verifyFile(testPlan, testPlanVersionNum, priority, mediaFilePath, checkers);
  }
  
  public java.lang.String[] verifyFiles(java.lang.String testPlan, int testPlanVersionNum, java.lang.String priority, java.lang.String[] mediaFilesPath, int[] checkers) throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.verifyFiles(testPlan, testPlanVersionNum, priority, mediaFilesPath, checkers);
  }
  
  public java.lang.String[] verifyFolder(java.lang.String testPlan, int testPlanVersionNum, java.lang.String priority, java.lang.String mediaFolderPath, int[] checkers) throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.verifyFolder(testPlan, testPlanVersionNum, priority, mediaFolderPath, checkers);
  }
  
  public java.lang.String[] status(java.lang.String taskId) throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.status(taskId);
  }
  
  public java.lang.String report(java.lang.String taskId) throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.report(taskId);
  }
  
  public java.lang.String reportInPDF(java.lang.String taskId) throws java.rmi.RemoteException{
    if (batonTasks_PortType == null)
      _initBatonTasksProxy();
    return batonTasks_PortType.reportInPDF(taskId);
  }
  
  
}