package com.wilcage.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wicampusano on 8/31/2015.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getPerson(@PathVariable Long id, Model model){
        model.addAttribute("personData", personService.getPerson(id));
        return "personPage";
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
