package zoo.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import zoo.domain.animals.Animals;

import java.util.List;


@Service
public class Information {
    private final List<Animals> animalsList;

    public Information(@Qualifier("storage")List<Animals> animalsList){
        this.animalsList = animalsList;
    }

    public int allFood(){
        int sum = 0;
        for (int i = 0; i < animalsList.size(); i++){
            sum += animalsList.get(i).foodD();
        }
        return sum;
    }
}
