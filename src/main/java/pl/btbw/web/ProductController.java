package pl.btbw.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.btbw.core.common.output.Component;
import pl.btbw.core.util.Link;
import pl.btbw.core.product.components.AuthorProductComponent;
import pl.btbw.core.product.components.BrandProductComponent;
import pl.btbw.core.product.components.InfoProductComponent;
import pl.btbw.core.product.core.Product;
import pl.btbw.core.product.core.ProductRepository;
import pl.btbw.core.product.form.InfoFormComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	// temporary solution
	@RequestMapping(value = {"/component/product"})
	public List<Link> links() {
		List<Link> links = new ArrayList<>();
		links.add(new Link("http://localhost:8095/component/product/1/author"));
		links.add(new Link("http://localhost:8095/component/product/1/brand"));
		links.add(new Link("http://localhost:8095/component/product/1/info"));
		links.add(new Link("http://localhost:8095/component/product/1/all/LIST"));
		links.add(new Link("http://localhost:8095/component/product/1/all/MAP"));

		links.add(new Link("http://localhost:8095/component/products/ITEM"));
		links.add(new Link("http://localhost:8095/component/products/LIST"));
		links.add(new Link("http://localhost:8095/component/products/MAP"));
		return links;
	}

	@RequestMapping(value = {"/component/product/{id}/author"})
	public Component componentAuthor(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.add(new AuthorProductComponent())
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/{id}/brand"})
	public Component componentBrand(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.add(new BrandProductComponent())
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/{id}/info"})
	public Component componentInfo(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.add(new InfoProductComponent())
				.buildOne();
	}

	@RequestMapping(value = {"/component/product/{id}/all/LIST"})
	public List<Component> componentAll(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.add(new BrandProductComponent())
				.add(new InfoProductComponent())
				.add(new AuthorProductComponent())
				.buildList();
	}

	@RequestMapping(value = {"/component/product/{id}/all/MAP"})
	public Map<String, Component> componentAllMap(@PathVariable("id") long id) {
		return productRepository.getOne(id)
				.componentProvider()
				.add(new BrandProductComponent())
				.add(new InfoProductComponent())
				.add(new AuthorProductComponent())
				.buildMap();
	}

	@RequestMapping(value = {"/component/products/ITEM"})
	public List<Component> componentsItem() {
		return productRepository.findAll()
				.stream()
				.map(product -> product
						.componentProvider()
						.add(new InfoProductComponent())
						.buildOne())
				.collect(Collectors.toList());
	}

	@RequestMapping(value = {"/component/products/LIST"})
	public List<List<Component>> componentsList() {
		return productRepository.findAll()
				.stream()
				.map(product -> product
						.componentProvider()
						.add(new BrandProductComponent())
						.add(new InfoProductComponent())
						.add(new AuthorProductComponent())
						.buildList())
				.collect(Collectors.toList());
	}

	@RequestMapping(value = {"/component/products/MAP"})
	public Set<Map<String, Component>> componentsMap() {
		return productRepository.findAll()
				.stream()
				.map(product -> product
						.componentProvider()
						.add(new BrandProductComponent())
						.add(new InfoProductComponent())
						.add(new AuthorProductComponent())
						.buildMap())
				.collect(Collectors.toSet());
	}

	@RequestMapping(value = {"/update"})
	public String updateTest() {
		Product product = productRepository.getOne(1L);
		product.update(new InfoFormComponent("test"));
		productRepository.saveAndFlush(product);
		return "ok";
	}

}
