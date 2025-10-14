package zoo.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import zoo.domain.animals.Animals;
import zoo.domain.animals.Herbo;

import java.util.List;

@Service
public class Contact {
    private List<Animals> contact;
    public Contact(@Qualifier("contactList") List<Animals> contact){
        this.contact = contact;
    }

    public void addContact(Animals animal){
        if (animal instanceof Herbo herbo && herbo.isTouchable()) {
            contact.add(herbo);
            System.out.println("Контактный зоопарк обновлен!");
        }
        else {
            System.out.println("Новых животных в зоопарке нет");
        }
    }

    public void showContact() {
        if (contact.isEmpty()) {
            System.out.println("В контактном зоопарке нет животных");
            return;
        }
        System.out.println("Животные в контактном зоопарке:");
        for (int i = 0; i < contact.size(); i++){
            System.out.println(contact.get(i).toString() + "\n");
        }
    }
}
