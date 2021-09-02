package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import OTC.StPaul.Final.Project.entity.stores;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/otc_stpaul_blockbuster")
@OpenAPIDefinition(info = @Info(title = "OTC StPaul Blockbuster"), servers = {
    @Server(url = "http://localhost:8080", description = "Local Server.")})

public interface StoresController {
  @GetMapping("/stores")
  ResponseEntity<List<stores>> listAllStores();
  
  @GetMapping("/stores/{store_idPK}")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<stores>> retrieveAStoreByStoreId(@RequestParam(required = true)int store_idPk);
  
  @PostMapping("/stores/addstore")
  @ResponseStatus(code = HttpStatus.CREATED) void addStore (
      @RequestParam(required = true) String address,
      @RequestParam(required = true) String phone
      );
  @DeleteMapping("/deletestore/{store_idPK}")
  @ResponseStatus(code = HttpStatus.OK) void deleteStoreById(
      @PathVariable int store_idPK
      );
  @PutMapping("/updatestores/{address}")
  @ResponseStatus(code = HttpStatus.OK) void updateStoreAddressById(
      @RequestParam(required = true) String address,
      @RequestParam(required = true) int store_idPK
      );
  @PutMapping("updatestores/{phone}")
  @ResponseStatus(code = HttpStatus.OK) void updateStorePhoneById(
      @RequestParam(required = true) String phone,
      @RequestParam(required = true) int store_idPK
      );
}
