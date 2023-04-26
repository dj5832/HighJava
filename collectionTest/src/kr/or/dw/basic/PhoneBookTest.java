package kr.or.dw.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {
	
	/*
	 * 이름, 주소, 나이, 전화번호를 멤버변수로 갖는 Phone 클래스를 만들고 Map을 이용하여
	 * 전화번호 정보를 관리하는 프로그램을 작성해주세요.
	 * 
	 * - 이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체 출력하는 기능이 있다.
	 * - 삭제와 검색 기능은 '이름'을 입력 받아 처리한다.
	 * - (Map의 구조는 key값으로 그 사람의 '이름'을 사용하고, value값으로는 'Phone클래스의 인스턴스'로 한다.)
	 * 
	 * 실행 예시)
	 * 		다음 메뉴를 선택하세요.
	 * 		1. 전화번호 등록
	 * 		2. 전화번호 수정
	 * 		3. 전화번호 삭제
	 * 		4. 전화번호 검색
	 * 		5. 전화번호 전체 출력
	 * 		0. 프로그램 종료
	 * 		----------------
	 * 		번호입력 >> 1
	 * 
	 * 		새롭게 등록할 전화번호 정보를 입력하세요.
	 * 		이름 >> 홍길동
	 * 		전화번호 >> 010-6773-3469
	 * 		나이 >> 20
	 * 		주소 >> 대전시 중구 선화동
	 * 
	 * 		'홍길동' 전화번호 등록 완료 !!
	 * 		(단, 등록되어 있는 사람이면 '홍길동'은 이미 등록된 사람입니다. 라고 출력)
	 * 		--------------------------------------------------------
	 * 		번호입력 >> 5
	 * 
	 * 		=========================================================
	 * 		번호 		이름			전화번호			나이			주소
	 * 		=========================================================
	 * 		1		홍길동	010-6773-3469		20		대전시 중구 선화동
	 * 		=========================================================
	 */

	public static void main(String[] args) {

		Map<String, Phone> phoneBookList = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1 . 전화번호 등록");
			System.out.println("2 . 전화번호 수정");
			System.out.println("3 . 전화번호 삭제");
			System.out.println("4 . 전화번호 검색");
			System.out.println("5 . 전화번호 전체 출력");
			System.out.println("0 . 프로그램 종료");
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			int input = Integer.parseInt(sc.nextLine());
			switch (input) {
			case 1:
				System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
				System.out.println("이름>");
				String name = sc.nextLine();
				System.out.println("전화번호>");
				String tel = sc.nextLine();
				System.out.println("나이>");
				int age = Integer.parseInt(sc.nextLine());
				System.out.println("주소>");
				String addr = sc.nextLine();
				
				Phone p = new Phone(tel, age, addr);
				phoneBookList.put(name, p);
				System.out.println("등록이 완료되었습니다.");
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				System.out.println("검색할 사람의 이름을 입력하세요 > ");
				String search_name = sc.nextLine();
				for(String key : phoneBookList.keySet()) {
					if(key.equals(search_name)) {
						System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
						System.out.println("이름\t\t전화번호\t\t나이\t\t주소");
						System.out.println("---------------------------------------------------------------------");
						System.out.println(key + "\t\t" + phoneBookList.get(key).getTel() + "\t\t"
								+ phoneBookList.get(key).getAge() + "\t\t" + phoneBookList.get(key).getAddress());
						System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
					}
				}
				break;
			case 5:
				int count = 0;
				System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("번호\t이름\t\t전화번호\t\t나이\t\t주소");
				System.out.println("---------------------------------------------------------------------");
				for(String key : phoneBookList.keySet()) {
					count++;
					System.out.println(count + "\t" + key + "\t\t" + phoneBookList.get(key).getTel() + "\t\t"
							+ phoneBookList.get(key).getAge() + "\t\t" + phoneBookList.get(key).getAddress());
					System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");					
				}
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;

			default:
				break;
			}
		}
		
		
		
		
		
	}

}

class Phone {
	
	private String addr;
	private int age;
	private String tel;
	
	public Phone(String tel, int age, String addr) {
		this.addr = addr;
		this.age = age;
		this.tel = tel;
	}

	public String getAddress() {
		return addr;
	}

	public void setAddress(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Phone [address=" + addr + ", age=" + age + ", tel=" + tel + "]";
	}
	
}





















