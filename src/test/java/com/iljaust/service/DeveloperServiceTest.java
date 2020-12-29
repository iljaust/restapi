package com.iljaust.service;

import com.iljaust.model.Account;
import com.iljaust.model.AccountStatus;
import com.iljaust.model.Developer;
import com.iljaust.model.Skill;
import com.iljaust.respository.hibernate.DeveloperRepositoryImpl;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeveloperServiceTest {
    @Mock
    private DeveloperRepositoryImpl developerRepository;
    @InjectMocks
    private DeveloperService developerService;

    private static Skill skill;
    private static Skill skill2;
    private static Account account;
    private static Developer developer;
    private static Set<Skill> skillList;
    private static List<Developer> developerList;


    @BeforeClass
    public static void setUp(){
        account = new Account();
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setData("good dev");
        account.setId(1l);

        skill = new Skill();
        skill.setName("Java");
        skill.setId(1l);

        skill2 = new Skill();
        skill.setName("C++");
        skill.setId(2l);

        skillList = new HashSet<>();

        skillList.add(skill);
        skillList.add(skill2);

        developer = new Developer();
        developer.setName("John Smith");
        developer.setId(1l);
        developer.setSkillSet(skillList);
        developer.setAccountStatus(account);


    }

    @Test
    void shouldGetListOfDevelopers() {

        developerList = new ArrayList<>();
        developerList.add(developer);


        given(developerRepository.getAll()).willReturn(developerList);

        List<Developer> expected = developerService.getAll();

        assertEquals(expected,developerList);
    }

    @Test
    void shouldUpdateDevelopers() {
        Developer developer = new Developer();
        developer.setName("John Smith");
        developer.setId(1l);
        developer.setSkillSet(skillList);
        developer.setAccountStatus(account);

        given(developerRepository.update(developer)).willReturn(developer);

        final Developer expected = developerService.update(developer);

        assertThat(expected).isNotNull();
    }

    @Test
    void shouldDeleteDeveloperById() {
        final Long id = 1l;

        developerService.deleteById(id);
        developerService.deleteById(id);

        verify(developerRepository,times(2)).deleteById(id);
    }

    @Test
    void shouldSaveDeveloper() {
        Developer developer = new Developer();
        developer.setName("John Smith");
        developer.setId(1l);
        developer.setSkillSet(skillList);
        developer.setAccountStatus(account);

        given(developerRepository.save(developer)).willReturn(developer);

        Developer savedDeveloper = developerService.save(developer);

        assertThat(savedDeveloper).isNotNull();
    }

    @Test
    void shouldFindDeveloperById() {
        Developer developer = new Developer();
        final Long id = 1l;
        developer.setName("John Smith");
        developer.setId(id);
        developer.setSkillSet(skillList);
        developer.setAccountStatus(account);

        given(developerRepository.getById(id)).willReturn(developer);

        final Developer expected = developerService.getById(id);

        assertThat(expected).isNotNull();
    }
}