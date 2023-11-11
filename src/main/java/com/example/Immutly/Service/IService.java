package com.example.Immutly.Service;

import com.example.Immutly.Dto.GetNewProductRequest;
import com.example.Immutly.Dto.ProductUpdateRequest;
import com.example.Immutly.Entity.Product;

import java.util.List;

public interface IService {
    List<Product> getAllProducts();
    Product getProductById(Long id);

    String addNewProduct(GetNewProductRequest productRequest);

    Boolean deleteProductById(Long id);

    Boolean updateProduct(Long id, ProductUpdateRequest updateRequest);
}
