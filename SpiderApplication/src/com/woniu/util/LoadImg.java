package com.woniu.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadImg {
	public static void downloadPicture(String downUrl, String imgPath) throws Exception {
		//downUrl：图片下载地址
		//imgPath：本地磁盘地址，如 d://card/test.png
        URL url = new URL(downUrl);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setConnectTimeout(6000);
        urlCon.setReadTimeout(12000);
        int code = urlCon.getResponseCode();
        if (code != HttpURLConnection.HTTP_OK) {
            throw new Exception("文件读取失败");
        }
        // 读文件流
        DataInputStream in = new DataInputStream(urlCon.getInputStream());
        DataOutputStream out = new DataOutputStream(new FileOutputStream(imgPath));
        byte[] buffer = new byte[2048];
        int count = 0;
        while ((count = in.read(buffer)) > 0) {
            out.write(buffer, 0, count);
        }
        if(out!=null) {
            out.close();
        }
        if(in!=null) {
            in.close();
        }
    }
}
