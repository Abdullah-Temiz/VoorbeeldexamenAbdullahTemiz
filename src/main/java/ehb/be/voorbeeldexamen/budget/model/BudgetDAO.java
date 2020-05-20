package ehb.be.voorbeeldexamen.budget.model;

import org.springframework.data.repository.CrudRepository;

public interface BudgetDAO extends CrudRepository<Budget, Integer> {

    Iterable<Budget> findByCategorie(String categorie);


}
