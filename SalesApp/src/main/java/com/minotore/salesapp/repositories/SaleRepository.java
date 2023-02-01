package com.minotore.salesapp.repositories;

import com.minotore.salesapp.models.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SaleRepository extends MongoRepository<Sale,String> {

    List<Sale> findAllByLibraryName(String libName);
}
