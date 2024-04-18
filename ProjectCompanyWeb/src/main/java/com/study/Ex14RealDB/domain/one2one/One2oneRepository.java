package com.study.Ex14RealDB.domain.one2one;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface One2oneRepository extends JpaRepository<One2one, Long> {
}
