package com.examples.microserv.extbilling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.examples.microserv.extbilling.model.Bill;


@RepositoryRestResource(collectionResourceRel = "bills", path = "bills")
@Repository
public interface BillRepository extends JpaRepository<Bill, String> {
  Bill findBybillControlNumber(String ctrNum);
  

}
