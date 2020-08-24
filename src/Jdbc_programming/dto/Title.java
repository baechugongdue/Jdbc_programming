package Jdbc_programming.dto;

import java.util.List;

public class Title {
	private int no;
	private String name;
	// 같은 직책 속하는 사원 알기 
	private List<Employee> list;
	
	public Title(){
		
	}
	
	public Title(int no) {
		super();
		this.no = no;
	}

	public Title(int no, String name) {
		this.no = no;
		this.name = name;
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

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Title [no=" + no + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		return this.no == ((Title) obj).no;
	}		
}
