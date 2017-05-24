package sevenConcurrency;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

public class Downloader extends Thread{

	private InputStream in;
	private OutputStream out;
	private ArrayList<ProgressListener> listeners;
	
	public Downloader(URL url, String outputFilename) throws IOException{
		in = url.openStream();
		out = new FileOutputStream(outputFilename);
		listeners = new ArrayList<>();
	}
	
	public synchronized void addListener(ProgressListener listener){
		listeners.add(listener);
	}
	public synchronized void removeListener(ProgressListener listener){
		listeners.remove(listener);
	}
	/**
	 * 这里隐藏了一个死锁陷阱
	 * 对onProgress细节不知，如果此方法持有另外一把锁,加锁顺序不可知，可能发生死锁
	 * @param n
	 */
	public synchronized void updateProgress(int n){
		for (ProgressListener progressListener : listeners) {
			progressListener.onProgress(n);
		}
	}
	/**
	 * 保护性复制 避免死锁
	 * @param n
	 */
	public void updateSafeProgress(int n){
		ArrayList<ProgressListener> listenersCopy;
		synchronized(this){
			listenersCopy = (ArrayList<ProgressListener>) listeners.clone();
		}
		for (ProgressListener progressListener : listenersCopy) {
			progressListener.onProgress(n);
		}
	}
	
	@Override
	public void run() {
		int n=0, total=0;
		byte[] buffer = new byte[1024];
		
		try{
			while((n = in.read(buffer)) != -1){
				out.write(buffer, 0, n);
				total += n;
				updateProgress(total);
			}
			out.flush();
		}catch(Exception e){
			
		}
	}
}
