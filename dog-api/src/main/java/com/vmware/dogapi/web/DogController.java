package com.vmware.dogapi.web;

import com.vmware.dogapi.dog.DogDto;
import com.vmware.dogapi.dog.DogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dogs")
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public List<DogDto> getDogs() {
        return dogService.getDogs();
    }

    @GetMapping("/{id}")
    public DogDto getById(@PathVariable Long id) {
        return dogService.getById(id);
    }
}
