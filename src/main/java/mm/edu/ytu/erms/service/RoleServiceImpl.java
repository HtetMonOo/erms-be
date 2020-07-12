package mm.edu.ytu.erms.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.edu.ytu.erms.model.Role;
import mm.edu.ytu.erms.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role getOne(Integer id) {
		return roleRepository.getOne(id);
	}

	@Override
	public Role create(Role role) {
		return roleRepository.saveAndFlush(role);
	}

	@Override
	public Role update(Role role) {
		Role existingRole = roleRepository.getOne(role.getId());
		BeanUtils.copyProperties(role, existingRole, "id");
		return roleRepository.saveAndFlush(existingRole);
	}

	@Override
	public void delete(Integer id) {
		roleRepository.delete(roleRepository.getOne(id));
		
	}

}
