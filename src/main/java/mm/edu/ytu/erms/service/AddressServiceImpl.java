package mm.edu.ytu.erms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.edu.ytu.erms.model.Address;
import mm.edu.ytu.erms.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	@Transactional
	@Override
	public List<Address> getAll() {
		return addressRepository.findAll();
	}

	@Transactional
	@Override
	public Address getById(Long id) {
		return addressRepository.getOne(id);
	}

	@Transactional
	@Override
	public Address create(Address address) {
		return addressRepository.saveAndFlush(address);
	}

	@Transactional
	@Override
	public Address update(Address address) {
		Address oldAddress = addressRepository.getOne(address.getId());
		BeanUtils.copyProperties(address, oldAddress, "id");
		return addressRepository.saveAndFlush(oldAddress);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		addressRepository.deleteById(id);
	}
}