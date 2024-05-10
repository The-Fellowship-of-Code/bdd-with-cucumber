package mercacucumber.cucumberdemo.adapters;

import lombok.RequiredArgsConstructor;
import mercacucumber.cucumberdemo.domain.Supplier;
import mercacucumber.cucumberdemo.mappers.SupplierRepositoryMapper;
import mercacucumber.cucumberdemo.repositories.SupplierRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SupplierRepositoryAdapter {

    private final SupplierRepository supplierRepository;

    private final SupplierRepositoryMapper supplierRepositoryMapper;

    public List<Supplier> findAll(){

        return supplierRepository.findAll()
                .stream().map(supplierRepositoryMapper::toDomain)
                .toList();
    }

    public Optional<Supplier> findById(Long id){

        return supplierRepository.findById(id)
                .map(supplierRepositoryMapper::toDomain);
    }

    public Supplier upsert(Supplier supplier){

        return supplierRepositoryMapper.toDomain(
                supplierRepository.save(
                        supplierRepositoryMapper.toEntity(supplier)));
    }

    public void delete(Long id){

        supplierRepository.deleteById(id);
    }
}
