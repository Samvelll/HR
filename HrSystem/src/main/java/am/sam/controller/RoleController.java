package am.sam.controller;

import am.sam.dto.RoleUserPermissionResumeDTO;
import am.sam.entity.Role;
import am.sam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping
    public List<RoleUserPermissionResumeDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @RequestMapping("/{id}")
    public RoleUserPermissionResumeDTO getRole(@PathVariable Long id) {
        return roleService.getRole(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addRole(@RequestBody Role role) {
        roleService.addRole(role);
    }

    @RequestMapping(method = RequestMethod.POST, value = "{id}/permissions/{permissionId}")
    public void addPermissionToRole(@PathVariable Long id, @PathVariable Long permissionId) {
        roleService.addPermissionToRole(id, permissionId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/resumes/{resumeId}")
    public void addResumeToRole(@PathVariable Long id, @PathVariable Long resumeId) {
        roleService.addResumeToRole(id, resumeId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateRole(@RequestBody Role role, @PathVariable Long id) {
        roleService.updateRole(role);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
