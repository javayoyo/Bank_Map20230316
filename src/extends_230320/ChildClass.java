package extends_230320;

public class ChildClass extends ParentClass {
	
	public ChildClass () {
		System.out.println("자식 클래스 생성자");
	}
	
	//hello 재정의
	@Override
	public void hello() {
		System.out.println(" 자식 hello ");
	
	}
	
	@Override
	public void hi() {        // private 지정한 것은 내부만 사용가능, 상속 불가 > 오류발생
		System.out.println("자식 hi");
	}
	
	
}
