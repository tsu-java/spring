package ge.tsu._2_injecting_beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// This annotation is a collection of following annotations:
// Configuration, EnableAutoConfiguration, ComponentScan
@SpringBootApplication
public class InjectingBeans {

    public static void main(String[] args) {
        // We are now using SpringApplication's ConfigurableApplicationContext which it creates and returns:
        try (ConfigurableApplicationContext context = SpringApplication.run(InjectingBeans.class, args)) {
            A a = context.getBean(A.class);
            B b = context.getBean(B.class);
            C c = context.getBean(C.class);

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }
    }

}
