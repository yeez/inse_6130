package ca.concordia.project.projectathena.ca.concordia.project.projectathena.utils;


import ca.concordia.project.projectathena.ca.concordia.project.projectathena.dto.AndroidProcess;

public class ParserUtil {

    private static int pid;
    private static String user;
    private static double cpuUsage;
    private static double memoryUsage;
    private static String processName;

    public static AndroidProcess parseProcess(String output) {
        try {
            String firstChunk = output.split("\\[0m")[2].trim();
            String[] baseStringArray = firstChunk.split(" ");
            pid = Integer.parseInt(baseStringArray[0].trim());
            user = baseStringArray[1];
            cpuUsage = Double.parseDouble(!baseStringArray[17].isEmpty() ? baseStringArray[17] : !baseStringArray[16].isEmpty() ? baseStringArray[16] : baseStringArray[15]);
            memoryUsage = Double.parseDouble(!baseStringArray[20].isEmpty() ? baseStringArray[20] : !baseStringArray[19].isEmpty() ? baseStringArray[19] : baseStringArray[18]);
            processName = baseStringArray[23].split("\\+")[0];

            return new AndroidProcess(pid, user, cpuUsage, memoryUsage, processName);
        }catch (Exception e){
            return new AndroidProcess(1111, "foo", 0.0, 0.0, "foo"); //This is to prevent the application to stop in case of error in the parser
        }
    }
}
