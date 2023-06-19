package dto;

public class StudentDTO {
	
	private int no;
	private String name;
	private String phone;
	private String address;
	private String date;
	
	public StudentDTO() {
		
	}
	
	public StudentDTO(int no, String name, String phone, String address, String date) {
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
