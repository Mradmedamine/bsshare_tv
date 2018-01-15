package org.joker.tv.model.front.web.iks;

import java.io.Serializable;

public class Server implements Serializable {

	private static final long serialVersionUID = 7364370531378833508L;

	private String serverid;
	private String port;
	private String host;
	private String user;
	private String pass;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getServerid() {
		return serverid;
	}

	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
