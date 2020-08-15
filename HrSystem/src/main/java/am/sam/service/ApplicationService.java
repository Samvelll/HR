package am.sam.service;

import am.sam.dto.ApplicationResumeUserDTO;
import am.sam.entity.Application;
import am.sam.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;


    public List<ApplicationResumeUserDTO> getAllApplications() {
        List<ApplicationResumeUserDTO> applicationList = new ArrayList<>();
        applicationRepository.findAll().forEach(t -> applicationList.add(new ApplicationResumeUserDTO(t)));

        return applicationList;
    }

    public ApplicationResumeUserDTO getApplication(Long id) {
        try {
            return new ApplicationResumeUserDTO(applicationRepository.findById(id).get());
        }
        catch(NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addApplication(Application application) {
        applicationRepository.save(application);
    }

    public void updateApplication(Application application) {
        applicationRepository.save(application);
    }

    public void deleteApplication(Long id) {

        applicationRepository.deleteById(id);

    }

}
