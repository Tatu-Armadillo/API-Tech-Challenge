package br.com.fiap.pos.challenge.trips.services;


import br.com.fiap.pos.challenge.trips.models.User;
import br.com.fiap.pos.challenge.trips.repositories.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public List<User> getAllUsers(){
        return sampleRepository.findAll();
    }
}
