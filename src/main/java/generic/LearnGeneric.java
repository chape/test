package generic;

import java.util.Date;

public class LearnGeneric<T,C> {
	private T type;
	private C color;
	public T getType() {
		return type;
	}
	public void setType(T type) {
		this.type = type;
	}
	public C getColor() {
		return color;
	}
	public void setColor(C color) {
		this.color = color;
	}
	public static <B> B defineMethod(B bb){
		return bb;
	}
	@Override
	public String toString() {
		return "LearnGeneric [type=" + type + ", color=" + color + "]";
	}
	
	public static void main(String[] args) {

	}
	
	public static void errorAssigment(){
		String[] strs = new String[10];
		Object[] objs = strs;
		objs[0] = new Date();
	}
}
