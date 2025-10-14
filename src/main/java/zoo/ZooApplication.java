package zoo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import zoo.Service.Contact;
import zoo.Service.Information;
import zoo.buildings.Zoo;
import zoo.configuration.ZooConfig;
import zoo.domain.animals.Animals;
import zoo.domain.animals.inzoo.Monkey;
import zoo.domain.animals.inzoo.Rabbit;
import zoo.domain.animals.inzoo.Tiger;
import zoo.domain.animals.inzoo.Wolf;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
@Import(ZooConfig.class)
public class ZooApplication implements CommandLineRunner {

    private final Zoo zoo;
    private final Information info;
    private final Contact contact;
    private final zoo.Service.GiveSpecialNumber numGen;

    public ZooApplication(Zoo zoo, Information info, Contact contact, zoo.Service.GiveSpecialNumber numGen) {
        this.zoo = zoo;
        this.info = info;
        this.contact = contact;
        this.numGen = numGen;
    }

    public static void main(String[] args) {
        SpringApplication.run(ZooApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n=== Добро пожаловать в Московский зоопарк ===");
            System.out.println("1. Добавить животное");
            System.out.println("2. Показать всех животных");
            System.out.println("3. Общее количество корма");
            System.out.println("4. Показать всех зверюшек в контактном зоопарке");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    addAnimalFlow(in);
                    break;
                }
                case 2: {
                    zoo.getAnimals();
                    break;
                }
                case 3: {
                    System.out.println("Всего мяса требуется в день: " + info.allFood());
                    break;
                }
                case 4: {
                    contact.showContact();
                    break;
                }
                case 0: {
                    running = false;
                }
                default: {
                    System.out.println("Неверный пункт!");
                }
            }
        }
        System.out.println("Всего доброго!");
    }

    private void addAnimalFlow(Scanner in) {
        System.out.println("Травоядное (1) или хищник (2)?");
        int kind = checknumber(in);

        Animals animal;
        if (kind == 1) {
            System.out.println("Кролик (1) или Обезьяна (2)?");
            int ht = checknumber(in);

            System.out.print("Имя: ");
            String name = in.next();

            System.out.print("Кол-во кг еды: ");
            int food = checknumber(in);

            System.out.print("Доброта (0–10): ");
            int happiness = checknumber(in);

            animal = (ht == 1) ? new Rabbit(name, food, happiness)  : new Monkey(name, food, happiness);

        } else if (kind == 2) {
            System.out.println("Волк (1) или Тигр (2)?");
            int pt = checknumber(in);

            System.out.print("Имя: ");
            String name = in.next();

            System.out.print("Кол-во кг еды: ");
            int food = checknumber(in);
            animal = (pt == 1) ? new Wolf(name, food) : new Tiger(name, food);
        } else {
            System.out.println("Нужно выбрать 1 или 2!");
            return;
        }

        zoo.addAnimal(animal);
        contact.addContact(animal);
    }

    private int checknumber(Scanner in){
        while (true) {
            try {
                return in.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Ошибка ввода! Вы должны ввести число \n" + "Введите число: ");
                in.nextLine();
            }
        }
    }


}
