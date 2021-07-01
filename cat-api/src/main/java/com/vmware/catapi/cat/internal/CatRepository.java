package com.vmware.catapi.cat.internal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<CatEntity, Long> {
}
