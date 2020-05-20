package ehb.be.voorbeeldexamen.budget.controller;


import ehb.be.voorbeeldexamen.budget.model.Budget;
import ehb.be.voorbeeldexamen.budget.model.BudgetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/items")
public class BudgetController {

    @Autowired
    private BudgetDAO dao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Budget> showAll(){
        return dao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Budget> findById (@PathVariable(value = "id")int id){
        return dao.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Iterable<Budget> findByCategorie(@RequestParam(value = "cat") String categorie) {
        return dao.findByCategorie(categorie);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public void createItem(@RequestParam(value = "naam")String naam,
                           @RequestParam(value = "prijs")double prijs,
                           @RequestParam(value = "aantal")int aantal,
                           @RequestParam(value = "categorie")String categorie){
        Budget budget = new Budget(naam, prijs, aantal, categorie);
        dao.save(budget);
    }


}
