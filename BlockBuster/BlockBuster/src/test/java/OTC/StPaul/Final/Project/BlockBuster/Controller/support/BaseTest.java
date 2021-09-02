package OTC.StPaul.Final.Project.BlockBuster.Controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import lombok.Getter;

public class BaseTest {
  @LocalServerPort
  private int serverPort;
  
  @Autowired
  @Getter
  private TestRestTemplate restTemplate;
  
  /**
   * 
   * @return
   */
  protected String getBaseUriForBlockbuster() {
    return String.format("http://localhost:%d/otc_stpaul_blockbuster", serverPort);
  }
  
  /**
   * 
   * @return
   */
  protected String getBaseUriForTransactions() {
    return String.format("http://localhost:%d/transactions", serverPort);
  }

} // last bracket
