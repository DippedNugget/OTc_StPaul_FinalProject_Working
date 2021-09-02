package OTC.StPaul.Final.Project.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import OTC.StPaul.Final.Project.dao.TransactionsDao;
import OTC.StPaul.Final.Project.entity.concessions;
import OTC.StPaul.Final.Project.entity.customers;
import OTC.StPaul.Final.Project.entity.movies;
import OTC.StPaul.Final.Project.entity.stores;
import OTC.StPaul.Final.Project.entity.transactionRequest;
import OTC.StPaul.Final.Project.entity.transactions;

@Service
public class DefaultTransactionsService implements TransactionsService {
  
  @Autowired
  private TransactionsDao transactionsDao;
  
  @Transactional
  @Override
  public transactions createTransaction(transactionRequest transactionRequest) {
    customers customer = getCustomer(transactionRequest);
    stores store = getStore(transactionRequest);
    List<movies> movies = getMovie(transactionRequest);
    List<concessions> concessions = getConcession(transactionRequest);
    
    Double total = ((movies.size()) * 1.99);
       
    for(concessions concession : concessions) {
      total = total + concession.getPrice();
    }
    
    return transactionsDao.saveTransaction(customer, store, total, movies, concessions);
  }

  /**
   * 
   * @param transactionRequest
   * @return
   */
  private customers getCustomer(transactionRequest transactionRequest) {
    return transactionsDao.fetchCustomer(transactionRequest.getCustomer_idFK())
        .orElseThrow(() -> new NoSuchElementException("Customer with ID=" 
            + transactionRequest.getCustomer_idFK() + " was not found"));
  }
  
  /**
   * 
   * @param transactionRequest
   * @return
   */
  private stores getStore(transactionRequest transactionRequest) {
    return transactionsDao.fetchStore(transactionRequest.getStore_idFK())
        .orElseThrow(() -> new NoSuchElementException("Store with ID="
            + transactionRequest.getStore_idFK() + " was not found"));
  }
  
  /**
   * 
   * @param transactionRequest
   * @return
   */
  private List<movies> getMovie(transactionRequest transactionRequest) {
    return transactionsDao.fetchMovie(transactionRequest.getMovies());
  }
  
  private List<concessions> getConcession(transactionRequest transactionRequest) {
    return transactionsDao.fetchConcession(transactionRequest.getConcessions());
  }

} // last bracket
