package day8;


public class Employee1{
	private String name;
	private Integer age;
	private MyDate brithday;
	
	@Override
	public String toString() {
		return "Emploee [name=" + name + ", age=" + age + ", brithday=" + brithday + "]";
	}

	public Employee1(String name, Integer age, MyDate brithday) {
		super();
		this.name = name;
		this.age = age;
		this.brithday = brithday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}

	public MyDate getBrithday() {
		return brithday;
	}

	public void setBrithday(MyDate brithday) {
		this.brithday = brithday;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((brithday == null) ? 0 : brithday.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee1 other = (Employee1) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (brithday == null) {
			if (other.brithday != null)
				return false;
		} else if (!brithday.equals(other.brithday))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
