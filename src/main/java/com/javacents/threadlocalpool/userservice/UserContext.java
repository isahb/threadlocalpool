package com.javacents.threadlocalpool.userservice;

/**
 * Wrapper for ThreadLocal
 */
public class UserContext {
	private static final ThreadLocal<UserInfo> userInfoThreadLocal = ThreadLocal.<UserInfo> withInitial(() -> {
		return null; //though null is default
	});

	public static void setUserInfo(UserInfo userInfo) {
		if (userInfo == null) {
			throw new IllegalArgumentException("userInfo arg cannot be null");
		}
		userInfoThreadLocal.set(userInfo);
	}

	public static UserInfo getUserInfo() {
		return userInfoThreadLocal.get();
	}

	public static void removeUserInfo() {
		userInfoThreadLocal.remove();
	}
}
