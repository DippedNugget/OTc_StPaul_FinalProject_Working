package OTC.StPaul.Final.Project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import OTC.StPaul.Final.Project.dao.ConcessionsDao;
import OTC.StPaul.Final.Project.entity.concessions;

@Service
public class DefaultConcessionsService implements ConcessionsService {

  @Autowired
  private ConcessionsDao concessionsDao;
  
  @Override
  public List<concessions> listAllConcessions() {
    return concessionsDao.listAllConcessions();
  }

  @Override
  public List<concessions> retrieveSingleConcessionByConcessionID(int concessions_id) {
    return concessionsDao.retrieveSingleConcessionByConcessionID(concessions_id);
  }

  @Override
  public List<concessions> retrieveSingleConcessionByName(String full_name) {
    return concessionsDao.retrieveSingleConcessionByName(full_name);
  }

  @Override
  public void addConcession(String full_name, double price, int quantity) {
    concessionsDao.addConcession(full_name, price, quantity);
  }

  @Override
  public void deleteConcessionById(int concessions_id) {
   concessionsDao.deleteConcessionById(concessions_id);
  }

  @Override
  public void updateConcessionNameById(String full_name, int concessions_id) {
    concessionsDao.updateConcessionNameById(full_name, concessions_id);
  }

  @Override
  public void updateConcessionPriceById(double price, int concessions_id) {
    concessionsDao.updateConcessionPriceById(price, concessions_id);
  }

  @Override
  public void updateConcessionQuantityById(int quantity, int concessions_id) {
    concessionsDao.updateConcessionQuantityById(quantity, concessions_id);
  }

} // last bracket
