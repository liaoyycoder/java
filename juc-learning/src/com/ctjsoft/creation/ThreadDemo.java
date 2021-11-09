package com.ctjsoft.creation;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 测试使用继承Thread方式创建线程
 *
 * @author: liaoyy
 * @date: Created in 2021/11/9 16:57
 */
public class ThreadDemo extends Thread {

    private String url;
    private String fileName;


    public ThreadDemo(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    /**
     * 继承Thread类，重写run方法
     */
    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, fileName);
        System.out.println("download--" + fileName);
    }



    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbpic.588ku.com%2Felement_origin_min_pic%2F16%2F08%2F19%2F1457b6a76c7756c.jpg&refer=http%3A%2F%2Fbpic.588ku.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637378576&t=a683b2c7915b69aba0fcfec7d9d2eaff", "1.jpg");
        ThreadDemo t2 = new ThreadDemo("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbpic.588ku.com%2Felement_origin_min_pic%2F16%2F07%2F13%2F165785fde37639b.jpg&refer=http%3A%2F%2Fbpic.588ku.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637378576&t=7d9b27747cb5509699df61233bcb9969", "2.jpg");
        ThreadDemo t3 = new ThreadDemo("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbpic.588ku.com%2Felement_origin_min_pic%2F16%2F07%2F06%2F17577cd55945262.jpg%21r650&refer=http%3A%2F%2Fbpic.588ku.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637378576&t=5db9eae9aa7e8b2997d48a81e1ba9bd8", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }

}

/**
 * 网络下载器
 */
class WebDownLoader{

    /**
     * 下载器
     * @param url 网络资源url
     * @param fileName 文件名称
     */
    public void downloader(String url, String fileName) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(fileName) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
