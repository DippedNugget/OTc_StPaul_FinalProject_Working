package OTC.StPaul.Final.Project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import OTC.StPaul.Final.Project.dao.StoresDao;
import OTC.StPaul.Final.Project.entity.stores;

@Service
public class DefaultStoresService implements StoresService {
  
  @Autowired
  private StoresDao storesDao;

  @Override
  public List<stores> listAllStores() {
    return storesDao.listAllStores();
  }

  @Override
  public List<stores> retrieveAStoreByStoreId(int store_idPK) {
    return storesDao.retrieveAStoreByStoreId(store_idPK);
  }

  @Override
  public void addStore(String address, String phone) {
    storesDao.addStore(address, phone);
    
  }

  @Override
  public void deleteStoreById(int store_idPK) {
    storesDao.deleteStoreById(store_idPK);
    
  }

  @Override
  public void updateAddressByStoreId(String address, int store_idPK) {
    storesDao.updateAddressByStoreId(address, store_idPK);
    
  }

  @Override
  public void updatePhoneByStroreId(String phone, int store_idPK) {
    storesDao.updatePhoneByStroreId(phone, store_idPK);
    
  }

} // last bracket
