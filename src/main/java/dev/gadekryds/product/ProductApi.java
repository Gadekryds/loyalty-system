package dev.gadekryds.product;

import dev.gadekryds.product.dto.CreateProductCommand;
import dev.gadekryds.product.dto.ProductResponse;
import dev.gadekryds.product.dto.ProductSlimResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("/products")
public class ProductApi {

    @GetMapping("/")
    public ResponseEntity<List<ProductSlimResponse>> getProducts() {


        return ResponseEntity.ok(List.of(
                new ProductSlimResponse(
                        UUID.randomUUID(),
                        "test"))
        );
    }

    @GetMapping("/{id:uuid")
    public ResponseEntity<ProductResponse> getProduct(UUID id) {



        return ResponseEntity.ok(
                new ProductResponse(id, "test")
        );
    }

    @PostMapping("/")
    public ResponseEntity createProduct(@RequestBody CreateProductCommand req) {



        return ResponseEntity.created("/products/{}".formatted())
    }
}
