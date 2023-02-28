package ar.com.maca.api.productservice.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import ar.com.maca.api.productservice.dto.Coupon;
import ar.com.maca.api.productservice.models.Product;
import ar.com.maca.api.productservice.repos.ProductRepository;

@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository repo;

	@Autowired
	private RestTemplate restTemplate;

	//inject value from properties file
	@Value("${couponService.url}")
	private String couponServiceURL;

	// creates new product in db (first applies coupons to get final price)
	@PostMapping("/products")
	public Product create(@RequestBody Product product) {
		Coupon coupon = restTemplate.getForObject(couponServiceURL + product.getCouponCode(),
				Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount())); // antes calculate final price (original price - discount )
		return repo.save(product);

	}

	@GetMapping("/allproducts")
	public List<Product> getAllProducts() {
		return repo.findAll();

	}
}
