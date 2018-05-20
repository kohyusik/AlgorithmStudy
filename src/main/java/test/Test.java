package test;

import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-04-30
 * @description :
 */
public class Test {
    
    public static void main(String[] args) throws Exception {
        
        String filePath = "k\\kohyusik/diek/kajwe.png";
        
        String rep = filePath.replace('\\','/');
        System.out.println(filePath);
        System.out.println(rep);
        System.out.println(new File("D:\\server_app\\files\\thumbnail\\k\\kohyusik\\39c63921-7934-46ec-b4fd-42beeec1b807.png").toURI());
    
        String ip = getLocalServerIp();
        System.out.println(">>>");
        System.out.println(ip);
        System.out.println(InetAddress.getLocalHost().getHostName());
        InetAddress local = InetAddress.getLocalHost();
    
        String ipa = local.getHostAddress();
    
        System.out.println(">>>");
        System.out.println(local);
        System.out.println(local.getHostName());
        System.out.println(ipa);
        
    }
    private static String getLocalServerIp() {
        String returnVal = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    System.out.println(intf.getDisplayName());
                    System.out.println(intf.getName());
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress.isSiteLocalAddress()) {
                        returnVal = inetAddress.getHostAddress();
                        System.out.println("returnVal : " + returnVal);
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return returnVal;
    }
}
