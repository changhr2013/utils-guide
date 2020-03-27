package com.changhr.utils.javacv;

//import org.bytedeco.javacv.FFmpegFrameGrabber;

import java.io.File;
import java.io.FilenameFilter;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author changhr
 * @create 2019-11-20 9:21
 */
public class SimpleDemo {

//    public static void main(String[] args) throws Exception {
//        String filePath = "E:\\BaiduNetdiskDownload\\Spring Security开发企业级认证与授权\\";
//        File dictionary = new File(filePath);
//        File[] files = dictionary.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp4"));
//
//        System.out.println("共计" + files.length + "个视频文件");
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < files.length; i++) {
//            System.out.println(getDurationOfVideo(files[i].getAbsolutePath()).getSeconds());
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("耗时：" + (end - start));
//    }
//
//    public static Duration getDurationOfVideo(String filePath) throws Exception {
//        FFmpegFrameGrabber grabber = FFmpegFrameGrabber.createDefault(filePath);
//        grabber.start();
//        long microSecond = grabber.getLengthInTime();
//        grabber.stop();
//        return Duration.of(microSecond, ChronoUnit.MICROS);
//    }
}
