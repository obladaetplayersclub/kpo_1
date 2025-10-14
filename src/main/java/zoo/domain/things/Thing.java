package zoo.domain.things;

import zoo.Service.GiveSpecialNumber;
import zoo.domain.IInventory;

public class Thing implements IInventory {
    private int num;
    private GiveSpecialNumber generator = new GiveSpecialNumber();
    private String name;

    public Thing(String name){
        this.name = name;
        this.num = generator.GiveNum();
    }

    @Override
    public int getNumber(){
        return num;
    }
}
