package zoo.domain.animals;

public class Herbo extends Animals {
    private int happiness;

    public Herbo(String name, String type, int food, int happiness){
        super(name, type, food);
        this.happiness = happiness;
    }
    public boolean isTouchable(){
        return this.happiness > 5;
    }

    @Override
    public String toString(){
        return String.format("Травоядное \n Имя: %s \n Тип: %s \n Кол-во поедамой еды: %d \n Порядковый номер: %d \n Уровень счастья: %d",
                super.name, super.type, super.food, super.number, this.happiness);
    }
}
