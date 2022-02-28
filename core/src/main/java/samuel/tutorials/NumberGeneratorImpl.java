package samuel.tutorials;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import samuel.tutorials.annotations.MaxNumber;
import samuel.tutorials.annotations.MinNumber;

import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {
    //...Fields...
    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

    private final int maxNumber;
    private final int minNumber;


    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    //...Public Methods...
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }
}
