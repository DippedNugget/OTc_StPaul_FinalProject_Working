package OTC.StPaul.Final.Project.dao;

import java.util.List;
import java.util.Optional;
import OTC.StPaul.Final.Project.entity.concessions;
import OTC.StPaul.Final.Project.entity.customers;
import OTC.StPaul.Final.Project.entity.movies;
import OTC.StPaul.Final.Project.entity.stores;
import OTC.StPaul.Final.Project.entity.transactions;

public interface TransactionsDao {

  /**
   * 
   * @param customer
   * @param store
   * @param total
   * @param movies_rented
   * @param concessions_purchased
   * @return
   */
  transactions saveTransaction(customers customer, stores store, Double total,
      List<movies> movies_rented, List<concessions> concessions_purchased);

  /**
   * 
   * @param customer_idPK
   * @return
   */
  Optional<customers> fetchCustomer(Integer customer_idPK);
  
  /**
   * 
   * @param store_idPK
   * @return
   */
  Optional<stores> fetchStore(Integer store_idPK);
  
  /**
   * 
   * @param movie_idPK
   * @return
   */
  List<movies> fetchMovie(List<String> movie_idPKs);
  
  /**
   * 
   * @param concession_idPK
   * @return
   */
  List<concessions> fetchConcession(List<String> concession_idPKs);

} // last bracket
