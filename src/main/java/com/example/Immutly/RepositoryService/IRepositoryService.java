package com.example.Immutly.RepositoryService;

import com.example.Immutly.Dto.GetNewProductRequest;
import com.example.Immutly.Dto.ProductUpdateRequest;
import com.example.Immutly.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface IRepositoryService {
    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    String addNewProduct(GetNewProductRequest productRequest);

    Boolean deleteProductById(Long id);

    Boolean updateProduct(Long id, ProductUpdateRequest updateRequest);


}
