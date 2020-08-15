package am.sam.service;

import am.sam.dto.ResumeApplicationRoleDTO;
import am.sam.entity.Application;
import am.sam.entity.Resume;
import am.sam.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    public List<ResumeApplicationRoleDTO> getAllResumes() {
        List<ResumeApplicationRoleDTO> resumeList = new ArrayList<>();

        resumeRepository.findAll().forEach(t ->resumeList.add(new ResumeApplicationRoleDTO(t)));
        return resumeList;
    }

    public ResumeApplicationRoleDTO getResume(Long id) {
        try {
            return new ResumeApplicationRoleDTO(resumeRepository.findById(id).get());
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addResume(MultipartFile file, Long applicationId) {

        String fileName = file.getOriginalFilename();
        try {
            Resume resume = new Resume(fileName, file.getContentType(), file.getBytes());
            resume.setApplication(new Application(applicationId, ""));
            resumeRepository.save(resume);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateResume(Resume resume, Long id, Long applicationId) {
            resumeRepository.save(resume);
    }

    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }
}
