package concurrent;

public class ThreadExceptionTest3 {

    public static class MyThreadGroup extends ThreadGroup{

        public MyThreadGroup(String name) {
            super(name);
        }
        
        public void uncaughtException(Thread thread, Throwable throwable){
            System.out.println("thread " + thread.getName() + " died, exception was: ");
            throwable.printStackTrace();
        }
    }
    public static ThreadGroup workerThreads = new MyThreadGroup("Worker Threads");
    
    public static class WorkerThread extends Thread{
        public WorkerThread(String name){
            super(workerThreads, name);
        }
        public void run(){
            throw new RuntimeException();
        }
    }
    
    public static void main(String[] args) {
        WorkerThread thread = new WorkerThread("WorkerThread");
        thread.start();
    }
}