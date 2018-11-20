package ca.concordia.project.projectathena.ca.concordia.project.projectathena.dto;

public class AndroidProcess {

    private int pid;
    private String user;
    private double cpuUsage;
    private double memoryUsage;
    private String processName;

    public AndroidProcess(int pid, String user, double cpuUsage, double memoryUsage, String processName){
        this.pid = pid;
        this.user = user;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.processName = processName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public double getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
