package se.lexicon.todoapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.todoapi.model.entity.Role;
import se.lexicon.todoapi.repository.RoleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Role>> getAllRoles(){

        List<Role> roleList = roleRepository.findAll();
        return ResponseEntity.ok(roleList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable("id") Integer id){
        System.out.println("id = " + id);
        Role role = roleRepository.findById(id).orElse(null);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleById(@PathVariable("id") Integer id){
        System.out.println("id = " + id);
        roleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        System.out.println("role = " + role);
        Role createRole = roleRepository.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRole);
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateRoleById(@RequestBody Role role){
        System.out.println("role = " + role);
        roleRepository.save(role);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
