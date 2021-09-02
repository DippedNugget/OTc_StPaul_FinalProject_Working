package OTC.StPaul.Final.Project.BlockBuster.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.jdbc.JdbcTestUtils;
import OTC.StPaul.Final.Project.BlockBuster.Controller.support.CreateOrderTestSupport;
import OTC.StPaul.Final.Project.entity.transactions;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
//@Sql(scripts = {"classpath:OTC_StPaul_BlockBuster_Database.sql",
//    "classpath:OTC_StPaul_BlockBuster_DataEntry.sql"}, 
//      config = @SqlConfig(encoding = "utf-8"))
class CreateOrderTest extends CreateOrderTestSupport {
  
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  void testCreateOrderReturnsSuccess201() {
    // Given: an order as Json
    String body = createOrderBody();
    String uri = getBaseUriForTransactions();
    
    int numRowsTransactions = JdbcTestUtils.countRowsInTable(jdbcTemplate, "transactions");
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    
    HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
    
    // When: the order is sent
    ResponseEntity<transactions> response = getRestTemplate().exchange(uri, HttpMethod.POST,
        bodyEntity, transactions.class);
    
    // Then: a 201 Status is Returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    
    // And: the return order is correct
    assertThat(response.getBody()).isNotNull();
    
    transactions transaction = response.getBody();
    assertThat(transaction.getCustomer().getCustomer_idPK()).isEqualTo(1);
    assertThat(transaction.getStore().getStore_idPK()).isEqualTo(3);
    assertThat(transaction.getMovies_rented()).hasSize(2);
    assertThat(transaction.getConcessions_purchased()).hasSize(1);
    
    assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "transactions"))
        .isEqualTo(numRowsTransactions + 1);
    
  }

} // last bracket
