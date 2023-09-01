import java.util.HashMap;
import java.util.Iterator;

public class MapDemo {
public static void main(String[] args) {
	HashMap<String, String> map = new HashMap<>();
	map.put("scott", "tiger");
	map.put("jack","jill");
	map.put("polo", "lili");
	map.put("jack", "rose");
	
	System.out.println("Scott: "+map.get("scott"));
	System.out.println("Polo: "+map.get("polo"));
	System.out.println("Jack: "+map.get("jack"));
	
	//Print all the keys and values without manually feeding keys
	map.forEach((key, value) -> System.out.println(key + ":" + value));
	
}
}
