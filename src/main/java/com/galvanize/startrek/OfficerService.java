package com.galvanize.startrek;

import org.springframework.stereotype.Service;

@Service
class OfficerService {

    OfficerRepository officerRepository;

    public OfficerService(OfficerRepository repository) {
        this.officerRepository = repository;
    }
}
