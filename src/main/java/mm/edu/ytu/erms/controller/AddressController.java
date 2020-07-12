package mm.edu.ytu.erms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mm.edu.ytu.erms.model.Address;
import mm.edu.ytu.erms.service.AddressService;

@RestController
@CrossOrigin
@RequestMapping("address")
public class AddressController {
	@Autowired
	AddressService addressService;

	@GetMapping
	public List<Address> getAll(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize)
	{
		return addressService.getAll(pageNo, pageSize);
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