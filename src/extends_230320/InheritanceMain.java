package extends_230320;

public class InheritanceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 부모 객체
		ParentClass p1 = new ParentClass();
		p1.name = "name1";
		System.out.println(p1.name);
		p1.hello();
				
	
		// 자식 객체 (자식객체에는 아무것도 선언이 없으나 부모 상속을 통해 가능) 
		ChildClass c1 = new ChildClass();
		c1.name = "자식 name1";
		System.out.println(c1.name);
		c1.hello();
		
		
		// 상속 시에 자식생성자를 실행하면 부모생성자 및 자식생성자 둘다 실행함 
		// 자식객체의 메서드만 호출하면 부모는 미실행, 자식만 실행
		
		
		ChildClass c2 = new ParentClass();
		// ㄴ 크기상 부모클래스가 자식보다 크기 때문에, 자식형태로 형변환을 시킬 수 없다. > 오류발생
		// 강제형변환 시, ChildClass c2 = (ChildClass) new ParentClass(); 가능
		
		ParentClass p2 = new ChildClass();
		
		
		
		
	}

}
