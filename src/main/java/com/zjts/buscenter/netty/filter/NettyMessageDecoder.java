package com.zjts.buscenter.netty.filter;

import com.zjts.buscenter.netty.util.ObjectSerializerUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.CharsetUtil;
import org.springframework.util.SerializationUtils;

import java.util.List;

/**
 * 解码，将字节数组转换为NettyMessage对象 ,无适用
 *
 */
public class NettyMessageDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

    }
}
