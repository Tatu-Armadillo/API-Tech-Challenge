package br.com.fiap.pos.challenge.trips.controllers;

import br.com.fiap.pos.challenge.trips.models.User;
import br.com.fiap.pos.challenge.trips.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class GetTest {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/test")
    public ResponseEntity<List<User>> getTest(){
        return ResponseEntity.ok(sampleService.getAllUsers());
    }
}
