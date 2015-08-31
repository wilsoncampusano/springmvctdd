package unit;

import com.wilcage.springtest.Person;
import com.wilcage.springtest.PersonController;
import com.wilcage.springtest.PersonService;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by wicampusano on 8/31/2015.
 */
public class PersonControllerTest_The_Api_Way {

    @Test
    public void testGetPerson(){
        PersonService personService = mock(PersonService.class);
        when(personService.getPerson(1l)).thenReturn(new Person(1l, "Chuck"));

        PersonController personController = new PersonController();
        personController.setPersonService(personService);

        Model model = new ExtendedModelMap();

        String view = personController.getPerson(1l, model);
        Person actualPerson = (Person) model.asMap().get("personData");

        assertEquals("View name", "personPage", view);
        assertEquals("matching ID", Long.valueOf(1), actualPerson.getId());
        assertEquals("matching name", "Chuck", actualPerson.getName());
    }

}
