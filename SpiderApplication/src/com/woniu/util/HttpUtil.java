package com.woniu.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by XieTiansheng on 2018/3/7.
 */

public class HttpUtil {
    private static OkHttpClient okHttpClient;
    private static int num = 0;
    static{
    	okHttpClient = new OkHttpClient.Builder()
    			.readTimeout(400, TimeUnit.SECONDS)
    			.connectTimeout(400, TimeUnit.SECONDS)
    			.build();
    }
    
    
    public static String get(String path){
    	//创建连接客户端
        Request request = new Request.Builder()
                .url(path)
                .build();
        //创建"调用" 对象
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();//执行
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (IOException e) {
        	System.out.println("链接格式有误:"+path);
        }
        return null;
    }
    
}