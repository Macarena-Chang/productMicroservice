package ar.com.maca.api.productservice.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import ar.com.maca.api.productservice.models.Product;
import ar.com.maca.api.productservice.repos.ProductRepository;

@RestController
public class ProductRestController {
    
    @Autowired
	private ProductRepository repo;


    @PostMapping("/products")
	public Product create(@RequestBody Product product) {
		return repo.save(product);

	}

    @GetMapping("/allproducts")
	public  List<Product> getAllProducts() {
		return repo.findAll();

	}
}
