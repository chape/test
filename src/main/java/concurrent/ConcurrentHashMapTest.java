package concurrent;

import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapTest {
    private static final ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<Integer, String>();
    private static final ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
    
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            newFixedThreadPool.execute(new RandomTask(concurrentHashMap));
        }
        newFixedThreadPool.shutdown();
        // shutdowm()会立即返回，isTerminated()会判断ExecutorService当前状态是否为TERMINATED
        while(true){
            if(newFixedThreadPool.isTerminated()){
                for (Entry<Integer, String> element : concurrentHashMap.entrySet()) {
                    System.out.println("key: " + element.getKey() + " - value: " + element.getValue());
                }
                break;
            }
        }
    }
    static class RandomTask implements Runnable{

        private static final Random rnd = new Random();
        private ConcurrentHashMap<Integer, String> map;
        
        public RandomTask(ConcurrentHashMap<Integer, String> map) {
            super();
            this.map = map;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(rnd.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int nextInt = rnd.nextInt(8);
            map.putIfAbsent(nextInt, ""+nextInt);
        }
        
    }

}
