package threadPoolEx02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		/*
		 * 작업 생성
		 * 1. Runnable -> 리턴값이 없음
		 * 2. Callable -> 리턴값이 있음
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
		 * 작업 처리 요청
		 * ExecutorService 작업 큐에 Runnable or Callable 객체를 넣는 행위
		 * 1. execute(Runnable task)
		 * 2. submit(Runnable task)
		 * 3. 작업 처리 도중 예외가 발생하면 스레드가 종료되고 해당 스레드는 스레드풀에서 제거
		 */
		
		/*
		 * execute(Runnable task)
		 * 1. 작업 처리 결과를 받지 못함
		 * 2. Runnable 객체만 매개값으로 받을 수 있음
		 * 3. 작업 처리 도중 예외가 발생해도 스레드가 제거되지 않고 재사용됨
		 * -> submit 사용 권장
		 */
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);
					int value = Integer.parseInt("삼");
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
