package cn.ahaogg.nettyservice;

public class ChannelBean {
	String mSerialNum;
	String channelId;
	
	public ChannelBean(String mSerialNum, String channelId) {
		this.mSerialNum = mSerialNum;
		this.channelId = channelId;
	}
	
	public String getmSerialNum() {
		return mSerialNum;
	}
	public void setmSerialNum(String mSerialNum) {
		this.mSerialNum = mSerialNum;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
	
}
