package day11;

public class TestSeason {
	public static void main(String[] arg0) {
		System.out.println("�Զ���ö�١�������");
		Season spring = Season.SPRING;
		System.out.println(spring.getSeasonDesc());
		
		System.out.println("ʹ��ö���࡭������");
		Season1 spring1 = Season1.SPRING;
		System.out.println(spring1.getSeasonDesc());
		
		System.out.println("ö�������(ö����.values(),������ʽ����)��������");
		Season1[] season = Season1.values();
		for(Season1 s : season) {
			System.out.println(s);
		}
		
		System.out.println("ö����������ƻ�ȡ����(ö����.valueof(),������ʽ����)��������");
		System.out.println(Season1.valueOf("SPRING"));
		
		System.out.println("ö�ٽӿڵ�ʹ�÷�ʽ��������");
		Season2.SPRING.show();
		Season2.SUMMER.show();
	} 
}

class Season {
	// 1�ṩ������ԣ�����Ϊprivate+fimal
	private final String seasonName;
	private final String seasonDesc;
	
	// 2����Ϊfinal�������ڹ������г�ʼ��
	private Season(String seasonName, String seasonDesc) {
		super();
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	
	// ͨ�������ķ���������
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
	
	// 4����ö����Ķ���:��������Ϊpublic final static 
	public static final Season SPRING = new Season("spring", "��ů����");
	public static final Season SUMMER = new Season("summer", "��������");
	public static final Season AUTUMN = new Season("autumn", "�����ˬ");
	public static final Season WINTER = new Season("winter", "��ѩ����");	
	
}

// ʹ��ö���ࣨ���������ǰ�棩
enum Season1 {
	SPRING("spring", "��ů����"),
	SUMMER("summer", "��������"),
	AUTUMN("autumn", "�����ˬ"),
	WINTER("winter", "��ѩ����");	
	
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
	SPRING("Spring", "��ů����"),
	SUMMER("summer", "��������") {
		//ö�ٶ����п��Զ���ӿ��еķ���
		public void show() {
			System.out.println("�����Ļ�");
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
		System.out.println("������ϰ���ڵ���������");		
	}
	
}
