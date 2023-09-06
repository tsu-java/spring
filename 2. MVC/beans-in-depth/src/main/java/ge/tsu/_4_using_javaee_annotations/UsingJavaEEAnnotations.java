package ge.tsu._4_using_javaee_annotations;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsingJavaEEAnnotations {

    public static void main(String[] args) {
        try (var context = SpringApplication.run(UsingJavaEEAnnotations.class, args)) {
            A a = context.getBean(A.class);
            B b = context.getBean(B.class);
            System.out.println(a);
            System.out.println(b);
        }
    }
}


@Named // @Component
@Singleton
class A {
}

@Named // @Component
@Singleton
class B {

    @Inject // @Autowired
    @Named("a") // @Qualifier
    private A a;
}
