package com.example.Immutly.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "immutly")
public class Product {

//    - Product ID (unique iden?fier)
//- Product Name
//- Product Descrip?on
//- Price
//- Availabilitytatus

    @Id
    private Long id;
    private String productName;
    private String productDescription;
    private Double price;
    private Boolean availabilityStatus;


}
