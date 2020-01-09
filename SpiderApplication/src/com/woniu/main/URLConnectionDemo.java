package com.woniu.main;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
public class URLConnectionDemo {
 
    public static void main(String[] args) throws Exception{
    	getDondow("http://data.vod.itc.cn/?new=/91/42/pZqBu6MSS6qxJ83Lg979vf.mp4&vid=103937904&plat=17&mkey=28Du2tAW15aS0ylqYSM8S_OnnptiDEii&ch=null&user=api&uid=1608272337357415&SOHUSVP=9NMHZMJtrG80umdJLLO8xVA1dkMGLpePyRSVe8uB8mY&pt=1&prod=56&pg=1&eye=0&cv=1.0.0&qd=68000&src=11050001&ca=4&cateCode=300&_c=1&appid=tv"
        		+ "","D:\\Spider\\Videos\\xx.mp4");
    	getDondow("https://zuidajiexi.net/m3u8.html?url=https://bili.meijuzuida.com/20190827/21322_0e6d7ca2/index.m3u8", 
    			"D:\\Spider\\Videos\\abc.mp4");
    }
    //下载视频方法
    private static void getDondow(String url,String pathName)throws Exception{
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
