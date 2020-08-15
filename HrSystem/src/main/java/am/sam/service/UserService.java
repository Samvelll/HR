package am.sam.service;

import am.sam.dto.UserRoleApplicationDTO;
import am.sam.entity.Application;
import am.sam.entity.Role;
import am.sam.entity.User;
import am.sam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    public List<UserRoleApplicationDTO> getAllUsers() {
        List<UserRoleApplicationDTO> userList = new ArrayList<>();
        userRepository.findAll().forEach(t -> userList.add(new UserRoleApplicationDTO(t)));
        return userList;
    }

    public UserRoleApplicationDTO getUser(Long id) {
        try {
            return new UserRoleApplicationDTO(userRepository.findById(id).get());
        }
        catch(NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User user, Long roleId) {
        user.setRole(new Role(roleId, ""));
        String s = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(s));
        userRepository.save(user);
    }

    public void addApplicationToUser(Long id, Long applicationId) {
        try {
            User user = userRepository.findById(id).get();
            user.addApplication(new Application(applicationId, ""));
            userRepository.save(user);
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user, Long id, Long roleId) {
        String s = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(s));
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
