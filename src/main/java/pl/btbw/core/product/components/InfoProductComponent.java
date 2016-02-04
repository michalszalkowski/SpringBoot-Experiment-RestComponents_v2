package pl.btbw.core.product.components;

import pl.btbw.core.common.output.Component;
import pl.btbw.core.common.output.Mappable;
import pl.btbw.core.product.core.Product;

import java.math.BigDecimal;

public class InfoProductComponent implements Component {

	public Long id;
	public String name;
	public BigDecimal price;


	@Override
	public void map(Mappable mappable) {

		Product product = (Product) mappable;

		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
	}

	@Override
	public String getNameComponent() {
		return "InfoProductComponent";
	}
}
