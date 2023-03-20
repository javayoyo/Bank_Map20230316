package day19_20230320;

public class InterfaceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 인터페이스 객체 생성 (x)ㄱ
//		InterfaceEx if1 = new InterfaceEx();
	
		//아래와 같은 방식으로는 잘 사용하지 않음(인터페이스 쓸 이유 없음)
	ImplClass1 ipc1 = new ImplClass1();
	
	
	/** 클래스에 대한 내용을 정의하는 주석(별이 2개 ** )
	 * 
	 * 좌변 : 인터페이스 타입의 객체로 선언
	 * 우변 : 구현클래스 생성자
	 * 
	 * **/
	
	InterfaceEx if1 = new ImplClass1();   // 다형성 > 좌변은 동일, 우변만 다양하게 설정
	if1.hello();
	
	
	InterfaceEx if2 = new ImplClass2();
	if2.hello();
	
	InterfaceEx if3 = new ImplClass1();
	if3.hello();
	if3 = new ImplClass2();
	if3.hello();

	
	
	}

}
