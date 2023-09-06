package ge.tsu._1_bean_initialization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BeanInitialization {

    public static void main(String[] args) {
        try (var context = SpringApplication.run(BeanInitialization.class, args)) {
            System.out.println("START");
            A a = context.getBean(A.class); // A bean is already created
            B b = context.getBean(B.class); // B bean will be created when this call is made
            System.out.println("STOP");
        }
    }
}

@Component
class A {
    public A() {
        System.out.println("A object created");
    }
}

// Bean will be created by
@Component
@Lazy // or @Lazy(true)
class B {
    public B() {
        System.out.println("B object created");
    }
}
