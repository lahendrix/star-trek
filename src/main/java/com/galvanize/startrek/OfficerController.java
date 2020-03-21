package com.galvanize.startrek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/officers")
class OfficerController {
    OfficerService officerService;

    @Autowired
    public OfficerController (OfficerService officerService) {
      this.officerService = officerService;
    }

    @GetMapping
    ResponseEntity<List<Officer>> getAllOfficers() {
        return ResponseEntity.ok(officerService.getAllOfficers());
    }

    @PostMapping
    ResponseEntity<Officer> createOfficer(Officer officer) {
        return ResponseEntity.ok(officerService.createOfficer(officer));
    }
}
