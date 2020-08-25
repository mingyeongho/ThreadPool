package threadpoolEx01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// ExecutorService executor = Executors.newCachedThreadPool();
		// �ʱ� ������ �� = 0
		// �ּ��� �����ؾ� �� ������ �� = 0
		
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
		);
		// CPU �ھ� ���� ��ŭ �ִ� �����带 ����ϴ� ������Ǯ
		
		// ������Ǯ�� main()�� ������ ������� �ʴ´�. -> void shutdown()
		executorService.shutdown();
		// �����ִ� �۾��� �������ϰ� ������ ����
		
		
		/*
		 * executorService.shutdownNow()
		 * �����ִ� �۾��� ������� ������ ����
		 * 
		 */
	}

}
