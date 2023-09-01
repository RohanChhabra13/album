package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreamDemo {

	public static void main(String[] args) {

		Map<String, String> people = new HashMap<>();
		people.put("Polo", "Pune");
		people.put("Mili", "Mumbai");
		people.put("Deny", "Delhi");

		people.values().stream().forEach(System.out::println);

		List<String> cities = people.values().stream().map(c -> c.toUpperCase()).sorted().collect(Collectors.toList());
		cities.forEach(System.out::println);

		people.keySet().stream().forEach(System.out::println);

		List<String> people1 = people.keySet().stream().map(c -> c.toUpperCase()).sorted().collect(Collectors.toList());
		people1.forEach(System.out::println);

		Map<String, List<String>> contacts = new HashMap<>();
		contacts.put("Frudo", Arrays.asList("1", "11"));
		contacts.put("Sean", Arrays.asList("2", "22", "222"));
		contacts.put("Ben", Arrays.asList("38", "33"));

		contacts.values().stream().flatMap(Collection::stream).forEach(System.out::println);
		System.out.println("-- Lucky numbers");
		List<String> lucky = contacts.values().stream().flatMap(Collection::stream).filter(c -> c.contains("8"))
				.collect(Collectors.toList());
		lucky.forEach(System.out::println);
	}

}
