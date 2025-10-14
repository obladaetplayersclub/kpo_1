package zoo.buildings;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import zoo.domain.animals.Animals;

import java.util.List;

@Component
public class Zoo {
    private Vetclinic vetclinic;
    private List<Animals> animalsList;
    public Zoo(Vetclinic vetclinic, @Qualifier("storage") List<Animals> animalsList){
        this.vetclinic = vetclinic;
        this.animalsList = animalsList;
    }

    public void addAnimal(Animals animal){
        if (vetclinic.checkAnimal(animal)){
            animalsList.add(animal);
            System.out.println("Животное находится в зоопарке, поздравляю!");
        } else {
            System.out.println("Животное не может находиться в зоопарке, извините!");
        }
    }

    public void getAnimals(){
        for (int i = 0; i < animalsList.size(); i++){
            System.out.println(animalsList.get(i).toString() + "\n");
        }
    }

}
