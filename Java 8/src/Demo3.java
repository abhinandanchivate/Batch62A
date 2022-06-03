import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo3 {

	public static void main(String[] args) {
		
		List<String> arrayList = Arrays.asList("a","b","c","d","e");
		Function<String, String> function = ( a)->a.toUpperCase();// lowercase to uppercase
		List<String> list = arrayList.stream().map(function).collect(Collectors.toList());
		
		list.forEach(System.out::println);
		list.forEach(System.out::println);
		
		
		
	}
}
