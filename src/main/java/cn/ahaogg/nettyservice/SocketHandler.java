package cn.ahaogg.nettyservice;

import cn.ahaogg.utils.DataSourceUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SocketHandler extends ChannelInboundHandlerAdapter {
    private Boolean isFirst = true;
    private int keepAliveTime = 60;
    private BindChannel bindChannel;
    private ChannelHandlerContext mCtx;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("\nchannel active>>>>>>>  id = " + ctx.channel().id());
        mCtx = ctx;
        // 监测到设备连入则立马发送一条指令查询设备信息
        String sendContent = "0x48,0x1,0x0A";
        ByteBuf seneMsg = Unpooled.buffer(sendContent.length());
        seneMsg.writeBytes(sendContent.getBytes());
        ctx.writeAndFlush(seneMsg);
        ctx.flush();
        new CountdownThread().start();


    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        super.channelInactive(ctx);
        System.out.println("channel inactive>>>>>>>  id = " + ctx.channel().id());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        super.channelUnregistered(ctx);
        System.out.println("channel unregistered>>>>>>>  id = " + ctx.channel().id());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws SQLException {

        keepAliveTime = 60;
        ByteBuf message = (ByteBuf) msg;
        byte[] response = new byte[message.readableBytes()];
        message.readBytes(response);
        String str = new String(response);
        String info[] = str.split(",");   // 将数据进行分割存入到数组

        System.out.println("receive client( " + ctx.channel().id() + ") realtime data: " + new String(response));

        /*String sendContent = "hello client ,im server, this is u say:" + new String(response);
        ByteBuf seneMsg = Unpooled.buffer(sendContent.length());
        seneMsg.writeBytes(sendContent.getBytes());

        ctx.writeAndFlush(seneMsg);
        System.out.println("send info to client:" + sendContent);*/

        if (info[0].equals("0x48")) {  // 逆变器查询信息
            if (isFirst) {    // 服务器第一次收到设备信息则添加
                if (true) {
                    isFirst = false;
                    String mSerialNum = String.valueOf(Integer.valueOf(info[1].substring(2), 16).toString());
                    System.out.println("Bind! mSerialNum = " + mSerialNum);
                    bindChannel.add(mSerialNum, ctx);
                }
            }
        }

        if (info[0].equals("0x4F")) {  // 逆变器实时数据
            // 存入数据库
            Long sum = 0L;
            for (int i = 0; i < info.length - 2; i++) {
                long long1 = Long.parseLong(info[i].substring(2), 16);
                sum += long1;

            }

            List<Long> list = new ArrayList();
            String string = Long.toBinaryString(sum);
            String string2 = string.substring(string.length() - 8, string.length());
            long long1 = Long.parseLong(info[13].substring(2), 16);
            String string3 = Long.toBinaryString(long1);
            Date date2 = new Date();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str1 = format.format(date2);
            if (string2.equals(string3.substring(string3.length() - 8))) {
                for (String string4 : info) {
                    long long2 = Long.parseLong(string4.substring(2), 16);
                    list.add(long2);
                }
                QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
                String sql = "insert into realtime values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                runner.update(sql, null, list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7)
                        , list.get(8), list.get(9), BitUtils.judgeBit(list.get(10)), BitUtils.judgeBit(list.get(11)), BitUtils.judgeBit(list.get(12)), str1);
            }
        }

        if (info[0].equals("0x42")) { // 逆变器设置模块

            if (info[1].equals("0x0")) { // 逆变器查询设置参数
                String sendContent = new String(response);
                bindChannel.returnResult(sendContent);
            } else { // 写入设置到逆变器
                String sendContent = new String(response);
                ByteBuf seneMsg = Unpooled.buffer(sendContent.length());
                seneMsg.writeBytes(sendContent.getBytes());
                ctx.writeAndFlush(seneMsg);
            }


        }

        if (info[0].equals("0x52")) {
            String sendContent = new String(response);
            bindChannel.returnResult(sendContent);
        }


    }


    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        super.handlerRemoved(ctx);
        System.out.println("removed id:" + ctx.channel().id());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        super.channelReadComplete(ctx);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        System.out.println("exceptionCaught id:" + ctx.channel().id());
    }

    public void setAddChannelListener(BindChannel add) {
        bindChannel = add;
    }

    class CountdownThread extends Thread {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (keepAliveTime > 0) {
                try {
                    Thread.sleep(1000);
                    keepAliveTime--;
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            // 下面执行连接断开的操作
            System.out.println("此设备心跳停止,关闭连接");
            bindChannel.delete(mCtx);
            mCtx.close();
        }

    }

}
	
	
