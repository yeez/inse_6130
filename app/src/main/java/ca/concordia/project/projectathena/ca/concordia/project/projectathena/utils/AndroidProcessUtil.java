package ca.concordia.project.projectathena.ca.concordia.project.projectathena.utils;

import java.io.IOException;
import java.io.InputStream;

import ca.concordia.project.projectathena.ca.concordia.project.projectathena.dto.AndroidProcess;


public class AndroidProcessUtil {

    private static final String CMD_TOP = "top -m 1 -d 1 -n 1";
    private static final String CMD_KILL = "kill -9 ";
    private static String output = "";
    private static InputStream inputStream;
    private static Process process;

    public static String getProcessUsage() {

        byte[] byteArray;
        byteArray = new byte[1024];
        try {
            process = Runtime.getRuntime().exec(CMD_TOP);
            inputStream = process.getInputStream();
            while (inputStream.read(byteArray) != -1) {
                output = output + new String(byteArray) + "\n";
            }
            inputStream.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return output;
    }

    public static boolean isProcessIsMalicious(AndroidProcess androidProcess){
        return androidProcess.getCpuUsage() > 9.0 || androidProcess.getMemoryUsage() > 9.0;
    }

    public static void killSelectedProcess(AndroidProcess androidProcess) throws IOException {
        process = Runtime.getRuntime().exec(CMD_KILL + androidProcess.getPid());
    }
}
