package org.example.studentmapping.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class IDClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
