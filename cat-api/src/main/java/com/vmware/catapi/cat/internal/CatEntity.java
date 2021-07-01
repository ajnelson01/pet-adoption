package com.vmware.catapi.cat.internal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity(name = "cat")
public class CatEntity {
    @Id
    private Long id;

    private String name;

    private Integer age;

    private String type;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
