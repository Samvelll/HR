package am.sam.controller;

import am.sam.dto.UserRoleApplicationDTO;
import am.sam.entity.*;
import am.sam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping
    public List<UserRoleApplicationDTO> getAllUsers() {

        return userService.getAllUsers();
    }

    @RequestMapping("/{id}")
    public UserRoleApplicationDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/roles/{roleId}")
    public void addUser(@RequestBody User user, @PathVariable Long roleId) {
        userService.addUser(user, roleId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/application/{applicationId}")
    public void addApplicationToUser(@PathVariable Long id, @PathVariable Long applicationId) {
        userService.addApplicationToUser(id, applicationId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/roles/{roleId}")
    public void updateUser(@RequestBody User user, @PathVariable Long id, @PathVariable Long roleId) {
        userService.updateUser(user, id, roleId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}
