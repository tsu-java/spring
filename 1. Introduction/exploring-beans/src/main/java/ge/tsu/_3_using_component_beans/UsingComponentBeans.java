package ge.tsu._3_using_component_beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class UsingComponentBeans {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(UsingComponentBeans.class, args)) {
            A a = context.getBean("Potato", A.class);
            B b = context.getBean(B.class);
            C c = context.getBean(C.class);

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }
    }
}

@Component("Potato") // Specifying name by hand
record A(B b) {
}


@Component
record B() {
}

@Component
record C(A a, B b) {
}