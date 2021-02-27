/**
 * @author Jadic
 * @created 2012-10-17 
 */
package com.jadic.tcp.cmd.req;

import org.jboss.netty.buffer.ChannelBuffer;

import com.jadic.tcp.cmd.TcpCmdHead;

/**
 * 请求数据命令
 */
public class CmdGetData_C2S extends TcpCmdHead {
	
	public CmdGetData_C2S() {
		super();
	}

	@Override
	public int getCmdSize() {
		return super.getCmdSize() + this.getCmdEndSize();
	}

	@Override
	public boolean disposeData(ChannelBuffer channelBuffer) {
		try {
			if (channelBuffer == null || channelBuffer.readableBytes() < this.getCmdSize())
				return false;
			
			if (super.disposeData(channelBuffer)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
