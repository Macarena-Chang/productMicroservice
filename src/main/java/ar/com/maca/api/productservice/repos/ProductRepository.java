package ar.com.maca.api.productservice.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.maca.api.productservice.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
