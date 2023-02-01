package com.minotore.salesapp.services.impl;

import com.minotore.salesapp.models.Sale;
import com.minotore.salesapp.repositories.SaleRepository;
import com.minotore.salesapp.services.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;

    @Override
    public void createSale(Sale sale){
        saleRepository.save(sale);
        log.info("Product: {} is saved",sale.toString());
    }
    @Override
    public List<Sale> getAllSales(){
        return saleRepository.findAll();
    }
    @Override
    public List<Sale> findAllByLibraryName(String libName){
        return saleRepository.findAllByLibraryName(libName);
    }
}
