package com.example.Immutly.RepositoryService;

import com.example.Immutly.Dto.GetNewProductRequest;
import com.example.Immutly.Dto.ProductUpdateRequest;
import com.example.Immutly.Entity.Product;
import com.example.Immutly.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryServiceImpl implements IRepositoryService {
    @Autowired
    ProductRepository repository;
    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return repository.getProductById(id);
    }

    @Override
    public String addNewProduct(GetNewProductRequest productRequest) {
        Product product = new Product(getNextProductId(),productRequest.getProductName(),productRequest.getProductDescription(),productRequest.getPrice(), productRequest.isAvailabilityStatus());
        repository.save(product);
        return product.getId().toString();
    }

    @Override
    public Boolean deleteProductById(Long id) {
        Product product = repository.getProductById(id).orElse(null);
        if(product != null){
            repository.delete(product);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateProduct(Long id, ProductUpdateRequest updateRequest) {
        Product product = repository.getProductById(id).orElse(null);
        if(product != null){
            product.setProductName(updateRequest.getProductName() != null ? updateRequest.getProductName(): product.getProductName());
            product.setProductDescription(updateRequest.getProductDescription() != null ? updateRequest.getProductDescription(): product.getProductDescription());
            product.setPrice(updateRequest.getPrice() != null ? updateRequest.getPrice(): product.getPrice());
            product.setAvailabilityStatus(updateRequest.getAvailabilityStatus() != null? updateRequest.getAvailabilityStatus():product.getAvailabilityStatus());
            repository.deleteById(id);
            repository.save(product);
            return true;
        }
        return false;
    }

    private long getNextProductId() {
        List<Product> allProducts = repository.findAll();
        return allProducts.isEmpty() ? 1 : allProducts.stream().mapToLong(Product::getId).max().orElse(0) + 1;
    }
}
