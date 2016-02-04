package pl.btbw.core.product.components;

import pl.btbw.core.common.output.Component;
import pl.btbw.core.common.output.Mappable;
import pl.btbw.core.product.core.Product;

public class BrandProductComponent implements Component {

	public Long id;
	public String slug;
	public String brand;
	public String description;

	@Override
	public void map(Mappable mappable) {

		Product product = (Product) mappable;

		this.id = product.getId();
		this.slug = product.getSlug();
		this.brand = product.getBrand();
		this.description = product.getDescription();
	}

	@Override
	public String getNameComponent() {
		return "BrandProductComponent";
	}
}
