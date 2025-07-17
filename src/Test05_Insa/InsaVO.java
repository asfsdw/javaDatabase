package Test05_Insa;

public class InsaVO {
	private int idx, age;
	private String name, gender, ipsail;
	
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

	@Override
	public String toString() {
		return "InsaVO [idx=" + idx + ", age=" + age + ", name=" + name + ", gender=" + gender + ", ipsail=" + ipsail + "]";
	}
}
