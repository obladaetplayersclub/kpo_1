package zoo.buildings;

import zoo.domain.animals.Animals;
import org.springframework.stereotype.Service;

@Service
public class Vetclinic {
    public boolean checkAnimal(Animals animal){
        return animal.foodD() > 0;
    }
}
