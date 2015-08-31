package unit;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.wilcage.springtest.Person;
import com.wilcage.springtest.PersonController;
import com.wilcage.springtest.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by wicampusano on 8/31/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class PersonControllerTest_The_Spring_Test_way {

    @Autowired
    private WebAppConfiguration ctx;

    private MockMvc mockMvc;

    @Before
    public void withAnAppContext(){
        mockMvc = MockMvcBuilders.standaloneSetup(ctx).build();
    }

    @Test
    public void testGetPerson() throws Exception{
        ResultActions personControllerResults = mockMvc.perform(get("/person/{id}", 1l));

        personControllerResults.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("personPage"))
                .andExpect(model().attribute("personData",
                        allOf( hasProperty("Id", is(1l)) , hasProperty("name"), is("Chuck"))));
    }


    @Configuration
    public static class TestConfiguration{
        @Bean
        public PersonController personController(){
            PersonController controller = new PersonController();
            return controller;
        }
    }
}
