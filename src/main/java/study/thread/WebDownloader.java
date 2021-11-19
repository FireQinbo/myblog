package study.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author qinb
 * @date 2021/9/9 14:49
 */
public class WebDownloader {
    public void downloader(String url, String name) {
        //下载网络文件
        try {
            //commons工具包
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("e = " + e);
        }
    }
}
