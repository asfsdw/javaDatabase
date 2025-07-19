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
		deck.add(new THVO(1.0, "/TH/images/c09.jpg"));
		deck.add(new THVO(1.1, "/TH/images/h09.jpg"));
		deck.add(new THVO(1.2, "/TH/images/d09.jpg"));
		deck.add(new THVO(1.3, "/TH/images/s09.jpg"));
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
		deck.removeAll(deck);
		initDeck();
	}
	
	public double handRank(double hand1, double hand2, double field1, double field2, double field3, double field4, double field5) {
		int cnt1 = 0, cnt2 = 0, cnt3 = 0,cnt4 = 0,cnt5 = 0,cnt6 = 0,
				sCnt1 = 0,sCnt2 = 0,sCnt3 = 0,sCnt4 = 0,
				pair = 0;
		double resNum = 0.0, resSuit = 0.0, res = 0.0,
				maxN = 0.0;
		boolean run = true;
		String num1 = "",num2 = "",num3 = "",num4 = "",num5 = "",num6 = "",num7 = "";
		String suit1 = "",suit2 = "",suit3 = "",suit4 = "",suit5 = "",suit6 = "",suit7 = "";
		
		num1 = String.valueOf(hand1).substring(0,1);
		num2 = String.valueOf(hand2).substring(0,1);
		num3 = String.valueOf(field1).substring(0,1);
		num4 = String.valueOf(field2).substring(0,1);
		num5 = String.valueOf(field3).substring(0,1);
		num6 = String.valueOf(field4).substring(0,1);
		num7 = String.valueOf(field5).substring(0,1);
		String[] num = {num1,num2,num3,num4,num5,num6,num7};
		int[] intNum = new int[num.length];
		
		suit1 = String.valueOf(hand1).substring(2);
		suit2 = String.valueOf(hand2).substring(2);
		suit3 = String.valueOf(field1).substring(2);
		suit4 = String.valueOf(field2).substring(2);
		suit5 = String.valueOf(field3).substring(2);
		suit6 = String.valueOf(field4).substring(2);
		suit7 = String.valueOf(field5).substring(2);
		String[] suit = {suit1,suit2,suit3,suit4,suit5,suit6,suit7};
		
		for(int i=0; i<num.length; i++) {
			if(num[i].equals("1")) cnt1++;
			if(num[i].equals("2")) cnt2++;
			if(num[i].equals("3")) cnt3++;
			if(num[i].equals("4")) cnt4++;
			if(num[i].equals("5")) cnt5++;
			if(num[i].equals("6")) cnt6++;
		}

//		페어 처리
		if(cnt1 == 2) pair++;
		if(cnt2 == 2) pair++;
		if(cnt3 == 2) pair++;
		if(cnt4 == 2) pair++;
		if(cnt5 == 2) pair++;
		if(cnt6 == 2) pair++;
		
		for(int i=0; i<suit.length; i++) {
			if(suit[i].equals("0")) sCnt1++;
			if(suit[i].equals("1")) sCnt2++;
			if(suit[i].equals("2")) sCnt3++;
			if(suit[i].equals("3")) sCnt4++;
		}
		
//		하이카드 처리
		for(int i=0; i<num.length; i++) {
			intNum[i] = Integer.parseInt(num[i]);
		}
		while(run) {
			int i = 0;
			for(i=0; i<intNum.length; i++) {
				if(intNum[i] > maxN) maxN = intNum[i];
			}
			res = maxN + (Integer.parseInt(suit[i-1])/10);
			run = false;
		}
		
//		원페어
		if(pair == 1) resNum = 100.0;
//		투페어
		if(pair >= 2) resNum = 200.0;
//		트리플
		if(cnt1>=3 || cnt2>=3 || cnt3>=3 || cnt4>=3 || cnt5>=3 || cnt6>=3) resNum = 300.0;
//		스트레이트의 최소 조건인 9와  10이 존재하는지 확인
		if(cnt1 == 1 || cnt2 == 1 || cnt2 == 1 || cnt3 == 1) {
//			10,J,Q,K,A
			if(cnt2 >= 1 && cnt3 >= 1 && cnt4 >= 1 && cnt5 >= 1 && cnt6 >= 1) resNum = 500.0;
//			9,10,J,Q,K (스트레이트탑이 확인됐으면 스트레이트는 처리하지 않는다.
			else if(cnt1 >= 1 && cnt2 >= 1 && cnt3 >= 1 && cnt4 >= 1 && cnt5 >= 1) resNum = 400.0;
		}
//		풀하우스
		if(resNum == 300.0 && pair >= 1) resNum = 700.0;
//		포카드
		if(cnt1>=4 || cnt2>=4 || cnt3>=4 || cnt4>=4 || cnt5>=4 || cnt6>=4) resNum = 800.0;
//		플러쉬
		if(sCnt1>=5 || sCnt2>=5 || sCnt3>=5 || sCnt4>=5) resSuit = 600.0;
//		로얄 스트레이트 플러쉬
		if(resSuit == 600.0 && resNum == 500.0) resSuit = 1000.0;
//		스트레이트 플러쉬
		else if(resSuit == 600.0 && resNum == 400.0) resSuit = 900.0;
		
//		하이카드 정산.
		if(resNum < 100 && resSuit < 100) {
			resSuit = resSuit/10;
			res = resNum+resSuit;
			return res;
		}
//		족보 정산
		else {
			if(resNum > resSuit) res = resNum;
			else res = resSuit;
			return res;
		}
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
