package step002.web.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellCommander {
    
    public static void main(String[] args) {
        ShellCommander sc = new ShellCommander();
//        String result = sc.execute("ping 127.0.0.1");
        String result = sc.execute("ping 127.0.0.1");
        System.out.println(result);
    }
    
    public String execute(String command) {
        
        StringBuffer output = new StringBuffer();
        Process process = null;
        BufferedReader bufferReader = null;
        Runtime runtime = Runtime.getRuntime();
        String osName = System.getProperty("os.name");
        
        //윈도우일 경우
        if (osName.indexOf("Windows") > -1) {
            command = "cmd /c " + command;
        }
        
        try {
            process = runtime.exec(command);
            
            // shell 실행이 정상 동작
            bufferReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String msg = null;
            while ((msg = bufferReader.readLine()) != null) {
                output.append(msg + System.getProperty("line.separator"));
            }
            bufferReader.close();
            
            // shell 실행시 에러가 발생
            bufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((msg = bufferReader.readLine()) != null) {
                output.append(msg + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            output.append("IOException : " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                process.destroy();
                if (bufferReader != null)
                    bufferReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        
        return output.toString();
    }
}