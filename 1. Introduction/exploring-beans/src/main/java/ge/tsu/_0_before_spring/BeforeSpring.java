package ge.tsu._0_before_spring;

public class BeforeSpring {

    public static void main(String[] args) {
        // Spring has DI (Dependency Injection) framework which helps us manage objects and their dependencies (fields)
        // automatically without our intervention. DI is also called IoC (Inversion of Control) because the control of
        // creating objects and managing them is delegated to somebody else (in our case - Spring DI/IoC Container).

        // Without Spring, we'll need to instantiate and assign fields by hand:
        A a = new A(); // Instantiating objects by hand...
        B b = new B();
        C c = new C();
        c.setA(a); // Assigning fields by hand
        c.setB(b);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        // NOTE: Not a big deal right? But, imaging you have 100 or 500 or even 1000 object to manage! It would be
        // nightmare if even a single change comes to one of those classes.
    }
}

class A {
}

class B {
}

class C {
    private A a;
    private B b;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "C{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
