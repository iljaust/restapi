package com.iljaust.service;

import com.iljaust.model.Skill;
import com.iljaust.respository.hibernate.SkillRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SkillServiceTest {
    @Mock
    private SkillRepositoryImpl skillRepository;
    @InjectMocks
    private SkillService skillService;

    @Test
    void shouldGetListOfSkills() {
        List<Skill> skillList = new ArrayList<>();
        final Skill skill = new Skill();
        skill.setName("Java");
        skill.setId(1l);

        final Skill skill2 = new Skill();
        skill.setName("C++");
        skill.setId(2l);

        skillList.add(skill);
        skillList.add(skill2);

        given(skillRepository.getAll()).willReturn(skillList);

        List<Skill> expected = skillService.getAll();

        assertEquals(expected,skillList);
    }

    @Test
    void shouldUpdateSkill() {
        final Skill skill = new Skill();
        skill.setName("Java");
        skill.setId(1l);

        given(skillRepository.update(skill)).willReturn(skill);

        final Skill expected = skillService.update(skill);

        assertThat(expected).isNotNull();

    }

    @Test
    void shouldDeleteSkillById() {
        final Long id = 1l;

        skillService.deleteById(id);
        skillService.deleteById(id);

        verify(skillRepository,times(2)).deleteById(id);
    }

    @Test
    void shouldSaveSkill() {
        final Skill skill = new Skill();
        skill.setName("Java");
        skill.setId(1l);

        given(skillRepository.save(skill)).willReturn(skill);

        Skill savedSkill = skillService.save(skill);

        assertThat(savedSkill).isNotNull();
    }

    @Test
    void shouldFindSkillById() {
        final Long id = 1l;
        final Skill skill = new Skill();
        skill.setId(id);
        skill.setName("Java");

        given(skillRepository.getById(id)).willReturn(skill);

        final Skill expected = skillService.getById(id);

        assertThat(expected).isNotNull();
    }
}