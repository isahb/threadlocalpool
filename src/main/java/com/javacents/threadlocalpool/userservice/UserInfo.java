package com.javacents.threadlocalpool.userservice;

public class UserInfo {
	private int userId;
	private String userName;

	public UserInfo(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + "]";
	}

	public int getUserId() {
		return this.userId;
	}

	public String getUserName() {
		return userName;
	}

}
