package com.vmware.dogapi.dog;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DogDto {
    private Long id;
    private String name;
    private Integer age;
    private String type;
    private String imageUrl;
    private String gender;
}
