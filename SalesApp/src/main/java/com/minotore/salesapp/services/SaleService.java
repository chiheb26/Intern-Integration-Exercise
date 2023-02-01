package com.minotore.salesapp.services;

import com.minotore.salesapp.models.Sale;
import com.minotore.salesapp.repositories.SaleRepository;

import java.util.List;

public interface SaleService {



    public void createSale(Sale sale);
    public List<Sale> getAllSales();

    public List<Sale> findAllByLibraryName(String libName);
}
