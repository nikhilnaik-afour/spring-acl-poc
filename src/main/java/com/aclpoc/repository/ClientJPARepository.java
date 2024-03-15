package com.aclpoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aclpoc.model.ClientJpaEntity;

@Repository
public interface ClientJPARepository extends JpaRepository<ClientJpaEntity, Long> {

	List<ClientJpaEntity> findAll();

	void deleteById(Long id);

}
