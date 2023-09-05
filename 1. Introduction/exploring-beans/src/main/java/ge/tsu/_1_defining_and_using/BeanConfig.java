package ge.tsu._1_defining_and_using;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * One may define Spring Beans as configuration class's methods.
 * This approach is good (1) if you want to describe beans from third-party classes,
 * or (2) if you want to describe similar beans in one place.
 * NOTE: Try to avoid this approach whenever possible. It is better to describe beans using @Component annotation
 */
@Configuration
public class BeanConfig {

    @Bean // By default, bean will have method name as its name
    public A a() {
        A a = new A();
        return a;
    }

    @Bean(name = "Bob") // Explicitly giving name
    public B b() {
        return new B();
    }

    @Bean
    public C c() {
        return new C();
    }
}

class A {
}

class B {
}

class C {
}
