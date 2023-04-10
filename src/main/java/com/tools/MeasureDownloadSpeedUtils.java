package com.tools;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Date 2023/4/10
 *
 * 测网速的小工具
 *
 */
public class MeasureDownloadSpeedUtils {

    private static final int DEFAULT_TIMEOUT = 3000; // 默认超时时间为3秒

    public static double measureDownloadSpeedConcurrently(String urlStr, int numThreads) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(DEFAULT_TIMEOUT);
            connection.setReadTimeout(DEFAULT_TIMEOUT);
            connection.connect();
            long fileSize = connection.getContentLengthLong();
            ExecutorService executor = Executors.newFixedThreadPool(numThreads);
            long startTime = System.nanoTime();
            for (int i = 0; i < numThreads; i++) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream in = connection.getInputStream();
                            byte[] buffer = new byte[1024 * 1024]; // 1MB的缓冲区
                            int len;
                            while ((len = in.read(buffer)) > 0) {
                                // 读取数据并丢弃
                            }
                            in.close();
                        } catch (Exception e) {
                            //e.printStackTrace();
                        }
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES); // 等待所有线程执行完毕
            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1e9;
            double speed = fileSize / duration / 1024 / 1024 / numThreads; // 计算下载速度，单位为MB/s
            connection.disconnect();
            return speed;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        String urlStr = "https://www.baidu.com";
        int numThreads = 10;
        double sumSpeed = 0;
        for (int i = 0; i < 10; i++) {
            double speed = measureDownloadSpeedConcurrently(urlStr, numThreads);
            if (speed > 0) {
                sumSpeed += speed;
            }
        }
        double avgSpeed = sumSpeed / 10;
        System.out.printf("Average download speed: %.2f MB/s\n", avgSpeed);
    }
}
