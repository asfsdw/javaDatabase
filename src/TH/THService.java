package TH;

import java.util.ArrayList;
import java.util.List;

public class THService {
	private THVO plHand1, plHand2;
	private THVO cpu1Hand1, cpu1Hand2;
	private THVO cpu2Hand1, cpu2Hand2;
	private THVO cpu3Hand1, cpu3Hand2;
	private THVO field1, field2, field3, field4, field5;
	
	private List<THVO> deck = new ArrayList<THVO>();
	
	public THService() {
		initDeck();
	}
	
	private void initDeck() {
		deck.add(new THVO(1.0, "/TH/images/c9.jpg"));
		deck.add(new THVO(1.1, "/TH/images/h9.jpg"));
		deck.add(new THVO(1.2, "/TH/images/d9.jpg"));
		deck.add(new THVO(1.3, "/TH/images/s9.jpg"));
		deck.add(new THVO(2.0, "/TH/images/c10.jpg"));
		deck.add(new THVO(2.1, "/TH/images/h10.jpg"));
		deck.add(new THVO(2.2, "/TH/images/d10.jpg"));
		deck.add(new THVO(2.3, "/TH/images/s10.jpg"));
		deck.add(new THVO(3.0, "/TH/images/c11.jpg"));
		deck.add(new THVO(3.1, "/TH/images/h11.jpg"));
		deck.add(new THVO(3.2, "/TH/images/d11.jpg"));
		deck.add(new THVO(3.3, "/TH/images/s11.jpg"));
		deck.add(new THVO(4.0, "/TH/images/c12.jpg"));
		deck.add(new THVO(4.1, "/TH/images/h12.jpg"));
		deck.add(new THVO(4.2, "/TH/images/d12.jpg"));
		deck.add(new THVO(4.3, "/TH/images/s12.jpg"));
		deck.add(new THVO(5.0, "/TH/images/c13.jpg"));
		deck.add(new THVO(5.1, "/TH/images/h13.jpg"));
		deck.add(new THVO(5.2, "/TH/images/d13.jpg"));
		deck.add(new THVO(5.3, "/TH/images/s13.jpg"));
		deck.add(new THVO(6.0, "/TH/images/c14.jpg"));
		deck.add(new THVO(6.1, "/TH/images/h14.jpg"));
		deck.add(new THVO(6.2, "/TH/images/d14.jpg"));
		deck.add(new THVO(6.3, "/TH/images/s14.jpg"));
	}
	
	public THVO dealCard() {
		int idx = (int)(Math.random()*deck.size());
		return deck.remove(idx);
	}
	
	public void cardDealStart() {
		plHand1 = dealCard();
		cpu1Hand1 = dealCard();
		cpu2Hand1 = dealCard();
		cpu3Hand1 = dealCard();
		plHand2 = dealCard();
		cpu1Hand2 = dealCard();
		cpu2Hand2 = dealCard();
		cpu3Hand2 = dealCard();
		field1 = dealCard();
		field2 = dealCard();
		field3 = dealCard();
		field4 = dealCard();
		field5 = dealCard();
	}

	public THVO getPlHand1() {
		return plHand1;
	}
	public THVO getPlHand2() {
		return plHand2;
	}
	public THVO getCpu1Hand1() {
		return cpu1Hand1;
	}
	public THVO getCpu1Hand2() {
		return cpu1Hand2;
	}
	public THVO getCpu2Hand1() {
		return cpu2Hand1;
	}
	public THVO getCpu2Hand2() {
		return cpu2Hand2;
	}
	public THVO getCpu3Hand1() {
		return cpu3Hand1;
	}
	public THVO getCpu3Hand2() {
		return cpu3Hand2;
	}
	public THVO getField1() {
		return field1;
	}
	public THVO getField2() {
		return field2;
	}
	public THVO getField3() {
		return field3;
	}
	public THVO getField4() {
		return field4;
	}
	public THVO getField5() {
		return field5;
	}
	public List<THVO> getDeck() {
		return deck;
	}
}
