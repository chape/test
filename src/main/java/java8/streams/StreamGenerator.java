package java8.streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.function.Supplier;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamGenerator {

	@Test
	public void allKindsStream() throws IOException {
		List<String> myList = Arrays.asList("x2","a4","b3","a6","a5","a3");
		myList.stream()
				.filter(s -> s.startsWith("a"))
				.map(String :: toUpperCase)
				.sorted()
				.forEach(System.out :: print);
		
		Arrays.asList("x2","a4","b3","a6","a5","a3")
				.stream()
				.findFirst()
				.ifPresent(System.out :: print);
		
		Stream.of("a1","a3","a2")
				.findFirst()
				.ifPresent(System.out :: print);
		
		IntStream.range(1, 10)
					.forEach(System.out :: print);
		
		Arrays.stream(new int[]{1,2,3})
				.map(num -> num*2 + 1)
				.average()
				.ifPresent(System.out :: print);
		
		Stream.concat(Stream.of("1","2"), Stream.of("3","4","5")).count();
		
		Random seed = new Random();
		Supplier<Integer> random = seed::nextInt;
		//Returns an infinite sequential unordered stream
		Stream.generate(random).limit(10).forEach(System.out::println);
		
		seed.ints().limit(10).forEach(System.out::println);

		IntStream.generate(() -> (int) (System.nanoTime() % 100)).
		limit(10).forEach(System.out::println);
		
		BitSet.valueOf(new byte[]{1,2,3,4}).stream().count();
		
		String foostr = "DAFwaq";
		Pattern.compile("").splitAsStream(foostr)
		            .map(String::toLowerCase)
		            .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		
		/* 
		  iterate 跟 reduce 操作很像，接受一个种子值，和一个 UnaryOperator（例如 f）。
		  然后种子值成为 Stream 的第一个元素，f(seed) 为第二个，f(f(seed)) 第三个，以此类推。
		  Returns an infinite sequential unordered stream
		 */
		Stream.iterate(0, n -> n + 3).limit(10)
		        .forEach(x -> System.out.print(x + " "));
		
		//从 BufferedReader
		BufferedReader br = new BufferedReader(new FileReader("/Users/ChaoChao/Downloads/logtail.log"));
		br.lines().forEach(System.out::println);
		br.close();
		
		//从 jarFile
		JarFile jarFile = new JarFile("/Users/ChaoChao/Downloads/app.jar");
	            jarFile.stream()
	            .peek(file -> System.out.println("Files :- " + file))
	                .filter(file -> file.getName().contains("App.class"))
	                .findFirst();
	            jarFile.close();
		
		
	        
		Stream.of("a1","a2","a3")
				.map(e -> e.substring(1))
				.mapToInt(Integer :: parseInt)
				.max()
				.ifPresent(System.out :: println);
		
		IntStream.range(1, 10)
					.mapToObj(e -> "a" + e)
					.forEach(System.out :: print);
		
		Stream.of(1.0,2.0,3.0)
					.mapToInt(Double::intValue)
					.mapToObj(e -> "b" + e)
					.forEach(System.out :: print);
	}
	
	@Test
	public void orderByStream(){
		Stream.of("d2","a1","b2","c")
				.filter(e -> {
					System.out.println(e);
					return true;
				});
		
		Stream.of("d2","a1","b2","c")
		.filter(e -> {
			System.out.println("filter: " + e);
			return true;
		})
		.forEach(s -> System.out.println("forEach: " + s));
		
		Stream.of("d2","a1","b2","c")
		.map(e -> {
			System.out.println("map: " + e);
			return e.toUpperCase();
		})
		.anyMatch(e -> {
			System.out.println("anyMatch: " + e);
			return e.startsWith("A");
		});
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("A");
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
	}
	
	@Test
	public void reuseStream(){
		Stream<String> stream =
			    Stream.of("d2", "a2", "b1", "b3", "c")
			        .filter(s -> s.startsWith("a"));

			stream.anyMatch(s -> true);    // ok
			stream.noneMatch(s -> true);   // exception
			
		Supplier<Stream<String>> streamSupplier =
			    () -> Stream.of("d2", "a2", "b1", "b3", "c")
			            .filter(s -> s.startsWith("a"));

			streamSupplier.get().anyMatch(s -> true);   // ok
			streamSupplier.get().noneMatch(s -> true);  // ok
	}
	
	//目录下文件总大小
	public static void main(String[] args) throws IOException {
            long size = Files.walk(Paths.get("/Users/ChaoChao/Downloads"))
                    .peek(System.out::println)
                    .mapToLong(StreamGenerator::count)
                    .sum();
            System.out.println(size);
            
            String foostr = "DAFwaq";
            Map<String, Long> map = Pattern.compile("").splitAsStream(foostr)
                        .map(String::toLowerCase)
                        .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
            for (Entry<String, Long> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "," + entry.getValue());
            }
            
            JarFile jarFile = new JarFile("/Users/ChaoChao/Downloads/app.jar");
            jarFile.stream()
            .peek(file -> System.out.println("Files :- " + file))
            .filter(file -> file.getName().contains("App.class"))
            .findFirst();
            jarFile.close();
        }
	static long count(Path path) {
	    try {
	        return Files.size(path);
	    } catch (IOException | UncheckedIOException e) {
	        return 0;
	    }
	}
}
