package com.example.ecommerce.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
    //create
    /*public Product createProductOnly(Product product) {
        return productRepository.save(product);
    }*/
	
	
	//** - start -- handle relation
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private TagService tagService;

	//Create
	//Add a parameter categoryId
	public Product createProduct(Product product, Long categoryId, List<Long> tagIds) {
	    product.setCategory(categoryService.get(categoryId));
	    product.setTags(Set.copyOf(tagService.getByIds(tagIds)));
	    return productRepository.save(product);
	}
	//** - end -- handle relation

    //read
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //read by id
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    //update
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);
        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());
        existing.setQuantity(updatedProduct.getQuantity());
        return productRepository.save(existing);
    }

    //delete
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }
    
    
    
}
