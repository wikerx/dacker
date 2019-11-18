package com.scott.ds.utils;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 作者： 薛俊鹏
 * 时间： 2018-8-21下午12:43:05
 * 内容： java获取本机IP 适配Linux
 * 状态： 编写
 */
public class LocalIP {
	public static boolean isWindowOS() {
        boolean isWindowOS = false;
        String osName = System.getProperty("os.name");
        if(osName.toLowerCase().indexOf("windows") > -1) {
            isWindowOS = true;
        }
        return isWindowOS;
    }
    
    public static InetAddress getInetAddress() {
        InetAddress inetAddress = null;
        try {
            //如果是windows操作系统
            if (isWindowOS()) {
                inetAddress = InetAddress.getLocalHost();
            } else {
                boolean bFindIP = false;
                //定义一个内容都是NetworkInterface的枚举对象
                Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) 
                        NetworkInterface.getNetworkInterfaces();
                //如果枚举对象里面还有内容(NetworkInterface)
                while (netInterfaces.hasMoreElements()) {
                    if (bFindIP) {
                        break;
                    }
                    //获取下一个内容(NetworkInterface)
                    NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                    //----------特定情况，可以考虑用ni.getName判断
                    //遍历所有IP
                    Enumeration<InetAddress> ips = ni.getInetAddresses();
                    while (ips.hasMoreElements()) {
                        inetAddress = (InetAddress) ips.nextElement();
                        if (inetAddress.isSiteLocalAddress()         //属于本地地址
                                && !inetAddress.isLoopbackAddress()  //不是回环地址
                                && inetAddress.getHostAddress().indexOf(":") == -1) {   //地址里面没有:号
                            bFindIP = true;     //找到了地址
                            break;              //退出循环
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inetAddress;
    }

    /**
     * 获取IP地址
     * */
    public static String getLocalIP() {
        return getInetAddress().getHostAddress();
    }

    
}
