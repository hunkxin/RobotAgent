package com.yike.getServerMessages;

public class Content {
	private String regname;
	private String direction;
	private String activebgtime;
	private String caller;
	private String dest;
	private String application;
	
	public Content(String regname, String direction, String activebgtime,
			String caller, String dest, String application) {
		super();
		this.regname = regname;
		this.direction = direction;
		this.activebgtime = activebgtime;
		this.caller = caller;
		this.dest = dest;
		this.application = application;
	}
	
	public String getRegname() {
		return regname;
	}
	public void setRegname(String regname) {
		this.regname = regname;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getActivebgtime() {
		return activebgtime;
	}
	public void setActivebgtime(String activebgtime) {
		this.activebgtime = activebgtime;
	}
	public String getCaller() {
		return caller;
	}
	public void setCaller(String caller) {
		this.caller = caller;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
}
