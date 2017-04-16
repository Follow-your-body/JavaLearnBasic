package day11;

public class TestSeason {
	public static void main(String[] arg0) {
		System.out.println("自定义枚举…………");
		Season spring = Season.SPRING;
		System.out.println(spring.getSeasonDesc());
		
		System.out.println("使用枚举类…………");
		Season1 spring1 = Season1.SPRING;
		System.out.println(spring1.getSeasonDesc());
		
		System.out.println("枚举类遍历(枚举类.values(),数组形式返回)…………");
		Season1[] season = Season1.values();
		for(Season1 s : season) {
			System.out.println(s);
		}
		
		System.out.println("枚举类根据名称获取内容(枚举类.valueof(),数组形式返回)…………");
		System.out.println(Season1.valueOf("SPRING"));
		
		System.out.println("枚举接口的使用方式…………");
		Season2.SPRING.show();
		Season2.SUMMER.show();
	} 
}

class Season {
	// 1提供类的属性，声明为private+fimal
	private final String seasonName;
	private final String seasonDesc;
	
	// 2声明为final的属性在构造器中初始化
	private Season(String seasonName, String seasonDesc) {
		super();
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	// 通过公共的方法来调用
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	
	// 4创建枚举类的对象:将类声明为public final static 
	public static final Season SPRING = new Season("spring", "春暖花开");
	public static final Season SUMMER = new Season("summer", "夏日炎炎");
	public static final Season AUTUMN = new Season("autumn", "秋高气爽");
	public static final Season WINTER = new Season("winter", "白雪皑皑");	
	
}

// 使用枚举类（对象放在最前面）
enum Season1 {
	SPRING("spring", "春暖花开"),
	SUMMER("summer", "夏日炎炎"),
	AUTUMN("autumn", "秋高气爽"),
	WINTER("winter", "白雪皑皑");	
	
	private final String seasonName;
	private final String seasonDesc;
	
	private Season1(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	public String getSeasonName() {
		return seasonName;
	}
	public String getSeasonDesc() {
		return seasonDesc;
	}
	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}
	
}

interface info {
	void show();	
}

enum Season2 implements info {
	SPRING("Spring", "穿暖花开"),
	SUMMER("summer", "夏日炎炎") {
		//枚举对象中可以定义接口中的方法
		public void show() {
			System.out.println("生如夏花");
		}
	};
	
	private String seasonName;
	private String seasonDesc;
	
	private Season2(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	@Override
	public void show() {
		System.out.println("这是练习季节的描述问题");		
	}
	
}
