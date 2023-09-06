package ge.tsu._2_bean_scopes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BeanScopes {

    // We'll discuss only Singleton and Prototype scopes for now...
    // Commonly used bean scopes: singleton, prototype, request, session, application, websocket.
    public static void main(String[] args) {
        try (var context = SpringApplication.run(BeanScopes.class, args)) {
            A a = context.getBean(A.class);
            A a2 = context.getBean(A.class);
            A a3 = context.getBean(A.class);

            B b = context.getBean(B.class); // Each call created new instance of bean B
            B b2 = context.getBean(B.class);

            // Only one instance of A object will be created, but 2 instances of B.
            // NOTE: In most cases singleton scope is sufficient, but it depends on the problem and on what
            // you're planning to build.
        }
    }
}

//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // Default scope
@Component
class A {
    public A() {
        System.out.println("A object created");
    }
}

//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope("prototype") // Each request to bean object creates a new one
@Component
class B {
    public B() {
        System.out.println("B object created");
    }
}


