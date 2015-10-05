package com.javacents.threadlocalpool.userservice;

public class UserService {
	public void logUserInfo() {
		// this method gets UserInfo from threadlocal stored in UserContext
		UserInfo userInfo = UserContext.getUserInfo();
		System.out.println(Thread.currentThread() + " logging user info " + userInfo);
	}
}
