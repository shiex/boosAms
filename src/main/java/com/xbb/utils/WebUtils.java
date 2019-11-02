package com.xbb.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;

public class WebUtils {
    // 解析 Query 字符串
    public static HashMap<String, String> parseQuery(String query, String charset) {
        HashMap<String, String> params = new HashMap<String, String>();
        if (query == null)
            return params; // 为空

        String[] ppp = query.split("&"); // 用&分隔
        for (String p : ppp) {
            String[] kv = p.split("="); // key=value
            String key = kv[0];
            String value = "";
            if (key.length() > 1)
                value = kv[1]; // 有时候参数里传的是空值
            if (value.indexOf('%') >= 0) {
                // 如果存在百分号, 则进行URL解码
                try {
                    value = URLDecoder.decode(value, charset);
                } catch (Exception e) {
                }
            }
            params.put(key, value);
        }
        return params;
    }

    public static String readAsText(InputStream inStream, String charset, int maxSize) throws IOException {
        ByteArrayOutputStream cache = new ByteArrayOutputStream(1024 * 16);
        byte[] data = new byte[1024];

        int numOfWait = 0;
        while (true) {
            int n = inStream.read(data); // n: 实际读取的字节数
            if (n < 0)
                break; // 连接已经断开
            if (n == 0) {
                if (numOfWait++ >= 3)
                    break; // 此种情况不得连续3次
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                }
                continue;// 数据未完 //
            }
            numOfWait = 0;

            // 缓存起来
            cache.write(data, 0, n);
            if (cache.size() > maxSize) // 上限, 最多读取512K
                break;
        }

        return cache.toString(charset);
    }
}
