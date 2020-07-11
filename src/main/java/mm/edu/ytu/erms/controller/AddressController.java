package mm.edu.ytu.erms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mm.edu.ytu.erms.model.Address;
import mm.edu.ytu.erms.service.AddressService;

@RestController
@CrossOrigin
@RequestMapping("address")
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@GetMapping
	public List<Address> getAll() {
		return addressService.getAll();
	}
	
	@GetMapping("{id}")
	public Address getById(@PathVariable Long id) {
		return addressService.getById(id);
	}
	
	@PostMapping
	public Address create(@RequestBody Address address) {
		return addressService.create(address);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Address update(@RequestBody Address address) {
		return addressService.update(address);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteById(@PathVariable Long id) {
		addressService.deleteById(id);
	}
}