package patient;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "case")
    private String caseImg;

    @Column(name = "telephone")
    private int telephone;

    @Column(name = "mail", length = 50)
    private String mail;

    @Column(name = "id_number", nullable = false, length = 20)
    private String idNumber;

    @Column(name = "job", length = 20)
    private String job;

    @Column(name = "allergens", length = 255)
    private String allergens;

    @Column(name = "chronic_diseases", length = 255)
    private String chronicDiseases;

    @Column(name = "genetic_diseases", length = 255)
    private String geneticDiseases;

    public Patient() {
    }

    public Patient(String name, int age, String address, String caseImg, int telephone, String mail, String idNumber, String job, String allergens, String chronicDiseases, String geneticDiseases) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.caseImg = caseImg;
        this.telephone = telephone;
        this.mail = mail;
        this.idNumber = idNumber;
        this.job = job;
        this.allergens = allergens;
        this.chronicDiseases = chronicDiseases;
        this.geneticDiseases = geneticDiseases;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCaseImg() {
        return caseImg;
    }

    public void setCaseImg(String caseImg) {
        this.caseImg = caseImg;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }
}