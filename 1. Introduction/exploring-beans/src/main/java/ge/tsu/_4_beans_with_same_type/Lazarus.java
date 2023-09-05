package ge.tsu._4_beans_with_same_type;

import org.springframework.stereotype.Component;

@Component
public class Lazarus implements IHuman {

    @Override
    public String getName() {
        return getClass().getSimpleName(); // Returns "Lazarus"
    }

    @Override
    public void eatFood(String foodName) {
        System.out.printf("I %s like eating %s very much\n", getName(), foodName);
    }
}
