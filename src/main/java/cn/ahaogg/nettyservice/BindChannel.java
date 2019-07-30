package cn.ahaogg.nettyservice;

import io.netty.channel.ChannelHandlerContext;

public interface BindChannel {
	void add(String mSerialNum, ChannelHandlerContext ctx);
	void delete(ChannelHandlerContext ctx);
	void returnResult(String result);
}
