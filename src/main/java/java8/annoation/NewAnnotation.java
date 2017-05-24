package java8.annoation;

public class NewAnnotation {

	public static void main(String[] args) {
		Hint hint = School2.class.getAnnotation(Hint.class);
		System.out.println(hint);                   // null

		Hints hints1 = School2.class.getAnnotation(Hints.class);
		System.out.println(hints1.value().length);  // 2

		Hint[] hints2 = School2.class.getAnnotationsByType(Hint.class);
		System.out.println(hints2.length);          // 2
	}
}
