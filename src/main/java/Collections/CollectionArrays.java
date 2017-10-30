package Collections;


import java.util.*;

public class CollectionArrays {
	public static void main(String[] args) {
		Collection<Integer> collection=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println(collection);
		Integer [] moreItems={6,7,8,9,10};
		
		collection.addAll(Arrays.asList(moreItems));
		System.out.println(collection);
		Collections.addAll(collection, 11,12,13,14,15);
		System.out.println(collection);
		Collections.addAll(collection, moreItems);
		System.out.println(collection);
		List<Integer> list = Arrays.asList(16,17,18,19,20);
		list.set(1, 99);
		System.out.println(list);
		
		
		
	}
}
