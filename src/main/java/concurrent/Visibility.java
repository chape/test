package concurrent;
/**
 * 如果asleep没有volatile修饰
 * 因为asleep在循环中没改变，在server模式的jvm中会被优化，asleep的判断条件提升到循环体外部，将造成无限循环。
 * client模式则不会 
 *
 *注：
 * 前期编译器:将.java编译成.class，常见的如javac
 * JIT编译器(just in time compiler)：将.class字节码转化为机器码，如hotspot的C1,C2
 * AOT编译器(Ahead Of Time Compiler)：将.java文件直接转化为机器码的过程
 */
public class Visibility {  
    
    volatile boolean asleep = false;  
    public void run1()  
    {  
        int i=0;  
        while (!asleep)  
            i++;  
        System.out.println(i);  
        System.out.println("end");  
    }  
    public static void main(String[] args) {  
          
        final Visibility a = new Visibility();  
          
        new Thread(){  
            public void run() {  
                try {  
                    Thread.sleep(100);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                a.asleep = true;  
            };  
        }.start();  
        a.run1();  
    }  
}  