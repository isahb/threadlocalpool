package com.javacents.threadlocalpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.javacents.threadlocalpool.thread.UserHandlerThread;
import com.javacents.threadlocalpool.userservice.UserInfo;
import com.javacents.threadlocalpool.userservice.UserService;

public class App {
	public ExecutorService pool = Executors.newFixedThreadPool(10);

	public ExecutorService getPool() {
		return pool;
	}

	public static void main(String[] args) {
		App app = new App();
		UserService userService = new UserService();
		for (int i = 0; i < 20; i++) {
			UserInfo userInfo = new UserInfo((i + 1), "user" + (i + 1));
			UserHandlerThread reqHandler = new UserHandlerThread(userService, userInfo);
			app.getPool().submit(reqHandler);
		}
	}
}
