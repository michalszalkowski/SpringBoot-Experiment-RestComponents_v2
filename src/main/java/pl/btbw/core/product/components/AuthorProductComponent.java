package pl.btbw.core.product.components;

import pl.btbw.core.common.output.Component;
import pl.btbw.core.common.output.Mappable;
import pl.btbw.core.product.core.Product;

public class AuthorProductComponent implements Component {

	public Long id;
	public String index;
	public String author;

	@Override
	public void map(Mappable mappable) {

		Product product = (Product) mappable;

		this.id = product.getId();
		this.index = product.getIndex();
		this.author = product.getAuthor();
	}

	@Override
	public String getNameComponent() {
		return "AuthorProductComponent";
	}
}
