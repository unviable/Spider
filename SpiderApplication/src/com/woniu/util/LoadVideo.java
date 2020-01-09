package com.woniu.util;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadVideo {
	public static void getDondow(String url,String pathName)throws Exception{
        URL ul = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) ul.openConnection();
        BufferedInputStream bi = new BufferedInputStream(conn.getInputStream());
        FileOutputStream bs = new FileOutputStream(pathName);
        System.out.println("文件大约："+(conn.getContentLength()/1024)+"K");
        byte[] by = new byte[1024];
        int len = 0;
        while((len=bi.read(by))!=-1){
            bs.write(by,0,len);
        }
        bs.close();
        bi.close();
    }
}
