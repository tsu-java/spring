package ge.tsu._1_defining_and_using;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DefiningAndUsing {

    public static void main(String[] args) {
        // Sub-packages will also be scanned for bean definitions!
        try (var context = new AnnotationConfigApplicationContext("ge.tsu._1_defining_and_using")) {
            A a = context.getBean(A.class);            // Getting by type
            B b = (B) context.getBean("Bob");        // Getting by name
            C c = context.getBean("c", C.class);    // Getting by name and type

            System.out.println(a);
            System.out.println(b);
            System.out.println(c); // NOTE: Spring Boot has logging configured, but we'll see it later...

            System.out.println(); // Let's print all the available beans...
            for (String beanDefinitionName : context.getBeanDefinitionNames()) {
                System.out.println(context.getBean(beanDefinitionName));
            }
        }
    }

}
