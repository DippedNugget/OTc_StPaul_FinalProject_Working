package OTC.StPaul.Final.Project.BlockBuster.Controller.support;

public class CreateOrderTestSupport extends BaseTest {
  
  protected String createOrderBody() {
    // @formatter:off
    return "{\n"
        + " \"customer_idFK\":\"1\",\n"
        + " \"store_idFK\":\"3\",\n"
        + " \"movies\":[\n"
        + "   \"13\",\n"
        + "   \"15\"],\n"
        + " \"concessions\":[\n"
        + "   \"5\"]\n"
        + "}";
    // @formatter:on
  }

} // last bracket
