package zoo.domain.animals;

import zoo.Service.GiveSpecialNumber;
import zoo.domain.IAlive;
import zoo.domain.IInventory;

public class Animals implements IAlive, IInventory {
    public String name;
    public String type;
    public int food;
    public int number;
    private GiveSpecialNumber generator = new GiveSpecialNumber();

    public Animals(String name, String type, int food){
        this.name = name;
        this.type = type;
        this.food = food;
        this.number = generator.GiveNum();
    }
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int foodD(){
        return food;
    }
}
