package com.changhr.utils.javacv;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author changhr
 * @create 2019-11-20 13:39
 */
public class MpegDemo {

    public static void main(String[] args) throws Exception {

        String filePath = "E:\\shareFolder\\MP4文件\\mp4video_mp3audio.mp4";
        File file = new File(filePath);
        FileInputStream in = new FileInputStream(file);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        byte[] data = out.toByteArray();
        ByteBuffer allocate = ByteBuffer.wrap(data);
        allocate.order(ByteOrder.BIG_ENDIAN);


        int firstSize = allocate.getInt();
        System.out.println(firstSize);
        allocate.position(firstSize);
        int totalSize = firstSize;
        int datSize = allocate.getInt();
        int mdat = 0x6D646174;
        while (allocate.getInt() == mdat) {
            totalSize += datSize;
            allocate.position(totalSize);
            datSize = allocate.getInt();
        }

        allocate.position(allocate.position() - 4);

        int moov = 0x6D6F6F76;
        System.out.println(allocate.getInt() == moov);

        allocate.getInt();

        int mvhd = 0x6D766864;
        System.out.println(allocate.getInt() == mvhd);

        allocate.getInt();

        int createTime = allocate.getInt();
        int updateTime = allocate.getInt();
        int timescale = allocate.getInt();
        int duration = allocate.getInt();

        System.out.println("timescale=" + timescale);
        System.out.println("src duration=" + duration);
        System.out.println("duration=" + (float) duration / timescale);
    }

}
