package com.changhr.utils.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * 1.堆缓冲区
 * 支撑数组
 *
 * @author changhr
 * @create 2019-09-23 14:25
 */
public class ByteBufDemo1 {

    public static void main(String[] args) {
        ByteBuf heapBuf = Unpooled.buffer(1024);

        // 检查 ByteBuf 是否有一个支撑数组
        if (heapBuf.hasArray()) {
            // 如果有，则获取对该数组的引用
            byte[] array = heapBuf.array();
            // 计算第一个字节的偏移量
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();
            // 获得可读字节数
            int length = heapBuf.readableBytes();
            // 使用数组、偏移量、长度作为参数调用自己的方法
            handleArray(array, offset, length);
        }
    }

    private static void handleArray(byte[] array, int offset, int length) {
    }

}
