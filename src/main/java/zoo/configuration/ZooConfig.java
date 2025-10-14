package zoo.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zoo.domain.animals.Animals;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ZooConfig {
    @Bean
    @Qualifier("storage")
    public List<Animals> storage() {
        return new ArrayList<>();
    }

    @Bean
    @Qualifier("contactList")
    public List<Animals> contactList() {
        return new ArrayList<>();
    }

}
