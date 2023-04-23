package model;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDoc", nullable = false)
    private int idDoc;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "education_background", nullable = false, length = 50)
    private String educationBackground;

    @Column(name = "specialty", length = 255)
    private String specialty;

    @Column(name = "title", length = 255)
    private String title;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departement_id")
    private Departement departement;*/

    @Column(name = "resume", length = 255)
    private String resume;

    @Column(name = "reception_requirements", length = 255)
    private String receptionRequirements;

    @Column(name = "available_timings", length = 255)
    private String availableTimings;

    public Doctor() {

    }

    public Doctor(String name, int age, String educationBackground, String specialty, String title,
                  /*Departement departement, */String resume, String receptionRequirements, String availableTimings) {
        super();
        this.name = name;
        this.age = age;
        this.educationBackground = educationBackground;
        this.specialty = specialty;
        this.title = title;
        /*this.departement = departement;*/
        this.resume = resume;
        this.receptionRequirements = receptionRequirements;
        this.availableTimings = availableTimings;
    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
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

    public String getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(String educationBackground) {
        this.educationBackground = educationBackground;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*public Departement getDepartement() {
        return departement;
    }*/

    /*public void setDepartement(Departement departement) {
        this.departement = departement;
    }*/

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getReceptionRequirements() {
        return receptionRequirements;
    }

    public void setReceptionRequirements(String receptionRequirements) {
        this.receptionRequirements = receptionRequirements;
    }

    public String getAvailableTimings() {
        return availableTimings;
    }

    public void setAvailableTimings(String availableTimings) {
        this.availableTimings = availableTimings;
    }

}
