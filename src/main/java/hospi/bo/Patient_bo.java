package hospi.bo;

public class Patient_bo 
{
	private int id;
	private String name;
	private String gender;
	private String phone;
	private String age;
	private String tr;
	private String report;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTr() {
		return tr;
	}
	public void setTr(String tr) {
		this.tr = tr;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	@Override
	public String toString() 
	{
		return "Patient_bo [id=" + id + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", age=" + age
				+ ", tr=" + tr + ", report=" + report + "]";
	}
	public Patient_bo( String name, String gender, String phone, String age, String tr, String report) 
	{
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.age = age;
		this.tr = tr;
		this.report = report;
	}
	public Patient_bo() 
	{
		super();
	}
	
	
}
