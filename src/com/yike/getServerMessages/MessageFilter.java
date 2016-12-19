package com.yike.getServerMessages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageFilter {
	
	public List<Content> GetChannels(){
		List<Content> contents = new ArrayList<Content>();
		LinuxCMD cmd = new LinuxCMD();
		List<String> msg;
		try {
			msg = cmd.runCommand(LinuxCMD.cmd_channels);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		//如果msg长度等于3则channel数量为0,否则数量为msg.size()-3
		if(msg.size()>3){
			for(String linemsg:msg.subList(1, msg.size()-3)){
				Content content = this.ParseCHLinemsg(linemsg);
				if(content!=null)
					contents.add(content);
//				System.out.println("//");
			}
		}else{
			return null;
		}
		return contents;
	}
	
	protected Content ParseCHLinemsg(String msg){
		Content content = null;
		String[] tmplist = msg.split(",", 13);
		
		if(tmplist[1].endsWith("outbound")&&tmplist[9].startsWith("robotAgent")){
			content = new Content
					(tmplist[4].substring(tmplist[4].lastIndexOf("/")+1),
					tmplist[1],
					tmplist[2],
					tmplist[7]+"@"+tmplist[8],
					tmplist[9],
					tmplist[10]);
		}
		
//		System.out.print(content.getRegname());
//		System.out.print(content.getDirection());
//		System.out.print(content.getActivebgtime());
//		System.out.print(content.getDest());
//		System.out.print(content.getApplication());
//		System.out.print(content.getApplicationdata());
		
		return content;
	}
}
