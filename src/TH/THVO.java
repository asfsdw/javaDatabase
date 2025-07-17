package TH;

import java.util.Arrays;

public class THVO {
	private int point;
	private Object[][] trump = {
			{"♠", 9.3},
			{"♠", 10.3},
			{"♠", 11.3},
			{"♠", 12.3},
			{"♠", 13.3},
			{"♠", 14.3},
			{"◇", 9.2},
			{"◇", 10.2},
			{"◇", 11.2},
			{"◇", 12.2},
			{"◇", 13.2},
			{"◇", 14.2},
			{"♡", 9.1},
			{"♡", 10.1},
			{"♡", 11.1},
			{"♡", 12.1},
			{"♡", 13.1},
			{"♡", 14.1},
			{"♣", 9.0},
			{"♣", 10.0},
			{"♣", 11.0},
			{"♣", 12.0},
			{"♣", 13.0},
			{"♣", 14.0}
			};
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Object[][] getTrump() {
		return trump;
	}
	public void setTrump(Object[][] trump) {
		this.trump = trump;
	}
	
	@Override
	public String toString() {
		return "THVO [point=" + point + ", trump=" + Arrays.toString(trump) + "]";
	}
}
