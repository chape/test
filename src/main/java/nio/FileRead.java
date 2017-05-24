package nio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileRead {

	private static final String FILE_PATH = "/Users/ChaoChao/Documents/397hotfix.txt";
	
	public static void readByIO(){
		InputStream is = null;
		try {
			is = new BufferedInputStream(new FileInputStream(FILE_PATH));
			byte[] buffer = new byte[1024];
			int readByte = is.read(buffer);
			while(readByte != -1){
				for (int i = 0; i < readByte; i++) {
					System.out.print((char)buffer[i]);
				}
				readByte = is.read(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(null != is){
					is.close();
				} 
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void readByNIO(){
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile(FILE_PATH, "rw");
			FileChannel fchannel = file.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024); 
			int bytesRead = fchannel.read(buffer);
			System.out.println("bytesRead:" + bytesRead);
			fchannel.read(buffer); 
			buffer.flip();  
	        byte[] byt=new byte[buffer.limit()];
	        Charset cs = Charset.forName ("UTF-8");
	        buffer.get(byt);
	        String news = new String(byt, cs);
	        System.out.println(news); 
//			while(-1 != bytesRead){
//				buffer.flip();
//				while(buffer.hasRemaining()){
//					System.out.print((char)buffer.get());
//				}
//				buffer.compact();
//				bytesRead = fchannel.read(buffer);
//			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(null != file){
					file.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		readByNIO();
	}
}
