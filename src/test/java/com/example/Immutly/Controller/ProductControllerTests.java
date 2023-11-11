package com.example.Immutly.Controller;

import com.example.Immutly.Dto.GetNewProductRequest;
import com.example.Immutly.Dto.ProductUpdateRequest;
import com.example.Immutly.Entity.Product;
import com.example.Immutly.Service.IService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration")
@WithMockUser(username = "yash", password = "root")
public class ProductControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IService productService;

    @Test
    public void getAllProducts_ReturnsProducts_WhenProductsExist() throws Exception {
        when(productService.getAllProducts()).thenReturn(Arrays.asList(new Product(), new Product()));

        mockMvc.perform(get("/products/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void getAllProducts_ReturnsNoContent_WhenNoProductsExist() throws Exception {
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/products/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getProductById_ReturnsProduct_WhenProductExists() throws Exception {
        when(productService.getProductById(anyLong())).thenReturn(new Product());

        mockMvc.perform(get("/products/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getProductById_ReturnsNoContent_WhenProductDoesNotExist() throws Exception {
        when(productService.getProductById(anyLong())).thenReturn(null);

        mockMvc.perform(get("/products/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void addNewProduct_ReturnsOk_WhenProductAddedSuccessfully() throws Exception {
        when(productService.addNewProduct(any(GetNewProductRequest.class))).thenReturn("1");

        mockMvc.perform(post("/products/")
                        .content("{    \"productName\" : \"Lamp\",\n" +
                                "    \"productDescription\" : \"Luminates surroundings\",\n" +
                                "    \"price\" : 101,\n" +
                                "    \"availabilityStatus\" : true}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void deleteProductById_ReturnsOk_WhenProductDeletedSuccessfully() throws Exception {
        when(productService.deleteProductById(anyLong())).thenReturn(true);

        mockMvc.perform(delete("/products/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteProductById_ReturnsBadRequest_WhenProductDeletionFails() throws Exception {
        when(productService.deleteProductById(anyLong())).thenReturn(false);

        mockMvc.perform(delete("/products/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updateProduct_ReturnsOk_WhenProductUpdatedSuccessfully() throws Exception {
        when(productService.updateProduct(anyLong(), any(ProductUpdateRequest.class))).thenReturn(true);

        mockMvc.perform(put("/products/{id}", 1L)
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateProduct_ReturnsBadRequest_WhenProductUpdateFails() throws Exception {
        when(productService.updateProduct(anyLong(), any(ProductUpdateRequest.class))).thenReturn(false);

        mockMvc.perform(put("/products/{id}", 1L)
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
