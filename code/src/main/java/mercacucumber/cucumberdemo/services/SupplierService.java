package mercacucumber.cucumberdemo.services;

import lombok.RequiredArgsConstructor;
import mercacucumber.cucumberdemo.adapters.SupplierRepositoryAdapter;
import mercacucumber.cucumberdemo.domain.Supplier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepositoryAdapter supplierRepositoryAdapter;

    public List<Supplier> getSuppliers(){

        return supplierRepositoryAdapter.findAll();
    }

    public Supplier getSupplierById(Long id){

        return supplierRepositoryAdapter.findById(id).orElse(null);
    }

    @Transactional
    public Supplier createSupplier(Supplier supplier){

        return supplierRepositoryAdapter.upsert(supplier);
    }

    @Transactional
    public Supplier updateSupplier(Long id, Supplier supplier){

        return supplierRepositoryAdapter.upsert(supplier);
    }

    @Transactional
    public void deleteSupplier(Long id){

        supplierRepositoryAdapter.delete(id);
    }
}
