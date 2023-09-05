package ge.tsu._2_injecting_beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class BeanConfig {

    @Bean
    @Description("Dummy bean A") // Adds a textual description to bean definitions (@Component or @Bean).
    public A a() {
        // Specifying bean using method call.
        // This is only required if we have constructor-injection and beans are described as methods.
        A a = new A(b());
        return a;
    }

    @Bean
    public B b() {
        return new B();
    }

    @Bean
    public C c() {
        return new C();
    }

    @Bean
    public D d() {
        return new D();
    }
}

class A {
    public B b;

    //    @Autowired // This annotation is not required when using 'constructor-injection'
    public A(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}

class B {
    public C c;

    @Autowired // setter-injection
    public void setC(C c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "B{" +
                "c=" + c +
                '}';
    }
}

class C {

    @Autowired // field-injection (uses reflection and is slow)
    public D d;

    @Override
    public String toString() {
        return "C{" +
                "d=" + d +
                '}';
    }
}

class D {
}

/**
 * NOTE: The dependencies of some beans in the application context must not form cycle!
 */
