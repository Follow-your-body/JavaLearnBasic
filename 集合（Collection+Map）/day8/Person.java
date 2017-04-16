package day8;

public class Person implements Comparable {
	private String name;
	private Integer age;
	
	public Person() {
		super();
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
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
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
	
	// 当向TreeSet类中添加A的对象时，依据此方法，确定按照按照哪个属性排列（这里是按照age排序）
		@Override
		public int compareTo(Object o) {
			if(o instanceof Person) {
				Person p = (Person)o;
//				return this.name.compareTo(a.name);
				int i = this.age.compareTo(p.age);
				// i = 0证明age相同 
				if(i == 0) {
					return this.name.compareTo(p.name);
				} else {
					return i ;
				}
			} 
			return 0;			
		}
}
