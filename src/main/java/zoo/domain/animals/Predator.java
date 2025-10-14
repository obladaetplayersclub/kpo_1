package zoo.domain.animals;

public class Predator extends Animals {
    public Predator(String name, String type, int food){
        super(name, type, food);
    }

    @Override
    public String toString(){
        return String.format("Хищник \n Имя: %s \n Тип: %s \n Кол-во поедамой еды: %d \n Порядковый номер: %d",
                super.name, super.type, super.food, super.number);
    }
}
