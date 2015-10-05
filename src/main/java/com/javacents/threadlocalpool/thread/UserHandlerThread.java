package com.javacents.threadlocalpool.thread;

import com.javacents.threadlocalpool.userservice.UserContext;
import com.javacents.threadlocalpool.userservice.UserInfo;
import com.javacents.threadlocalpool.userservice.UserService;

public class UserHandlerThread implements Runnable {
	private UserService userService;
	private UserInfo userInfo;

	public UserHandlerThread(UserService userService, UserInfo userInfo) {
		this.userService = userService;
		this.userInfo = userInfo;
	}

	public void run() {
		Thread.currentThread().setName(userInfo.getUserName() + " thread");
		try {
			if (userInfo.getUserId() <= 10) {
				// we only set user info for the first 10 users, so other
				// threads
				// "should" have a null UserInfo. But they don't because threads
				// are
				// pooled and their ThreadLocal storage remains, unless
				// explicitly
				// removed
				UserContext.setUserInfo(userInfo);
			}
			userService.logUserInfo();
		} finally {
			// UserContext.removeUserInfo(); // play with this - if this removal
			// is
			// not done, other user
			// threads will see previous user info
			// and there's potential for memory leak
		}
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

}
