package com.galvanize.startrek;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class OfficerService {

    OfficerRepository officerRepository;

    public OfficerService(OfficerRepository repository) {
        this.officerRepository = repository;
    }

    List<Officer> getAllOfficers () {
        return new ArrayList<>();
    }
}
