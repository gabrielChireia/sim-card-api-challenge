package challenge.hiring.verifone.sim.card.api.configuration;

import challenge.hiring.verifone.sim.card.api.domain.SimCard;
import challenge.hiring.verifone.sim.card.api.repositories.SimCardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LoadDatabaseSimCardValues {

    @Bean
    CommandLineRunner initDatabase(SimCardRepository simCardRepository) {
        return args -> {
            simCardRepository.save(new SimCard(123, 105987654, "active", LocalDate.of(2020, 5, 15), "registered", "verified", "Verifone", "John Doe"));
            simCardRepository.save(new SimCard(456, 105654321, "active", LocalDate.of(2021, 7, 13), "unregistered", "verified", "Verifone", "Jane Doe"));
            simCardRepository.save(new SimCard(789, 105321987, "inactive", LocalDate.of(2022, 9, 11), "registered", "verified", "Verifone", "Jack Doe"));
            simCardRepository.save(new SimCard(159, 105159357, "active", LocalDate.of(2022, 9, 1), "registered", "verified", "Verifone", "Jerry Doe"));
        };
    }
}
