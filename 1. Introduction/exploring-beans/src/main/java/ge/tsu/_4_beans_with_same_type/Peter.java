package ge.tsu._4_beans_with_same_type;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary // Specifies that if there are multiple beans with the same type, choose this one by default!
@Component
public class Peter implements IHuman {

    @Override
    public String getName() {
        return "პეტრე";
    }

    @Override
    public void eatFood(String foodName) {
        System.out.printf("საკმაოდ კარგი იყო %s-ს ჭამა\n", foodName);
    }
}
