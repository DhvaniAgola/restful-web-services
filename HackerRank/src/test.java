import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Integer> x = new ArrayList<>();
//		x.add(101);
//		x.add(2);
//		x.add(3);
//		x.add(4);
//		x.add(5);
//		x.add(6);
//		x.add(7);
//		x.add(8);
//		x.add(9);
//		x.add(10);
//		x.add(11);
//		System.out.println(Integer.parseInt(x.get(0).toString(), 2));
//		for (int i = 0; i < x.size(); i++) {
//			System.out.println(Integer.toBinaryString(x.get(i)));
//		}
//
//		System.out.println(~x.get(1));

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(2, 3);
		map.put(3, 4);
		for (int i : map.keySet())
			System.out.println(i + " : " + map.get(i));

		int temp[] = { 1, 2, 3 };
		List<Integer> templst = new ArrayList<>();
		templst = Arrays.stream(temp).boxed().collect(Collectors.toList());
		System.out.println(templst);
	}

}
