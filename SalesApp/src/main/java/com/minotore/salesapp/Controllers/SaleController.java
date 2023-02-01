package com.minotore.salesapp.Controllers;

import com.minotore.salesapp.models.Sale;
import com.minotore.salesapp.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sales")
public class SaleController {
    private final SaleService saleService;

    @GetMapping("/library/{libName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Sale> findAllByLibraryName(@PathVariable String libName){
        return saleService.findAllByLibraryName(libName);
    }
}
