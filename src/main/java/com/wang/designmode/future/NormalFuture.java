package com.wang.designmode.future;

import java.util.concurrent.Callable;

import com.wang.designmode.utils.TaskSimulation;

/**
 * normal future class
 * @date 2020/9/23 18:18
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
public class NormalFuture<T> implements Callable {

	private static boolean FINISHED = false;

	@Override
	public T call() throws Exception {
		try {
			System.out.println("do work");
			TaskSimulation.executeTask(100);
		} finally {
			FINISHED = true;
		}
		return null;
	}

	public T get() {
		while (!FINISHED) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
