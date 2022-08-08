package challenge.hiring.verifone.sim.card.api.controllers;

import challenge.hiring.verifone.sim.card.api.domain.SimCard;
import challenge.hiring.verifone.sim.card.api.services.SimCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimCardController {

    private final SimCardService simCardService;

    @Autowired
    public SimCardController(SimCardService simCardService) {
        this.simCardService = simCardService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getApiStatus() {
        return ResponseEntity.ok("Api Status: " + HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSimCard(@Validated @RequestBody SimCard simCard) {
        simCardService.add(simCard);
        return ResponseEntity.ok("SimCard added successfully");
    }

    @GetMapping("/listall")
    public ResponseEntity<?> listAllSimCards() {
        return ResponseEntity.ok(simCardService.listAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSimCard(@PathVariable Long id, @Validated @RequestBody SimCard simCard) {
        SimCard simCardToUpdate = simCardService.checkIfSimCardExist(id);
        if (simCardToUpdate == null) {
            return ResponseEntity.noContent().build();
        }
        simCardService.update(simCardToUpdate, simCard);
        return ResponseEntity.ok("SimCard updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSimCard(@PathVariable Long id) {
        SimCard simCardToDelete = simCardService.checkIfSimCardExist(id);
        if (simCardToDelete == null) {
            return ResponseEntity.notFound().build();
        }
        simCardService.delete(simCardToDelete);
        return ResponseEntity.ok("SimCard deleted successfully");
    }

    //SimCards which are expiring in next 30 days
    @GetMapping("/to-renew")
    public ResponseEntity<?> listSimCardsExpiringIn30Days() {
        return ResponseEntity.ok(simCardService.findAllExpiringInNext30Days());
    }

    @PostMapping("/renew/{id}")
    public ResponseEntity<?> renewSimCard(@PathVariable Long id) {
        SimCard simCardToRenew = simCardService.checkIfSimCardExist(id);
        if (simCardToRenew == null) {
            return ResponseEntity.notFound().build();
        }
        simCardService.addTelePackToSimCard(simCardToRenew);
        if (dummyNetworkProvider().getStatusCode().isError()) {
            return ResponseEntity.badRequest().body("Network provider verification failed");
        }
        return ResponseEntity.ok("SimCard renewed successfully");
    }

    @PostMapping("/dummy-network-provider")
    public ResponseEntity<?> dummyNetworkProvider() {
        return ResponseEntity.ok().build();
    }
}
