import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> x = new ArrayList<>();
		x.add(101);
		x.add(2);
		x.add(3);
		x.add(4);
		x.add(5);
		x.add(6);
		x.add(7);
		x.add(8);
		x.add(9);
		x.add(10);
		x.add(11);
		System.out.println(Integer.parseInt(x.get(0).toString(), 2));
		for (int i = 0; i < x.size(); i++) {
			System.out.println(Integer.toBinaryString(x.get(i)));
		}
	}

}
