package unit;

import com.wilcage.springtest.Person;
import com.wilcage.springtest.PersonController;
import com.wilcage.springtest.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import static org.hamcrest.CoreMatchers.allOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by wicampusano on 8/31/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ComponentScan(basePackages = "com.wilcage")
public class PersonControllerTest_The_Spring_Test_way {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personService;

    @Mock
    private View mockView;


    private MockMvc mockMvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(personController)
                .setSingleView(mockView)
                .build();
    }

    @Test
    public void testGetPerson() throws Exception{
        when(personService.getPerson(1l)).thenReturn(new Person(1l, "Chuck"));
        ResultActions resultActions = mockMvc.perform(get("/person/{id}", 1l));

        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("personData"))
                .andExpect(model().attribute("personData",
                        allOf( )));
    }

}
