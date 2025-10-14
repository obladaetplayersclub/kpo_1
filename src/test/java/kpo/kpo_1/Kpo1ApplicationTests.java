package kpo.kpo_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import zoo.Service.Contact;
import zoo.Service.Information;
import zoo.buildings.Vetclinic;
import zoo.buildings.Zoo;
import zoo.domain.animals.Animals;
import zoo.domain.animals.Herbo;
import zoo.domain.animals.Predator;

import java.util.ArrayList;
import java.util.List;

class Kpo1ApplicationTests {
    private Vetclinic clinic;
    private List<Animals> storage;
    private List<Animals> contactList;

    @BeforeEach
    void setUp() {
        clinic = new Vetclinic();
        storage = new ArrayList<>();
        contactList = new ArrayList<>();
    }

    @Test
    @DisplayName("Пропуск в зоопарк")
    void clinic_accepts_whenFoodPositive() {
        assertTrue(clinic.checkAnimal(new Animals("A","t",1)));
        assertFalse(clinic.checkAnimal(new Animals("B","t",0)));
    }

    @Test
    @DisplayName("Пропуск в зоопарк, только тех, кто прошел ветклинику")
    void zoo_adds_only_accepted_animals() {
        Zoo zoo = new Zoo(clinic, storage);
        zoo.addAnimal(new Animals("Ok","t",2));
        zoo.addAnimal(new Animals("Bad","t",0));
        assertEquals(1, storage.size());
    }

    @Test
    @DisplayName("Точная сумма корма")
    void info_sums_food_correctly() {
        storage.add(new Animals("A","t",1));
        storage.add(new Animals("B","t",3));
        storage.add(new Animals("C","t",2));
        assertEquals(6, new Information(storage).allFood());
    }

    @Test
    @DisplayName("Допуск в контактный зоопарк только тех, у кого доброта больше 5")
    void contact_keeps_only_touchable_herbo() {
        Contact c = new Contact(contactList);
        c.addContact(new Herbo("H1","Herbo",1,7));
        c.addContact(new Herbo("H2","Herbo",1,5));
        c.addContact(new Animals("X","Pred",2));
        assertEquals(1, contactList.size());
        assertTrue(contactList.get(0) instanceof Herbo);
    }

    @Test
    @DisplayName("allFood() возвращает 0 для пустого зоопарка")
    void info_returnsZero_whenNoAnimals() {
        List<Animals> empty = new ArrayList<>();
        Information info = new Information(empty);
        assertEquals(0, info.allFood());
    }

    @Test
    @DisplayName("toString() травоядного содержит имя, тип и счастье")
    void herbo_toString_containsKeyFields() {
        Herbo h = new Herbo("Кролик", "Rabbit", 2, 9);
        String s = h.toString();
        assertTrue(s.contains("Кролик"));
        assertTrue(s.contains("Rabbit"));
        assertTrue(s.contains("9"));
    }

    @Test
    @DisplayName("toString() хищника содержит имя и тип")
    void predator_toString_containsKeyFields() {
        Predator p = new Predator("Волк", "Wolf", 5);
        String s = p.toString();
        assertTrue(s.contains("Волк"));
        assertTrue(s.contains("Wolf"));
        assertTrue(s.contains("5"));
    }

}
