package OTC.StPaul.Final.Project.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import OTC.StPaul.Final.Project.entity.transactionRequest;
import OTC.StPaul.Final.Project.entity.transactions;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/transactions")
@OpenAPIDefinition(info = @Info(title = "Blockbuster Transaction Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local Server.")})
public interface TransactionsController {

  //@formatter:off
  @Operation(
     summary = "Create a transaction",
     description = "Returns the transaction",
     responses = {
         @ApiResponse(
             responseCode = "201", 
             description = "the created transaction is returned", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = transactions.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "A transaction component was not found with the input criteria", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occurred", 
             content = @Content(mediaType = "application/json"))
     },
     parameters = {
         @Parameter(
             name = "transactionRequest", 
             required = true, 
             description = "The order as JSON")
     }
  )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  transactions createTransaction(
      @Valid @RequestBody transactionRequest transactionRequest);

} // last bracket
