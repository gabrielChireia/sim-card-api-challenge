package challenge.hiring.verifone.sim.card.api.services;

import challenge.hiring.verifone.sim.card.api.domain.SimCard;
import challenge.hiring.verifone.sim.card.api.repositories.SimCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimCardService {

    private final SimCardRepository simCardRepository;

    @Autowired
    public SimCardService(SimCardRepository simCardRepository) {
        this.simCardRepository = simCardRepository;
    }

    public void add(SimCard simCardToSave) {
        simCardRepository.save(simCardToSave);
    }

    public List<SimCard> listAll() {
        return simCardRepository.findAll();
    }

    public void update(SimCard simCardToUpdate, SimCard newSimCard) {
        simCardToUpdate.setSim_card_number(newSimCard.getSim_card_number());
        simCardToUpdate.setMobile_number(newSimCard.getMobile_number());
        simCardToUpdate.setStatus(newSimCard.getStatus());
        simCardToUpdate.setExpiration_date(newSimCard.getExpiration_date());
        simCardToUpdate.setState_of_registration(newSimCard.getState_of_registration());
        simCardToUpdate.setKyc(newSimCard.getKyc());
        simCardToUpdate.setTelecom_provider(newSimCard.getTelecom_provider());
        simCardToUpdate.setFull_name(newSimCard.getFull_name());
        simCardRepository.save(simCardToUpdate);
    }

    public void delete(SimCard simCardToDelete) {
        simCardRepository.delete(simCardToDelete);
    }

    public SimCard checkIfSimCardExist(Long id) {
        return simCardRepository.findById(id).orElse(null);
    }

    public List<SimCard> findAllExpiringInNext30Days() {
        return simCardRepository.findAll().stream()
                .filter(simCard -> simCard.getExpiration_date().isAfter(LocalDate.now().plusDays(30)))
                .collect(Collectors.toList());
    }

    public void addTelePackToSimCard(SimCard simCardToRenew) {
        simCardToRenew.setExpiration_date(LocalDate.now().plusDays(30));
        simCardRepository.save(simCardToRenew);
    }
}
