package com.aclpoc.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aclpoc.client.model.ClientJpaEntity;

@Repository
public interface ClientJPARepository extends JpaRepository<ClientJpaEntity, Long> {
	
//	@PostFilter("hasPermission(filterObject, 'write')")
	List<ClientJpaEntity> findAll();
	
//	@Secured("ROLE_Admin")
	void deleteById(Long id);
	

}
