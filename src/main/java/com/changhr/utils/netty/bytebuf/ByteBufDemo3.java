package com.changhr.utils.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;

/**
 * 1.复合缓冲区
 *
 * @author changhr
 * @create 2019-09-23 14:25
 */
public class ByteBufDemo3 {

    public static void main(String[] args) {

    }

    /**
     * 使用 ByteBuffer 的复合缓冲区模式
     * @param header    消息头
     * @param body      消息体
     */
    public static void byteBufferComposite(ByteBuffer header, ByteBuffer body) {
        // 使用一个数组去持有消息各部分
        ByteBuffer[] message = new ByteBuffer[] {header, body};

        // 创建一个新的 ByteBuffer 并且使用 copy 去合并 header 和 body
        ByteBuffer message2 = ByteBuffer.allocate(header.remaining() + body.remaining());
        message2.put(header);
        message2.put(body);
        message2.flip();
    }

    /**
     * 使用 CompositeByteBuf 的复合缓冲区模式
     */
    public static void byteBufComposite() {
        CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        ByteBuf headerBuf = Unpooled.buffer(1024);
        ByteBuf bodyBuf = Unpooled.buffer(1024);

        // 将 ByteBuf 实例追加到 CompositeByteBuf
        messageBuf.addComponents(headerBuf, bodyBuf);
        // ...
        // 删除位于索引位置为 0（第一个组件）的 ByteBuf
        messageBuf.removeComponent(0);
        // 循环遍历所有的 ByteBuf 实例
        for (ByteBuf byteBuf : messageBuf) {
            System.out.println(byteBuf.toString());
        }
    }

    /**
     * 访问 CompositeByteBuf 中的数据
     */
    public static void byteBufCompositeArray() {
        CompositeByteBuf comBuf = Unpooled.compositeBuffer();
        // 获得可读字节数
        int length = comBuf.readableBytes();
        // 分配一个具有可读字节数长度的新数组
        byte[] array = new byte[length];
        // 将字节读到该数组中
        comBuf.getBytes(comBuf.readerIndex(), array);
        // 使用偏移量和长度作为参数使用该数组
        handleArray(array, 0, array.length);
    }

    private static void handleArray(byte[] array, int offset, int length) {
    }

}
