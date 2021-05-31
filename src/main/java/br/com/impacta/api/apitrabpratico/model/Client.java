package br.com.impacta.api.apitrabpratico.model;

import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends RepresentationModel<Client> {
    

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "birthdayDate")
	private LocalDate birthdayDate;

    public Client(int id, String name, LocalDate birthdayDate) {
        this.id = id;
        this.name = name;
        this.birthdayDate = birthdayDate;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
}
