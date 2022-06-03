import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {

	public static void main(String[] args) {
		
		// list to string separated by comma   // 3 ways // java8 
		List<String> countries = Arrays.asList("Java","Spring","Hibernate","Python","C");
		String s = "Java ,Spring,Hibernate,Python,C";
		
		// 1
		String s2 = String.join(" , ", countries);
		
		String s3= countries.stream().collect(Collectors.joining(","));
		System.out.println(s3);
		
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3));
		
		// hold the common values from 2 AL
		
		List<Integer> result = list1.stream()
				.distinct() // will hold unique values / no duplication.
				.filter(e->list2.contains(e))
				.collect(Collectors.toList());
		
		result.forEach(System.out::println);
				
	}
}
