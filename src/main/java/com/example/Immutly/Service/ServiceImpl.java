package com.example.Immutly.Service;

import com.example.Immutly.Dto.GetNewProductRequest;
import com.example.Immutly.Dto.ProductUpdateRequest;
import com.example.Immutly.Entity.Product;
import com.example.Immutly.RepositoryService.IRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements IService{

    @Autowired
    IRepositoryService repositoryService;
    @Override
    public List<Product> getAllProducts() {
        return repositoryService.getAllProducts();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = repositoryService.getProductById(id);
        return product.orElse(null);
    }

    @Override
    public String addNewProduct(GetNewProductRequest productRequest) {
        return repositoryService.addNewProduct(productRequest);
    }

    @Override
    public Boolean deleteProductById(Long id) {
        return repositoryService.deleteProductById(id);
    }

    @Override
    public Boolean updateProduct(Long id,ProductUpdateRequest updateRequest) {
        return repositoryService.updateProduct(id,updateRequest);
    }

}
