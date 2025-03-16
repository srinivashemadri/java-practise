package practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;

class Student{
	String firstName;
	String lastName;
	int age;
	
	public Student(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
}

class CollectionsDemo{
	private <T> void print(ArrayList<T> list) {
		Iterator<T> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	public void iterateListUsingArrayList() {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("Alice");
		arr.add("Bob");
		arr.add("Charlie");
		
		print(arr);
		
	}
	
	public void customSort() {
		ArrayList<Student> list = new ArrayList<>();
		
		list.add(new Student("srini", "hemadri", 24));
		list.add(new Student("preetham", "hemadri", 23));
		list.add(new Student("meghana", "gajji", 21));
		
		Collections.sort(list, Comparator.comparing(student -> student.lastName));
		
		list.forEach(student-> {
			System.out.println(student.firstName);
			System.out.println(student.lastName);
			System.out.println(student.age);
		});
		
		print(list);
	}
	
	public void frequencyOfANumber() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(20);
		list.add(20);
		list.add(30);
	
		
		System.out.println("frequencyOf10: " + Collections.frequency(list, 10));
		System.out.println("frequencyOf20: " + Collections.frequency(list, 20));
		System.out.println("frequencyOf30: " + Collections.frequency(list, 30));
		System.out.println("frequencyOf40: " + Collections.frequency(list, 40));
	}
	
	public void cloningAnArrayList() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(20);
		list.add(20);
		list.add(30);
		
		ArrayList<Integer> clonedList = (ArrayList<Integer>)list.clone();
		
		print(clonedList);
		
	}
}

class HashSetDemo{
	public void unionOfTwoSets() {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		
		HashSet<Integer> set2 = new HashSet<>();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set2.add(6);
		
		set1.addAll(set2);
		
		set1.forEach(num -> {
			System.out.print(num + " ");
		});
	}
	
	public void intersectionOfTwoSets() {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		
		HashSet<Integer> set2 = new HashSet<>();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set2.add(6);
		
		set2.retainAll(set1); // equivalent to set1.retainAll(set2);
		
		set2.forEach(num -> {
			System.out.print(num + " ");
		});
	}
	
	public void differenceBetweenTwoSets() {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		
		HashSet<Integer> set2 = new HashSet<>();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		set2.add(6);
		
		set1.removeAll(set2);
		
		set1.forEach(num -> {
			System.out.print(num + " ");
		});
	}
	
	public void cloneAHashSet() {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		
		HashSet<Integer> set2 = (HashSet<Integer>) set1.clone();
		
		set2.forEach(num -> {
			System.out.print(num + " ");
		});
	}
	
	public void convertHashSetToArrayList() {
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		ArrayList<Integer> list = new ArrayList<>(set);
		
		list.forEach(num -> {
			System.out.print(num + " ");
		});
	}
}

class HashMapDemo{
	public void mergeTwoHashMaps() {
		HashMap<Integer, String> map1 = new HashMap<>();
		map1.put(1, "hemadri");
		map1.put(2, "sai");
		map1.put(3, "srinivas");
		map1.put(4, "preetham");
		
		HashMap<Integer, String> map2 = new HashMap<>();
		map2.put(5, "gajji"); // if we put key as 1 hemadri will be overriden by gajji
		map2.put(6, "meghana");
		
		map1.putAll(map2);
		
		map1.forEach((key, val) -> {
			System.out.println(key + " : "+ val);
		});
	}
	
	public void findValueWithDefault() {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "hemadri");
		map.put(2, "sai");
		map.put(3, "srinivas");
		map.put(4, "preetham");
		
		System.out.println(map.getOrDefault(1, "gajji"));
		System.out.println(map.getOrDefault(5, "gajji"));
	}
	
	public void sortBasedOnKeys() {
		HashMap<String, String> map = new HashMap<>();
		map.put("d", "hemadri");
		map.put("b", "sai");
		map.put("a", "srinivas");
		map.put("c", "preetham");
		
		map.forEach((key, val ) ->{
			System.out.println(key + " : "+ val);
		});
		
		TreeMap<String, String> treeMap = new TreeMap<>(map);
		
		System.out.println("After creating tree map");
		
		treeMap.forEach((key, val ) ->{
			System.out.println(key + " : "+ val);
		});
	}
	
	public void handlingNullValues() {
		HashMap<Integer, String> table = new HashMap<>();
		table.put(1, "possible");
		try {
			table.put(null, "possible");
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			table.forEach((key, value)->{
				System.out.println(key +" : "+ value);
			});
		}
	}
}

class HashTableDemo{
	public void hashTableSync() {
		Hashtable<Integer, String> table = new Hashtable<>();
		
		Runnable writer = () -> {
			for(int i=0;i<10;i++) {
				table.put(i, String.valueOf(i+100));
				System.out.println(Thread.currentThread().getName() + " inserted key: " + i);
			}
		};
		
		Thread t1 = new Thread(writer);
		Thread t2 = new Thread(writer);
		
		t1.start();
		t2.start();
	}
	
	public void handlingNullValues() {
		Hashtable<Integer, String> table = new Hashtable<>();
		table.put(1, "possible");
		try {
			table.put(null, "Impossible");
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			table.forEach((key, value)->{
				System.out.println(key +" : "+ value);
			});
		}
	}
}

class PerformanceTestBetweenHashTableAndHashMap{
	public void testPerformanceofHashMap() {
		HashMap<Integer, String> map = new HashMap<>();
		
		long start = System.nanoTime();
		for(int i=0;i<100;i++) {
			map.put(i, String.valueOf(i+100));
		}
		
		long end = System.nanoTime();
		
		System.out.println("Time diff: " + (end-start));
	}
	
	public void testPerformanceofHashTable() {
		Hashtable<Integer, String> map = new Hashtable<>();
		
		long start = System.nanoTime();
		for(int i=0;i<100;i++) {
			map.put(i, String.valueOf(i+100));
		}
		
		long end = System.nanoTime();
		
		System.out.println("Time diff: " + (end-start));
	}
	
	public void concurrentReadWriteForHashMap () {
		
		try {
			HashMap<Integer, String> map = new HashMap<>();
			
			for(int i=0;i<5;i++) {
				map.put(i, String.valueOf(i+100));
			}
			
			map.forEach((key, val) -> {
				if(key == 2) {
					map.put(6, String.valueOf(106));
				}
			});
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public void concurrentReadWriteForHashTable () {
		
		try {
			Hashtable<Integer, String> map = new Hashtable<>();
			
			for(int i=0;i<5;i++) {
				map.put(i, String.valueOf(i+100));
			}
			
			map.forEach((key, val) -> {
				if(key == 2) {
					map.put(6, String.valueOf(106));
				}
			});
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
	
	
}

public class Practise {

	public static void main(String[] args) {
		
		//CollectionsDemo demo = new CollectionsDemo();
		//HashSetDemo demo = new HashSetDemo();
		//HashMapDemo demo = new HashMapDemo();
		//HashTableDemo demo = new HashTableDemo();
		PerformanceTestBetweenHashTableAndHashMap demo = new PerformanceTestBetweenHashTableAndHashMap();
		
		demo.concurrentReadWriteForHashTable();

	}

}
