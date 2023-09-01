package mspractice;

import java.util.Scanner;

public class AlbumMenu {
	private static AlbumDaoImpl dao;
	static {
	try {
		dao = new AlbumDaoImpl();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	public static void main(String[] args) throws InvalidAlbumException {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Main Menu");
			System.out.println("1- Persist\n2- Find by Title\n3- List\n4- Find by Artist\n5- Find by Genre\n6- Update\n7- Delete");
			System.out.println("Enter Choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				addpersist();
				break;
			case 2:
				findbytitle();
				break;
			case 3:
				list();
				break;
			case 4:
				findbyartist();
				break;
			case 5:
				findbygenre();
				break;
			case 6:
				update();
				break;
			case 7:
				delete();
				break;
			}
		}
		
	}
	private static void list() {
		dao.list().forEach(System.out::println);
	}
	private static void delete() throws InvalidAlbumException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Album to Delete: ");
		String delete = sc.next();
		System.out.println(dao.delete(delete));
	}
	private static void update() {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Update Exixting Albums: ");
		//String update = sc.next();
		//Album a = new Album(update);
		//dao.update(a);
	}
	private static void findbygenre() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Genre: ");
		String genre = sc.next();
		System.out.println(dao.findByGenre(genre));
	}
	private static void findbyartist() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Artist: ");
		String artist = sc.next();
		System.out.println(dao.findByArtist(artist));
	}
	private static void findbytitle() throws InvalidAlbumException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Title: ");
		String title = sc.next();
		System.out.println(dao.findByTitle(title));
	}
	private static void addpersist() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Title: ");
		String title = sc.next();
		System.out.println("Enter Artist: ");
		String artist = sc.next();
		System.out.println("Enter Genre: ");
		String genre = sc.next();
		Album a = new Album(title,artist,genre);
		dao.persits(a);
	}
}
