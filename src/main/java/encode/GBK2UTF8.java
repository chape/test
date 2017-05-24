package encode;

import java.io.UnsupportedEncodingException;

public class GBK2UTF8 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		doubleTranslate();
	}
	
	public static void doubleTranslate() throws UnsupportedEncodingException {
	    String gbk = "业务参考号重复";
	    System.out.print("GBK格式下的bytes： ");
	    for (byte b : gbk.getBytes("GBK")) {
	        System.out.print(b+" ");
	    }
	    System.out.print("\nUTF-8格式下的bytes： ");
	    for (byte b : gbk.getBytes("UTF-8")) {
	    	System.out.print(b+" ");
	    }
	    System.out.print("\nUTF-8格式下的bytes： ");
	    String utf8 = new String(gbk.getBytes("UTF-8"),"UTF-8"); //转换为UTF-8
	    for (byte b : utf8.getBytes("UTF-8")) {
	        System.out.print(b+" ");
	    }
	    System.out.println();
	    System.out.println("gbk转为utf-8： "+utf8);
	    System.out.println("utf-8转为gbk： "+new String(utf8.getBytes("GBK"),"GBK"));
	}
}
