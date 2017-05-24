package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ParallelStream {

	public static List<String> values;
	
	private static void initList(){
		int max = 1000000;
		values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
	}
	
	public static void sequentialSort(){
		initList();
		
		long start = System.nanoTime();
		long sum = values.stream()
						.sorted()
						.count();
		System.out.println(sum);
		long end = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(end - start);
		System.out.println(String.format("sequential sort took %d ms", millis));
		
	}
	
	public static void parallelSort(){
		initList();
		
		long start = System.nanoTime();
		long sum = values.parallelStream()
				.sorted()
				.count();
		System.out.println(sum);
		long end = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(end - start);
		System.out.println(String.format("sequential sort took %d ms", millis));
		
	}
	
	public static void main(String[] args) {
		parallelSort();
	}
	
	@Test
	public void threadNum(){
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism());    // 3
		//-Djava.util.concurrent.ForkJoinPool.common.parallelism=5
	}
	
	@Test
	public void detailParallel(){
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
	    .parallelStream()
	    .filter(s -> {
	        System.out.format("filter: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return true;
	    })
	    .map(s -> {
	        System.out.format("map: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.format("forEach: %s [%s]\n",
	        s, Thread.currentThread().getName()));
	}

	@Test
	public void detailParallelSort(){
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
	    .parallelStream()
	    .filter(s -> {
	        System.out.format("filter: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return true;
	    })
	    .map(s -> {
	        System.out.format("map: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return s.toUpperCase();
	    })
	    .sorted((s1, s2) -> {
	        System.out.format("sort: %s <> %s [%s]\n",
	            s1, s2, Thread.currentThread().getName());
	        return s1.compareTo(s2);
	    })
	    .forEach(s -> System.out.format("forEach: %s [%s]\n",
	        s, Thread.currentThread().getName()));
		
		//is specified array less than the minimum granularity, Arrays.parallelSort() or Arrays.sort
	}
	
}
