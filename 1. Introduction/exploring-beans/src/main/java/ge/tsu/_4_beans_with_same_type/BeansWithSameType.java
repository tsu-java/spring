package ge.tsu._4_beans_with_same_type;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeansWithSameType {

    public static void main(String[] args) {
        try (var context = SpringApplication.run(BeansWithSameType.class, args)) {
            House house = context.getBean(House.class);
            house.serveFoodToHuman("Banana");
            house.serveFoodToHuman("Potato");

            // We've used @Primary and @Qualifier annotations to resolve the ambiguity.
            // Use @Primary to specify DEFAULT bean to use when multiple beans of same type are present!
            // Use @Qualifier to specify BY_HAND the bean you want to use if multiple beans are present!

            // NOTE: It is better to use both annotations if possible.
            // For example, if you have some DEV class that works with a fake database and want it to be used
            // by default, then mark it as @Primary bean.
            // In the future, users may want to add their own PROD, or QA database beans and use them using
            // @Qualifier annotation.
        }
    }
}
