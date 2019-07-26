package com.changhr.utils.custom;

import javax.servlet.http.HttpServletRequest;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * 获取真实的 IP 地址
 *
 * @author changhr
 * @create 2019-07-26 9:20
 */
public class IPUtils {

    public static final String IP_255 = "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
    public static final Pattern IP_PATTERN = Pattern.compile("^(?:" + IP_255 + "\\.){3}" + IP_255 + "$");

    public static String longToIpV4(long longIp) {
        int octet3 = (int) ((longIp >> 24) % 256);
        int octet2 = (int) ((longIp >> 16) % 256);
        int octet1 = (int) ((longIp >> 8) % 256);
        int octet0 = (int) ((longIp) % 256);
        return octet3 + "." + octet2 + "." + octet1 + "." + octet0;
    }

    public static long ipV4ToLong(String ip) {
        String[] octets = ip.split("\\.");
        return (Long.parseLong(octets[0]) << 24) + (Integer.parseInt(octets[1]) << 16)
                + (Integer.parseInt(octets[2]) << 8) + Integer.parseInt(octets[3]);
    }

    public static boolean isIpV4Private(String ip) {
        long longIp = ipV4ToLong(ip);
        return (longIp >= ipV4ToLong("10.0.0.0") && longIp <= ipV4ToLong("10.255.255.255"))
                || (longIp >= ipV4ToLong("172.16.0.0") && longIp <= ipV4ToLong("172.31.255.255"))
                || longIp >= ipV4ToLong("192.168.0.0") && longIp <= ipV4ToLong("192.168.255.255");
    }

    public static boolean isIpV4Valid(String ip) {
        return IP_PATTERN.matcher(ip).matches();
    }

    public static String getIpFromRequest(HttpServletRequest request) {
        String ip;
        boolean found = false;

        if ((ip = request.getHeader("X-forwarded-for")) != null) {
            StringTokenizer tokenizer = new StringTokenizer(ip, ",");
            while (tokenizer.hasMoreTokens()) {
                ip = tokenizer.nextToken().trim();
                if (isIpV4Valid(ip) && !isIpV4Private(ip)) {
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
