package OTC.StPaul.Final.Project.dao;

import java.util.List;
import OTC.StPaul.Final.Project.entity.stores;

public interface StoresDao {
  List<stores> listAllStores();
  
  List<stores> retrieveAStoreByStoreId(int store_idPK);
  
  void addStore(String address, String phone);
  
  void deleteStoreById(int store_idPK);
  
  void updateAddressByStoreId(String address, int store_idPK);
  
  void updatePhoneByStroreId(String phone, int store_idPK);
}
