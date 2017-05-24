package concurrent;

import java.text.ParseException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinTest {

    public static void main(String[] args) throws ParseException {
        ForkJoinPool pool = new ForkJoinPool();
        int[] array = new int[10];
        Task firstTask = new Task(array, 0, array.length);
        pool.submit(firstTask);
        while (true) {
            if (!firstTask.isCompletedNormally()) {
                System.out.println("task done");
                break;
            }
        }
        
        pool.shutdown();
        
        while (true) {
            if(!pool.isTerminated()){
                System.out.println("task done & pool shutdown");
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                }
                break;
            }
        }
    }
}

class Task extends RecursiveAction {

    private static final long serialVersionUID = 1L;
    private int[] array;
    private int start;
    private int end;
    
    public Task(int[] array, int start, int end) {
        super();
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if(end - start > 5){
            int mid = (end + start)/2;
            Task leftTask = new Task(array, start, mid);
            Task rightTask = new Task(array, mid, end);
            invokeAll(leftTask,rightTask);
        }else{
            for (int i = start; i < end; i++) {
                array[i]++;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}