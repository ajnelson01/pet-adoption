package com.vmware.catapi.web;

import com.vmware.catapi.cat.CatDto;
import com.vmware.catapi.cat.CatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public List<CatDto> getCats() {
        return catService.getCats();
    }

    @GetMapping("/{id}")
    public CatDto getById(@PathVariable Long id) {
        return catService.getById(id);
    }
}