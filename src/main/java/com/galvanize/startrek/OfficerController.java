package com.galvanize.startrek;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/officers")
class OfficerController {
    OfficerService officerService;

    public OfficerController (OfficerService officerService) {
      this.officerService = officerService;
    }

    @GetMapping
    List<Officer> getAllOfficers() {
        return officerService.getAllOfficers();
    }
}
