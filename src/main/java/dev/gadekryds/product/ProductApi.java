package dev.gadekryds.product;

import dev.gadekryds.common.Bus;
import dev.gadekryds.product.dto.CreateProductCommand;
import dev.gadekryds.product.dto.ProductResponse;
import dev.gadekryds.product.dto.ProductSlimResponse;
import dev.gadekryds.product.features.createProduct.ProductCreatedEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/products")
public class ProductApi {

    private final Bus bus;

    public ProductApi(Bus bus) {
        this.bus = bus;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductSlimResponse>> getProducts() {

        var response = bus.request(new CreateProductCommand("title", "test"));

        return response.hasException() ?
                ResponseEntity.internalServerError().build()
                : ResponseEntity.ok(
                        List.of(new ProductSlimResponse(
                                response.data.getId(),
                                response.data.getName()
                        )));

    }

    @GetMapping("/{id:uuid")
    public ResponseEntity<ProductResponse> getProduct(UUID id) {



        return ResponseEntity.ok(
                new ProductResponse(id, "test")
        );
    }

    @PostMapping("/")
    public ResponseEntity createProduct(@RequestBody CreateProductCommand req) throws Exception {

        var response = bus.request(new CreateProductCommand(req.title(), req.description()));

        if(response.hasException()) {
            throw response.exception;
        }
        return ResponseEntity.created(new URI("/products/%s".formatted(response.data.getId()))).build();
    }
}
