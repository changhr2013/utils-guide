package com.changhr.utils.netty.bytebuf;

import io.netty.buffer.*;
import io.netty.util.AsciiString;
import org.apache.commons.lang3.RandomUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author changhr
 * @create 2019-12-13 17:04
 */
public class BytesUtil {

    public static void main(String[] args) {
        byte[] sourceBytes = "youth is the reason of hope and energy.".getBytes(StandardCharsets.UTF_8);
        ByteBuf sourceByteBuf = Unpooled.wrappedBuffer(sourceBytes);

        System.out.println(ByteBufUtil.hexDump(sourceBytes));
        System.out.println(ByteBufUtil.hexDump(sourceByteBuf));

        StringBuilder prettyHex = new StringBuilder();
        ByteBufUtil.appendPrettyHexDump(prettyHex, sourceByteBuf);
        System.out.println(prettyHex);

        byte[] randomBytes = RandomUtils.nextBytes(16);
        AsciiString asciiString = new AsciiString(randomBytes);
        ByteBuf buffer = Unpooled.buffer();
        ByteBufUtil.copy(asciiString, buffer);
        System.out.println(asciiString);
        System.out.println(ByteBufUtil.hexDump(buffer));

        AsciiString str = AsciiString.of("hello world!");
        str.array();
        str.toByteArray();
    }

}
