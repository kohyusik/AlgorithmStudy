package test;

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
