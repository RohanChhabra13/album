import java.util.*;

public class SortedPerson {

	public static void main(String[] args) {
		Comparator<Person> compName = (p1,p2) -> p1.getName().compareTo(p2.getName());//Comparable and comparator are SAM that's why implementing this way
		
		Comparator<Person> compAge = (p1,p2) -> p1.getAge()-p2.getAge();
		
		TreeSet<Person> people = new TreeSet<Person>(compAge);
		
		people.add(new Person("Polo",21));
		people.add(new Person("Jack",25));
		people.add(new Person("Lili",23));
		
		for(Person p: people)System.out.println(p);
	}
}
