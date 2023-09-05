package ge.tsu._4_beans_with_same_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class House {

    @Qualifier("lazarus") // Choose bean with name "lazarus" if multiple beans of same type are found!
    @Autowired
    private IHuman human;

    public void serveFoodToHuman(String foodName) {
        System.out.println("Serving food to human...");
        human.eatFood(foodName);
        System.out.println("Served food.");
    }
}
