package java8.method;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import java8.entity.User;

public class MethodReference {

    public static void main(String[] args) {
        
        Supplier<User> su = User::new;
        User u0 = su.get();
        
        Function<String, User> fun = User::new;
        User u1 = fun.apply("xiaowang");
        
        BiFunction<String, Integer, User> bifun = User::new;
        User u2 = bifun.apply("xiaoming", 4);
        
        
    }
}
