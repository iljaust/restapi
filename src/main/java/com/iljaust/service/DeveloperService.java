package com.iljaust.service;

import com.iljaust.model.Developer;
import com.iljaust.respository.DeveloperRepository;
import com.iljaust.respository.hibernate.DeveloperRepositoryImpl;

import java.util.List;

public class DeveloperService {
    private DeveloperRepository developerRepository = new DeveloperRepositoryImpl();


    public List<Developer> getAll(){

        return developerRepository.getAll();
    }

    public Developer update(Developer developer) {

        return developerRepository.update(developer);
    }

    public void deleteById(Long id) {

        developerRepository.deleteById(id);
    }

    public Developer save(Developer developer) {

        developerRepository.save(developer);
        return developer;
    }

    public Developer getById(Long id) {

        return developerRepository.getById(id);
    }
}
