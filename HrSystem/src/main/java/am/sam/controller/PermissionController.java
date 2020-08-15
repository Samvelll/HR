package am.sam.controller;

import am.sam.dto.PermissionRoleDTO;
import am.sam.entity.Permission;
import am.sam.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping
    public List<PermissionRoleDTO> getAllPermissions() {

        return permissionService.getAllPermissions();
    }

    @RequestMapping("/{id}")
    public PermissionRoleDTO getPermission(@PathVariable Long id) {

        return permissionService.getPermission(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addPermission(@RequestBody Permission permission) {
        permissionService.addPermission(permission);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updatePermission(@RequestBody Permission permission, @PathVariable Long id) {
        permissionService.updatePermission(permission, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
    }

}
