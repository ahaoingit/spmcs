package cn.ahaogg.nettyservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import cn.ahaogg.web.interface1.NettyCommunicate;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author INWISH
 */
public class NettyServer implements BindChannel, NettyCommunicate{
	//public List<ChannelBean> channelList = new ArrayList<ChannelBean>();
	public HashMap<String, ChannelHandlerContext> channelMap = new HashMap<>();
	private static final String ip = "172.17.42.162";
    private static final int port = 8888;
    private static final EventLoopGroup bossGroup = new NioEventLoopGroup();
    private static final EventLoopGroup workerGroup = new NioEventLoopGroup();
	public NettyServer nettyServer = this;
	
	private String result = "null";
    
    public void start() throws Exception {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<Channel>() {
                    protected void initChannel(Channel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        SocketHandler socketHandler = new SocketHandler();
                        socketHandler.setAddChannelListener(nettyServer);
                        pipeline.addLast(socketHandler);                     
                    }
                });
        
        ChannelFuture channelFuture = serverBootstrap.bind(ip, port).sync();
        channelFuture.channel().closeFuture().sync();
        System.out.println("server start");
        
    }

    protected static void shutdown() {
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }

    @Override
	 public void add(String mSerialNum, ChannelHandlerContext ctx) {
		//channelList.add(new ChannelBean(mSerialNum, channelId));
		channelMap.put(mSerialNum, ctx);
		System.out.println("mSerialNum= " + mSerialNum + "\tchannelId= " + channelMap.get(mSerialNum).channel().id().toString() + "\n");
		
	}

	@Override
	public void delete(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		/*for(ChannelBean channel : channelList) {
			if(channel.getChannelId().equals(channelId)) {
				channelList.remove(channel);
				break;
			}
		}*/
		Collection<ChannelHandlerContext> values = channelMap.values();
		values.remove(ctx);
	
		
	}
	
	@Override
	public void returnResult(String result) {
		// TODO Auto-generated method stub		
		this.result = result;
	}

	@Override
	public String sendMsg(String mSerialNum, String msg) { 
		// TODO Auto-generated method stub
		ChannelHandlerContext ctx = channelMap.get(mSerialNum);
		String sendContent = msg;
        ByteBuf seneMsg = Unpooled.buffer(sendContent.length());
        seneMsg.writeBytes(sendContent.getBytes());
        ctx.writeAndFlush(seneMsg);
        while(true) {
        	if(!result.equals("null")) {
        		break;
        	}
        		
        }
		return result;
	}

	
    
    
  
       
}

