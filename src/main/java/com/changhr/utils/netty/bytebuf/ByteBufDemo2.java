package com.changhr.utils.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 1.直接缓冲区
 * 访问直接缓冲区的数据
 *
 * @author changhr
 * @create 2019-09-23 14:25
 */
public class ByteBufDemo2 {

    public static void main(String[] args) {
        ByteBuf directBuf = Unpooled.buffer(1024);

        // 检查 ByteBuf 是否由数组支撑。如果不是，则这是一个直接缓冲区
        if (!directBuf.hasArray()) {

            // 获得可读字节数
            int length = directBuf.readableBytes();

            // 分配一个新的数组来保存具有该长度的字节数据
            byte[] array = new byte[length];

            // 将字节复制到该数组
            directBuf.getBytes(directBuf.readerIndex(), array);

            // 使用数组、偏移量、长度作为参数调用自己的方法
            handleArray(array, 0, length);
        }
    }

    private static void handleArray(byte[] array, int offset, int length) {
    }

}
