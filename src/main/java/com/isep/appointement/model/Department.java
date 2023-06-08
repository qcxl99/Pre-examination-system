package com.isep.appointement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Doctor> doctors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Set<Hospital> hospital;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
