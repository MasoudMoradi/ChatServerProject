package chatServer;

public class Member {
	private String userName;
	private String passWord;
	private String ip;
	private int port;

	
	
	
	
	public Member(String userName, String passWord, String ip, int port) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.ip = ip;
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	@Override
	public String toString() {
		return "Member [userName=" + userName + ", passWord=" + passWord
				+ ", ip=" + ip + ", port=" + port + "]";
	}

	public void setPort(int port) {
		this.port = port;
	}

}
