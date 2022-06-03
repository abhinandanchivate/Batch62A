import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

interface Test extends BiConsumer<Integer, String> {
	
}
class Subject {
	private int subId;
	private String subName;

	public Subject(int subId, String subName) {
		super();
		this.subId = subId;
		this.subName = subName;
	}

	public int getSubId() {
		return subId;
	}

	public String getSubName() {
		return subName;
	}

	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", subName=" + subName + "]";
	}
}

public class StreamDemo {

	public static void main(String[] args) {

		List<Subject> subjects = Arrays.asList(new Subject(1, "Java"), new Subject(2, "Spring"),
				new Subject(3, "Hiberate"));

		// subjectId : key
		// subjectName : value

		Map<Integer, String> map = subjects.stream().filter(Objects::nonNull) // 3 filter
				.collect(Collectors.toMap(Subject::getSubId, Subject::getSubName));

		BiConsumer<Integer, String> biConsumer = (k,v)->System.out.println(k+" "+v);
		System.out.println("biconsumer customized");
		map.forEach(biConsumer);
		map.entrySet().stream().forEach(System.out::println);

		// subjectName : java
//		Subject subject =  subjects.stream() // we rcvd stream object
//		 .filter(e->"Java".equals(e.getSubName())) // filtering the stream based on condition.
//		 .findAny()  //describing some element of the stream, or an empty Optional if the stream is empty.
//		 .orElse(null); // as of now : null
//		 
//		System.out.println(subject);
//		List<Integer> arrayList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//
//		//arrayList.add(new Integer(100));
//		
//		 List<String> list = new ArrayList<>();
//	      list.add("A");
//	      list.add("B");
//	      list.add(null);
//	      list.add("D");
//	      list.add("E");
//	      list.add("A");
//	      list.add("B");
//		
//		//Integer i = null;
//		// to print only non null objects.
//		
//		Set<String> list2 = list.stream()
//				.filter(e->Objects.nonNull(e))
//				.collect(Collectors.toSet());
//		
//		list2.forEach(System.out::println);
//		
//		arrayList.stream().filter(Objects::nonNull).forEach(System.out::println);
//// Method Ref. ==> static methods.
////		Map<String, Integer> map = new HashMap<>();
////		map.put("A", 1);
////		map.put("B", 2);
////		map.put("C", 3);
////		map.put("D", 4);
////		map.put("E", 5);
////		map.put("F", 6);
////
////		// 1st arg will hold key 
////		// 2nd arg will hold value.
////		
////		map.forEach((k, v) -> {
////			if(v%2==0) {
////			System.out.println(k);
////			System.out.println(v);
////			}
////		});
////		
////		// all if conditional criterias should be handled by predicates
////		// y predicate : because they will return either true or false.
////		
////		// how to convert map to stream? 
////		// here e => will hold entry ===> k,v pair
////		// stream will provide entry objects 
////		// e ==> k, v pair
////		map.entrySet().stream().filter(e->e.getValue()%2==0). forEach(e-> {
////			System.out.println(e.getKey());
////			System.out.println(e.getValue());
////		});
////		
	}
}
