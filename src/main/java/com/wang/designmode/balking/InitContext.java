package com.wang.designmode.balking;

/**
 * blaking design modo demo
 * @date 2020/9/24 9:57
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
public class InitContext {
	private static boolean INITIALIZED = false;

	public void init() {
		synchronized (this) {
			if (INITIALIZED) {
				return;
			}
			doInit();
			INITIALIZED = true;
		}
	}

	private void doInit() {
		//do something for init
	}
}
