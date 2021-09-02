package OTC.StPaul.Final.Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import OTC.StPaul.Final.Project.entity.transactionRequest;
import OTC.StPaul.Final.Project.entity.transactions;
import OTC.StPaul.Final.Project.service.TransactionsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultTransactionsController implements TransactionsController {
  
  @Autowired
  private TransactionsService transactionsService;
  
  public transactions createTransaction(transactionRequest transactionRequest) {
    log.debug("Transaction={}", transactionRequest);
    return transactionsService.createTransaction(transactionRequest);
  }

} // last bracket
