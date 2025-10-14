package zoo.Service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GiveSpecialNumber {
    private Random random = new Random();
    public int GiveNum(){
        return generateNumber();
    }
    private int generateNumber(){
        return random.nextInt(10000);
    }
}
