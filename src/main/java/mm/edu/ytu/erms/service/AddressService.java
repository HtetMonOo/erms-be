package mm.edu.ytu.erms.service;

import java.util.List;

import mm.edu.ytu.erms.model.Address;

public interface AddressService {
	List<Address> getAll(Integer pageNo, Integer pageSize);
	Address getById(Long id);
	Address create(Address address);
	Address update(Address address);
	void deleteById(Long id);
}