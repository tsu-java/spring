package ge.tsu._3_bean_lifecycle_methods;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BeanLifecycleMethods {

    public static void main(String[] args) {
        try (var context = SpringApplication.run(BeanLifecycleMethods.class, args)) {
            A a = context.getBean(A.class);
            System.out.println(a);
        }
    }
}

@Component
class A {

    @PostConstruct
    void init() {
        // This method is called when all the required dependencies of this bean are supplied
        // and object created successfully.
        System.out.println("Post construct called");
    }

    @PreDestroy
    void destroy() {
        // This method is called before bean gets destroyed (after context closes or bean goes out of scope)
        System.out.println("Pre destroy called");
    }
}