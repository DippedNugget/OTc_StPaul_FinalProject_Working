package OTC.StPaul.Final.Project.dao;

import java.util.List;
import OTC.StPaul.Final.Project.entity.concessions;

public interface ConcessionsDao {
  /**
   * 
   * @return
   */
  List<concessions> listAllConcessions();
  
  /**
   * 
   * @param concession_id
   * @return
   */
  List<concessions> retrieveSingleConcessionByConcessionID(int concessions_id);
  
  /**
   * 
   * @param full_name
   * @return
   */
  List<concessions> retrieveSingleConcessionByName(String full_name);
  
  /**
   * 
   * @param full_name
   * @param price
   * @param quantity
   */
  void addConcession(String full_name, double price, int quantity);
  
  /**
   * 
   * @param concession_id
   */
  void deleteConcessionById(int concessions_id);
  
  /**
   * 
   * @param full_name
   * @param concession_id
   */
  void updateConcessionNameById(String full_name, int concessions_id);
  
  /**
   * 
   * @param price
   * @param concession_id
   */
  void updateConcessionPriceById(double price, int concessions_id);
  
  /**
   * 
   * @param quantity
   * @param concession_id
   */
  void updateConcessionQuantityById(int quantity, int concessions_id);
  
} // last bracket

