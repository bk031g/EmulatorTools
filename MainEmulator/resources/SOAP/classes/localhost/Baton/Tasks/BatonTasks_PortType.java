/**
 * BatonTasks_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.Baton.Tasks;

public interface BatonTasks_PortType extends java.rmi.Remote {
    public int numAllTasks() throws java.rmi.RemoteException;
    public java.util.Calendar schedulingTime(java.lang.String taskId) throws java.rmi.RemoteException;
    public java.util.Calendar startTime(java.lang.String taskId) throws java.rmi.RemoteException;
    public java.util.Calendar finishTime(java.lang.String taskId) throws java.rmi.RemoteException;
    public java.lang.String[] allTasks() throws java.rmi.RemoteException;
    public int numTasksInQueue() throws java.rmi.RemoteException;
    public int numTasksInProgress() throws java.rmi.RemoteException;
    public int numTasksCompleted() throws java.rmi.RemoteException;
    public java.lang.String taskInfo(java.lang.String[] taskIds) throws java.rmi.RemoteException;
    public java.lang.String[] tasksInQueue() throws java.rmi.RemoteException;
    public java.lang.String[] tasksInProgress() throws java.rmi.RemoteException;
    public java.lang.String[] tasksCompleted() throws java.rmi.RemoteException;
    public int numRecentTasks() throws java.rmi.RemoteException;
    public java.lang.String[] recentTasks() throws java.rmi.RemoteException;
    public java.lang.String verifyFile(java.lang.String testPlan, int testPlanVersionNum, java.lang.String priority, java.lang.String mediaFilePath, int[] checkers) throws java.rmi.RemoteException;
    public java.lang.String[] verifyFiles(java.lang.String testPlan, int testPlanVersionNum, java.lang.String priority, java.lang.String[] mediaFilesPath, int[] checkers) throws java.rmi.RemoteException;
    public java.lang.String[] verifyFolder(java.lang.String testPlan, int testPlanVersionNum, java.lang.String priority, java.lang.String mediaFolderPath, int[] checkers) throws java.rmi.RemoteException;
    public java.lang.String[] status(java.lang.String taskId) throws java.rmi.RemoteException;
    public java.lang.String report(java.lang.String taskId) throws java.rmi.RemoteException;
    public java.lang.String reportInPDF(java.lang.String taskId) throws java.rmi.RemoteException;
}
