package inventory;

import java.util.Scanner;

public class ProductMenu {

	private static ProductJdbcDao dao;

	static {

		try {
			dao = new ProductJdbcDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);

		while (true) {

			System.out.println("Main Menu");

			System.out.println("1- Add Product\n2- Find Product\n3- List Product\n4- Delete Product\n5- Exit");

			System.out.println("Enter Choice");

			int choice = console.nextInt();

			switch (choice) {

			case 1:
				addProduct();
				break;

			case 2:
				findProduct();
				break;

			case 3:
				listProduct();
				break;

			case 4:
				delProduct();
				break;

			case 5:
				System.exit(0);

			default:
				System.out.println("Invalid option");

			}

		}

	}

	private static void addProduct() {

		Scanner console = new Scanner(System.in);

		System.out.println("Enter Product Code: ");

		int code = console.nextInt();

		System.out.println("Enter Product Name: ");

		String name = console.next();

		System.out.println("Enter Product Price: ");

		double price = console.nextDouble();

		Product p = new Product(code, name, price);

		dao.add(p);

	}

	private static void findProduct() {

		Scanner console = new Scanner(System.in);

		System.out.println("Enter Product Code: ");

		int code = console.nextInt();

		System.out.println(dao.find(code));

		// console.close();

	}

	private static void listProduct() {

		dao.list().forEach(System.out::println);

	}

	private static void delProduct() {

		Scanner console = new Scanner(System.in);

		System.out.print("Enter Product Code: ");

		int code = console.nextInt();

		dao.delete(code);

		// console.close();

	}
}
