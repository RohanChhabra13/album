package flightt;

import java.io.IOException;
import java.util.Scanner;

public class FlightMenu {

	private static FlightDao dao;
	static {
		try {
			dao = new FlightDao();
		} catch (IOException e) {
			e.printStackTrace();;
		}
	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		while (true) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("\nMain Menu");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("\n-> 1. Add Flight\n-> 2. Find Flight \n-> 3. List All Flights \n-> 4. Delete Flight \n-> 5. Exit Menu");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("\nEnter Choice: ");
			System.out.println("--------------------------------------------------------------------");

			int choice = console.nextInt();
			switch (choice) {
			case 1:
				addFlight();
				break;

			case 2:
				findFlight();
				break;

			case 3:
				listFlight();
				break;

			case 4:
				deleteFlight();
				break;

			case 5:
				System.exit(0);

			default:
				System.out.println("--------------------------------------------------------------------");
				System.out.println("\nEnter the Invalid Choice! Enter Again.");
				System.out.println("--------------------------------------------------------------------");
				break;
			}

		}
	}

	private static void addFlight() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n You have chosen Option 1.");
		System.out.println("--------------------------------------------------------------------");
		Scanner console = new Scanner(System.in);
		System.out.println("\n Enter Flight Code-");
		int code = console.nextInt();
		System.out.println("\n Enter Flight Carrier-");
		String carrier = console.next();
		System.out.println("\n Enter Flight Source-");
		String source = console.next();
		System.out.println("\n Enter Flight Destination-");
		String destination = console.next();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n Flight Data added Successfully-");
		System.out.println("--------------------------------------------------------------------");
		
		dao.add(new Flight(code,carrier,source,destination));
		
	}

	private static void findFlight() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n You have chosen Option 2.");
		System.out.println("--------------------------------------------------------------------");
		while(true) {
		Scanner console = new Scanner(System.in);
		System.out.println("\nFind Menu");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n-> 1. Find by Code\n-> 2. Find by Carrier \n-> 3. Find by Source and Destination \n-> 4. Exit Find Menu");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\nEnter Choice: ");
		System.out.println("--------------------------------------------------------------------");
		int choice = console.nextInt();
		switch (choice) {
		case 1:
			findByCode();
			break;

		case 2:
			findByCarrier();
			break;

		case 3:
			findBySD();
			break;

		case 4:
			main(null);
		default:
			System.out.println("\nEnter the Invalid Choice! Enter Again.");
			System.out.println("--------------------------------------------------------------------");
			break;
		}

		}
	}

	private static void findBySD() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n You have chosen Find by Source and Destination.\n");
		Scanner console = new Scanner(System.in);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\nEnter Source: ");
		String source = console.next();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\nEnter Destination: ");
		String destination = console.next();
		System.out.println("--------------------------------------------------------------------");
		System.out.println(dao.find(source,destination));
		System.out.println("--------------------------------------------------------------------");
	}

	private static void findByCarrier() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n You have chosen Find By Carrier.\n");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\nEnter Carrier: ");
		System.out.println("--------------------------------------------------------------------");
		Scanner console = new Scanner(System.in);
		String carrier = console.next();
		System.out.println("--------------------------------------------------------------------");
		System.out.println(dao.find(carrier));
		System.out.println("--------------------------------------------------------------------");
	}

	private static void findByCode() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n You have chosen Find By Code.\n");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\nEnter Code: ");
		System.out.println("--------------------------------------------------------------------");
		Scanner console = new Scanner(System.in);
		int code = console.nextInt();
		System.out.println("--------------------------------------------------------------------");
		System.out.println(dao.find(code));
		System.out.println("--------------------------------------------------------------------");
		
	}

	private static void listFlight() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n You have chosen Option 3.\n");
		System.out.println("--------------------------------------------------------------------");
		System.out.println(dao.list());
		System.out.println("--------------------------------------------------------------------");
	}

	private static void deleteFlight() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n You have chosen Option 4.");
		System.out.println("--------------------------------------------------------------------");
		while(true) {
			Scanner console = new Scanner(System.in);
			System.out.println("--------------------------------------------------------------------");
			System.out.println("\nDelete Menu");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("\n-> 1. Delete by Code\n-> 2. Delete by Carrier \n-> 3. Delete by Source and Destination \n-> 4. Exit Delete Menu");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("\nEnter Choice: ");
			System.out.println("--------------------------------------------------------------------");
			int choice = console.nextInt();
			switch (choice) {
			case 1:
				deleteByCode();
				break;

			case 2:
				deleteByCarrier();
				break;

			case 3:
				deleteBySD();
				break;

			case 4:
				main(null);
			default:
				System.out.println("--------------------------------------------------------------------");
				System.out.println("\nEnter the Invalid Choice! Enter Again.");
				System.out.println("--------------------------------------------------------------------");
				break;
			}

			}

	}
	private static void deleteBySD() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n You have chosen Delete by Source and Destination.\n");
		System.out.println("--------------------------------------------------------------------");
		Scanner console = new Scanner(System.in);
		System.out.println("\nEnter Source: ");
		String source = console.next();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\nEnter Destination: ");
		String destination = console.next();
		System.out.println("--------------------------------------------------------------------");
		dao.del(source,destination);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n Flight Deleted Successfully!");
		System.out.println("--------------------------------------------------------------------");
	}

	private static void deleteByCarrier() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n You have chosen Delete By Carrier.\n");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\nEnter Choice: ");
		System.out.println("--------------------------------------------------------------------");
		Scanner console = new Scanner(System.in);
		String carrier = console.next();
		dao.del(carrier);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n Flight Deleted Successfully!");
		System.out.println("--------------------------------------------------------------------");
	}

	private static void deleteByCode() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\n You have chosen Delete By Code.\n");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\nEnter Choice: ");
		System.out.println("--------------------------------------------------------------------");
		Scanner console = new Scanner(System.in);
		int code = console.nextInt();
		dao.del(code);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n Flight Deleted Successfully!");
		System.out.println("--------------------------------------------------------------------");
		
	}
	
}
