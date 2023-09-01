package flightt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightDao {
	private List<Flight> flights;
	public FlightDao() throws IOException {
		Stream<String> lines = Files.lines(Paths.get("src/flights.txt"));
		
		flights = lines.map(line->{
			String[] record = line.split(",");
			return new Flight(Integer.parseInt(record[0]), record[1], record[2], record[3]);
		}).collect(Collectors.toList());
	}
	
	public void add(Flight f) {
		flights.add(f);
	}
	
	public List<Flight> list(){
		return flights;
	}
	
	public Flight find(int code) {
		return flights.stream().filter(f->f.getCode()==code).findFirst().get();
	}

	public Flight find(String carrier) {
		return flights.stream().filter(f->f.getCarrier()==carrier).findFirst().get();
	}

	public Flight find(String source, String destination) {
		return flights.stream().filter(f->f.getSource()==source&&f.getDestination()==destination).findFirst().get();
	}

	public void del(int code) {
		flights.removeIf(f->f.getCode()==code);
	}
	public void del(String carrier) {
		flights.removeIf(f->f.getCarrier()==carrier);
	}
	public void del(String source, String destination) {
		flights.removeIf(f->f.getSource()==source&&f.getDestination()==destination);
	}

}
