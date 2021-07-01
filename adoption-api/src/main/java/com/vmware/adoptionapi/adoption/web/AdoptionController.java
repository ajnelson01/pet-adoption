package com.vmware.adoptionapi.adoption.web;

import com.vmware.adoptionapi.adoption.AdoptionDto;
import com.vmware.adoptionapi.adoption.AdoptionRequest;
import com.vmware.adoptionapi.adoption.AdoptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adoption")
public class AdoptionController {
    private final AdoptionService adoptionService;

    public AdoptionController(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    @GetMapping
    public List<AdoptionDto> getAdoptions() {
        return adoptionService.getAdoptions();
    }

    @PostMapping
    public Long adopt(@RequestBody AdoptionRequest adoptionRequest) {
        return adoptionService.adopt(adoptionRequest);
    }
}
