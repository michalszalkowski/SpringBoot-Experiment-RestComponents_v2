package pl.btbw.core.product.core;

import pl.btbw.core.common.input.FormComponent;
import pl.btbw.core.common.input.Updatable;
import pl.btbw.core.common.output.ComponentProvider;
import pl.btbw.core.common.output.Mappable;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "product")
public class Product implements Mappable, Updatable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column
	private String brand;

	@Column
	private String author;

	@Column
	private String slug;

	@Column(nullable = false)
	private String index;

	@Column(nullable = false)
	private BigDecimal price;

	@Column(columnDefinition = "TEXT")
	private String description;

	public Product() {
	}

	public ComponentProvider componentProvider() {
		return new ComponentProvider(this);
	}

	public void update(FormComponent form) {
		form.update(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
