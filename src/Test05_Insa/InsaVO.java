package Test05_Insa;

public class InsaVO {
	private int idx, age;
	private String name, gender, ipsail;
	
//	작업에 필요한 변수를 필드로 등록
	private String cbYY;
	private String cbMM;
	private String cbDD;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIpsail() {
		return ipsail;
	}
	public void setIpsail(String ipsail) {
		this.ipsail = ipsail;
	}
	public String getCbYY() {
		return cbYY;
	}
	public void setCbYY(String cbYY) {
		this.cbYY = cbYY;
	}
	public String getCbMM() {
		return cbMM;
	}
	public void setCbMM(String cbMM) {
		this.cbMM = cbMM;
	}
	public String getCbDD() {
		return cbDD;
	}
	public void setCbDD(String cbDD) {
		this.cbDD = cbDD;
	}
	
	@Override
	public String toString() {
		return "InsaVO [idx=" + idx + ", age=" + age + ", name=" + name + ", gender=" + gender + ", ipsail=" + ipsail
				+ ", cbYY=" + cbYY + ", cbMM=" + cbMM + ", cbDD=" + cbDD + "]";
	}
}
