package com.vmware.dogapi.dog.internal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity(name = "dog")
public class DogEntity {
    @Id
    private Long id;

    private String name;

    private Integer age;

    private String type;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
