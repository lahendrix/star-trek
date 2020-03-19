package com.galvanize.startrek;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OfficerRepository extends JpaRepository<Officer, Long> {
}
