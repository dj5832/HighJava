package kr.or.dw.basic;

public class ThreadTest01 {

	public static void main(String[] args) {
		
		// 싱글 쓰레드 프로그램
		for(int i = 0; i <= 200; i++) {
			System.out.print("*");
		}
		
		System.out.println();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		for(int i = 0 ; i <= 200; i++) {
			System.out.print("$");
		}
		
	}

}
