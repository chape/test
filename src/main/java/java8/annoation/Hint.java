package java8.annoation;

import java.lang.annotation.Repeatable;

@Repeatable(Hints.class)
public @interface Hint {
	String value();
}
