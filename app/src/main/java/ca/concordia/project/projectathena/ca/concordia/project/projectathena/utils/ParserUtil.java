package ca.concordia.project.projectathena.ca.concordia.project.projectathena.utils;


import ca.concordia.project.projectathena.ca.concordia.project.projectathena.dto.AndroidProcess;

public class ParserUtil {

    public static AndroidProcess parseProcess(String output){

        String firstChunk = output.split("\\[0m")[2].trim();
        String[] baseStringArray = firstChunk.split(" ");
        int pid = Integer.parseInt(baseStringArray[0].trim());
        String user = baseStringArray[1];
        double cpuUsage = Double.parseDouble(!baseStringArray[15].isEmpty() ? baseStringArray[15] : baseStringArray[16]);
        double memoryUsage = Double.parseDouble(!baseStringArray[18].isEmpty() ? baseStringArray[18] : baseStringArray[19]);
        String processName = baseStringArray[23].split("\\+")[0];

    return new AndroidProcess(pid, user, cpuUsage, memoryUsage, processName);
    }

}
