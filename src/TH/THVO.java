package TH;

public class THVO {
	private int idx, point;
	private String name = "", imagePath = "";
	private double card;
	
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
}
