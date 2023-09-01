package inventory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import streams.Flight;

public class ProductDao {

	private List<Product> products;

	public ProductDao() throws Exception {

		products = new ArrayList<Product>();
		Stream<String> lines = Files.lines(Paths.get("src/products.txt"));

		
		products = lines.map(line->{
			String[] record = line.split(",");
			return new Product(Integer.parseInt(record[0]),record[1],Double.parseDouble(record[2]));
			}).collect(Collectors.toList());

	}

	public void add(Product p) {

		products.add(p);

	}

	public Product find(int code) {

		return products.stream().filter(p -> p.getCode() == code).findFirst().get();

	}

	public List<Product> list() {

		return products;

	}

	public void delete(int code) {

		products.removeIf(p -> p.getCode() == code);

	}

}
