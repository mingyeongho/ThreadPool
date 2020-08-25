package threadpoolEx01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// ExecutorService executor = Executors.newCachedThreadPool();
		// 초기 스레드 수 = 0
		// 최소한 유지해야 할 스레드 수 = 0
		
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
		);
		// CPU 코어 개수 만큼 최대 스레드를 사용하는 스레드풀
		
		// 스레드풀은 main()가 끝나도 종료되지 않는다. -> void shutdown()
		executorService.shutdown();
		// 남아있는 작업을 마무리하고 스레드 종료
		
		
		/*
		 * executorService.shutdownNow()
		 * 남아있는 작업과 상관없이 강제로 종료
		 * 
		 */
	}

}
