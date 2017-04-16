集合类e
	Collection子接口之一
		Set接口（元素无序+不可重复）
			HashSet(主要实现类)
				特点
					>无序性：真正的无序性，！=随机型，值得是元素在底层存储的位置是无序的
					>不可重复性：当Set中添加进相同的元素的时候，后面的这个不能添加进去
						说明：要求添加进Set中的元素所在的类，一定要重写equals()和HashCode（）方法
							进而保证Set中元素的不可重复性
					>存储方式：使用哈希算法，哈希数值相同的值不可重复加入
						当向Set中添加对象时，首先调用此对象所在类的HashCode（）方法，计算此时对象的哈希值，
						此哈希值决定了对象在Set中的存储位置，若此位置之前没有对象存储，则这个对象直接存储到此位置，
						若此位置已有对象存储，再通过equals（）比较这两个对象是否相同。
						如果相同，后一个对象就不能添加进来，反之两个对象都做到同一个位置（不建议这样）
						要求：HashCode方法和equal方法一致。
			LinkedHashSet
				特点
					>维护了一个添加进集合的顺序，导致当我们遍历LinkedHashSet集合元素时，是按照添加进去的顺序遍历
						方法和HashSet类中的方法相同
					>是HashSet的子类
					>根据元素的hashcode值来决定元素的存储位置，但是它同时使用链表维护元素的次序
					 ，这使得元素看起来是以插入顺序保存的
					>插入性能略低于HashSet，但是迭代访问Set里的全部元素时有很好的性能
					>不允许集合元素重复
			TreeSet
				特点
					>向TreeSet中添加的元素必须是《同一个类型》
					>可以按照添加进集合的元素指定的顺序遍历(默认按照从小到大的顺序遍历)
					>自然排序：要求自定义类实现java.lang.Comparable接口并重写compareTo（Object obj）
						在此方法中，指明按照自定义类的哪个属性进行排序
					>排序方式
						<1>自然排序
							向TreeSet中添加元素的类中继承Comparable接口，然后重写conpareTo（）方法，来进行属性的排序，但是会出现重复添加
								set.add(new A("13", 14));		
								set.add(new A("11", 14));	
							因此要求conpareTo与hashCode+equals三者保持一致
				以上练习：TestSet1.java  Person.java
						<2>定制排序
						定制排序（Comparator接口，子类中的compare重写）	
						 * 1,创建一个实现了Comparator接口的类对象（匿名/不匿名），其中重写compare方法
						 * 2,将此对象作为形参传递给TreeSet的构造器
						 * 3,向TreeSet添加Comparator中的compare方法中设计的类的对象
						 * 	>hashCode和equals,compare必须一致，也就是说重写compare时要将所有的属性优先级排序
						 练习： TestSet1.java  Customer.java
				练习： TestEmployee.java  MyDate.java Employee1.java