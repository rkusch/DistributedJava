package adventureworks.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {
	private final List<Product> contents = new ArrayList<>();

	public List<Product> getContents() {
		return contents;
	}

	public int getItemsInCart() {
		return contents.size();
	}

	public void add(Product name) {
		contents.add(name);
	}

	public void remove(Product name) {
		contents.remove(name);
	}

	public void removeAll() {
		contents.clear();
	}

}
