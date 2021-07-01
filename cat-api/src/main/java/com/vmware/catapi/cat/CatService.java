package com.vmware.catapi.cat;

import com.vmware.catapi.cat.internal.CatEntity;
import com.vmware.catapi.cat.internal.CatRepository;
import com.vmware.catapi.cat.internal.NoSuchCatException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatService {
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<CatDto> getCats() {
        List<CatEntity> cats = catRepository.findAll();
        return cats.stream().map(catEntity -> CatDto.builder()
                .id(catEntity.getId())
                .name(catEntity.getName())
                .age(catEntity.getAge())
                .type(catEntity.getType())
                .imageUrl(catEntity.getImageUrl())
                .gender(catEntity.getGender().name())
                .build()).collect(Collectors.toList());
    }

    public CatDto getById(Long catId) {
        Optional<CatEntity> catEntityOptional = catRepository.findById(catId);
        if(catEntityOptional.isEmpty())
            throw new NoSuchCatException();

        CatEntity catEntity = catEntityOptional.get();
        return CatDto.builder()
                .id(catEntity.getId())
                .name(catEntity.getName())
                .age(catEntity.getAge())
                .type(catEntity.getType())
                .imageUrl(catEntity.getImageUrl())
                .gender(catEntity.getGender().name())
                .build();
    }
}
