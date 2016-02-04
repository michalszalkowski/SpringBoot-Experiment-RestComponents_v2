package pl.btbw.core.product.form;

import pl.btbw.core.common.input.FormComponent;
import pl.btbw.core.common.input.Updatable;
import pl.btbw.core.product.core.Product;

public class InfoFormComponent implements FormComponent {

	private String name;

	public InfoFormComponent(String name) {
		this.name = name;
	}

	@Override
	public void update(Updatable updatable) {
		Product product = (Product) updatable;
		product.setName(name);
	}
}
