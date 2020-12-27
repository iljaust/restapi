package com.iljaust.service;

import com.iljaust.model.Skill;
import com.iljaust.respository.SkillRepository;
import com.iljaust.respository.hibernate.SkillRepositoryImpl;

import java.util.List;

public class SkillService {
    private SkillRepository skillRepository = new SkillRepositoryImpl();


    public List<Skill> getAll(){

        return skillRepository.getAll();

    }

    public Skill update(Skill skill) {

        return skillRepository.update(skill);
    }

    public void deleteById(Long id) {

        skillRepository.deleteById(id);
    }

    public Skill save(Skill skill) {

        skillRepository.save(skill);
        return skill;
    }

    public Skill getById(Long id) {

        return skillRepository.getById(id);
    }
}
