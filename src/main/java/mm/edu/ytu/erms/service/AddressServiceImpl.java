package mm.edu.ytu.erms.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mm.edu.ytu.erms.model.Address;
import mm.edu.ytu.erms.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	@Transactional
	@Override
	public List<Address> getAll(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Address> pagedResult = addressRepository.findAll(paging);
		if(pagedResult.hasContent()){
			return pagedResult.getContent();
		}else{
			return new ArrayList<Address>();
		}
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
		BeanUtils.copyProperties(address, oldAddress, "id", "dateCreated");
		return addressRepository.saveAndFlush(oldAddress);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		addressRepository.deleteById(id);
	}
}