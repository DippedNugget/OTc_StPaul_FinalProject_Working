package OTC.StPaul.Final.Project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import OTC.StPaul.Final.Project.entity.stores;
import OTC.StPaul.Final.Project.service.StoresService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultStoresController implements StoresController {
  
  @Autowired
  private StoresService storesService;

  @Override
  public ResponseEntity<List<stores>> listAllStores() {
    log.info("A Request was made for all stores");
    List<stores> stores = storesService.listAllStores();
    return new ResponseEntity<List<stores>>(stores, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<stores>> retrieveAStoreByStoreId(int store_idPk) {
    log.info("A Request was made to list a store", store_idPk);
    List<stores> singleStore = storesService.retrieveAStoreByStoreId(store_idPk);
    return new ResponseEntity<List<stores>>(singleStore, HttpStatus.OK);
  }

  @Override
  public void addStore(String address, String phone) {
    log.info("Added a Store");
    storesService.addStore(address, phone);
    
  }

  @Override
  public void deleteStoreById(int store_idPK) {
    log.info("Deleted a store");
    storesService.deleteStoreById(store_idPK);
    
  }

  @Override
  public void updateStoreAddressById(String address, int store_idPK) {
    log.info("Updated an Address");
    storesService.updateAddressByStoreId(address, store_idPK);
    
  }

  @Override
  public void updateStorePhoneById(String phone, int store_idPK) {
    log.info("Updated phone");
    storesService.updatePhoneByStroreId(phone, store_idPK);
    
  }

} // last bracket
