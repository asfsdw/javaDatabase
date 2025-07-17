package TH;

import java.util.stream.Stream;

public class THService {
	public static void main(String[] args) {
		THVO vo = new THVO();
		Stream<Object[][]> trump = Stream.of(vo.getTrump());
		
		int deal1 = 0, deal2 = 0;
		deal1 = (int)(Math.random()*vo.getTrump().length);
		deal2 = (int)(Math.random()*vo.getTrump().length);
		System.out.println(deal1+", "+deal2);
		
		Object[][] arr = trump.toArray();
		for(Object array : trump) {
			
		}
	}
	public void HandDeal() {
	}
}
