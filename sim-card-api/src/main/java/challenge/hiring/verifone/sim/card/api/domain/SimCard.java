package challenge.hiring.verifone.sim.card.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class SimCard {

    private @Id
    @GeneratedValue Long id;
    private Integer sim_card_number;
    private Integer mobile_number;
    private String status;
    private @JsonFormat(pattern = "yyyy-MM-dd") LocalDate expiration_date;
    private String state_of_registration;
    private String kyc;
    private String telecom_provider;
    private String full_name;

    public SimCard() {
    }

    public SimCard(Integer sim_card_number, Integer mobile_number, String status, LocalDate expiration_date,
                   String state_of_registration, String kyc, String telecom_provider, String full_name) {
        this.sim_card_number = sim_card_number;
        this.mobile_number = mobile_number;
        this.status = status;
        this.expiration_date = expiration_date;
        this.state_of_registration = state_of_registration;
        this.kyc = kyc;
        this.telecom_provider = telecom_provider;
        this.full_name = full_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSim_card_number() {
        return sim_card_number;
    }

    public void setSim_card_number(Integer sim_card_number) {
        this.sim_card_number = sim_card_number;
    }

    public Integer getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(Integer mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getState_of_registration() {
        return state_of_registration;
    }

    public void setState_of_registration(String state_of_registration) {
        this.state_of_registration = state_of_registration;
    }

    public String getKyc() {
        return kyc;
    }

    public void setKyc(String kyc) {
        this.kyc = kyc;
    }

    public String getTelecom_provider() {
        return telecom_provider;
    }

    public void setTelecom_provider(String telecom_provider) {
        this.telecom_provider = telecom_provider;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
