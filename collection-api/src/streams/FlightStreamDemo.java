package streams;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightStreamDemo {
	public static void main(String[] args) throws Exception {
		List<Flight> flights = null;
		Stream<String> lines = Files.lines(Paths.get("src/flights.txt"));

	flights = lines.map(line->{
		
	String[] record = line.split(",");
	return new Flight(Integer.parseInt(record[0]),record[1],record[2],record[3]);
	}).collect(Collectors.toList());
	
	flights.forEach(System.out::println);
//	
//	// Print details of flight no 123
//	System.out.println("blan=h------------------------------------------------");
//	flights = lines.filter(c->c.contains("123")).map(line->{
//		String[] record = line.split(",");
//		return new Flight(Integer.parseInt(record[0]),record[1],record[2],record[3]);
//		}).collect(Collectors.toList());
//		
//		flights.forEach(System.out::println);
//		
//	// Print all flights by Jet carrier
//		System.out.println("blan=h------------------------------------------------");
//		flights = lines.filter(c->c.contains("Jet")).map(line->{
//			String[] record = line.split(",");
//			return new Flight(Integer.parseInt(record[0]),record[1],record[2],record[3]);
//			}).collect(Collectors.toList());
//			
//			flights.forEach(System.out::println);
//	
		// Print all flights by Jet carrier
//		System.out.println("blan=h------------------------------------------------");
//		flights = lines.filter(c -> c.contains("Pune,Delhi")).map(line -> {
//			String[] record = line.split(",");
//			return new Flight(Integer.parseInt(record[0]), record[1], record[2], record[3]);
//		}).collect(Collectors.toList());
//
//		flights.forEach(System.out::println);

		/*
		 * Sir's logic
		 * 
		 * print details of flight no123b
		 * System.out.println(flights.stream().filter(f->f.getCode()=="123").findFirst()
		 * .get()); print details of Jet carrier
		 * flights.stream().filter(f->f.getCarrier()=="Jet").forEach(System.out::println
		 * )); print details of Source and destination flights.stream().filter(f->
		 * f.getSource()=="Delhi"&&
		 * getDestination()=="Pune").forEach(System.out::println);
		 * 
		 */

		System.out.println("Deleting a flight by getCode()------------");
		flights.removeIf(f->f.getCode()==123);
		
	}}