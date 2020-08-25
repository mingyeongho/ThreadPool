package threadPoolEx02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		/*
		 * �۾� ����
		 * 1. Runnable -> ���ϰ��� ����
		 * 2. Callable -> ���ϰ��� ����
		 */

		/*
		 * 1. Runnable task = new Runnable( {
		 * 		@Override
		 * 		public void run() {
		 * 
		 * 		}
		 *    });
		 */
		
		/*
		 * 2. Callable<T> task = new Callable<T>() {
		 * 		@Override
		 * 		public T call thros Exception {
		 * 
		 * 			return T;
		 * 		}
		 *    });
		 */
		
		/*
		 * �۾� ó�� ��û
		 * ExecutorService �۾� ť�� Runnable or Callable ��ü�� �ִ� ����
		 * 1. execute(Runnable task)
		 * 2. submit(Runnable task)
		 * 3. �۾� ó�� ���� ���ܰ� �߻��ϸ� �����尡 ����ǰ� �ش� ������� ������Ǯ���� ����
		 */
		
		/*
		 * execute(Runnable task)
		 * 1. �۾� ó�� ����� ���� ����
		 * 2. Runnable ��ü�� �Ű������� ���� �� ����
		 * 3. �۾� ó�� ���� ���ܰ� �߻��ص� �����尡 ���ŵ��� �ʰ� �����
		 * -> submit ��� ����
		 */
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[�� ������ ����: " + poolSize + "] �۾� ������ �̸�: " + threadName);
					int value = Integer.parseInt("��");
				}
			};
			
			executorService.submit(runnable);
			
			try {
				Thread.sleep(10);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		executorService.shutdown();
	}

}
