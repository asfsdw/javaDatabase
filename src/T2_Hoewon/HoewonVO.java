package T2_Hoewon;

public class HoewonVO {
	private int idx, age;
	private String name = "", address = "", gender = "";
	
	public int getidx() {
		return idx;
	}

	public void setidx(int idx) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "HoewonVO [idx=" + idx + ", age=" + age + ", name=" + name + ", address=" + address + ", gender=" + gender + "]";
	}
}
