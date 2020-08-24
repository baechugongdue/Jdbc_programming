package Jdbc_programming.dto;

public class Department {
	private int no;
	private String name;
	private int floor;
	
	public Department() {
		super();
	}

	public Department(int no) {
		super();
		this.no = no;
	}

	public Department(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public Department(int no, String name, int floor) {
		super();
		this.no = no;
		this.name = name;
		this.floor = floor;
	}

	public  int getNo() {
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

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "Department [no=" + no + ", name=" + name + ", floor=" + floor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + floor;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
		return result;
	}

	
}
