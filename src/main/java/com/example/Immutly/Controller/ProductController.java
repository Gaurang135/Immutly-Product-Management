package com.example.Immutly.Controller;

import com.example.Immutly.Dto.GetNewProductRequest;
import com.example.Immutly.Dto.ProductUpdateRequest;
import com.example.Immutly.Entity.Product;
import com.example.Immutly.Service.IService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IService service;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allProducts = service.getAllProducts();
        if(!allProducts.isEmpty()) {
            return new ResponseEntity<>(allProducts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = service.getProductById(id);
        if (product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/")
    public ResponseEntity<String> addNewProduct(@RequestBody @Valid GetNewProductRequest productRequest){
        String id = service.addNewProduct(productRequest);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductById(@PathVariable Long id){
        Boolean status = service.deleteProductById(id);
        if(status){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody @Valid ProductUpdateRequest updateRequest) {
        Boolean status = service.updateProduct(id,updateRequest);
        if(status){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
