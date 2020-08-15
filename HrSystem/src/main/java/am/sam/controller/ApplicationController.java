package am.sam.controller;

import am.sam.dto.ApplicationResumeUserDTO;
import am.sam.entity.Application;
import am.sam.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping
    public List<ApplicationResumeUserDTO> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @RequestMapping("/{id}")
    public ApplicationResumeUserDTO getApplication(@PathVariable Long id) {
        return applicationService.getApplication(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addApplication(@RequestBody Application application) {
        applicationService.addApplication(application);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateApplication(@RequestBody Application application, @PathVariable Long id) {
        applicationService.updateApplication(application);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
    }
}
