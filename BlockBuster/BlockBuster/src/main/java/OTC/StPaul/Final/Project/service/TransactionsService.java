package OTC.StPaul.Final.Project.service;

import OTC.StPaul.Final.Project.entity.transactionRequest;
import OTC.StPaul.Final.Project.entity.transactions;

public interface TransactionsService {

  /**
   * 
   * @param transactionRequest
   * @return
   */
  transactions createTransaction(transactionRequest transactionRequest);

}
