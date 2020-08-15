package am.sam.controller;

import am.sam.dto.ResumeApplicationRoleDTO;
import am.sam.entity.Resume;
import am.sam.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @RequestMapping
    public List<ResumeApplicationRoleDTO> getAllResumes() {
        return resumeService.getAllResumes();
    }

    @RequestMapping("/{id}")
    public ResumeApplicationRoleDTO getResume(@PathVariable Long id) {
        return resumeService.getResume(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/applications/{applicationId}")
    public void addResume(@RequestParam MultipartFile resume, @PathVariable Long applicationId) {
        resumeService.addResume(resume, applicationId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/applications/{applicationId}")
    public void updateResume(@RequestBody Resume resume, @PathVariable Long id, @PathVariable Long applicationId) {
        resumeService.updateResume(resume, id, applicationId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
    }
}
