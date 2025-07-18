package TH;

import java.util.Arrays;

public class THVO {
	private int idx, point;
	private String name = "", imagePath = "";
	private double card;
//	1.0은 클로버9, 1.3은 스페이드9...6.1은 하트A, 6.2는 다이아A
	private double[] trump = {
			1.0,1.1,1.2,1.3,2.0,2.1,2.2,2.3,3.0,3.1,3.2,3.3,4.0,4.1,4.2,4.3,
			5.0,5.1,5.2,5.3,6.0,6.1,6.2,6.3};
	
	public THVO() {
	}
	public THVO(double card, String imagePath) {
		this.card = card;
		this.imagePath = imagePath;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public double getCard() {
		return card;
	}
	public void setCard(double card) {
		this.card = card;
	}
	public double[] getTrump() {
		return trump;
	}
	public void setTrump(double[] trump) {
		this.trump = trump;
	}

	@Override
	public String toString() {
		return "THVO [idx=" + idx + ", point=" + point + ", name=" + name + ", imagePath=" + imagePath + ", card=" + card
				+ ", trump=" + Arrays.toString(trump) + "]";
	}
}
