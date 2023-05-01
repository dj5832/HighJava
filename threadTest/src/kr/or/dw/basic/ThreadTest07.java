package kr.or.dw.basic;

import javax.swing.JOptionPane;

public class ThreadTest07 {

	/*
	 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	 * 
	 * 컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
	 * 사용자의 가위 바위 보는 showInputDialog() 를 이용해서 입력받는다.
	 * 
	 * 입력시간은 5초로 제한하고, 카운트다운을 진행한다.
	 * 5초 안에 입력이 없으면 게임에 진것으로 처리한다.
	 * 
	 * 5초 안에 입력이 완료되면 승패를 구해서 출력한다.
	 * 결과 예시)
	 * 	-- 결	과 --
	 * 	컴퓨터 : 가위
	 *  사용자 : 바위
	 *  	<승리!!>
	 */
	static game g = new game();
	
	public static void main(String[] args) {
		
		CountDown cd = new CountDown();
		g.start();
		cd.start();
	}
}

class game extends Thread{
	public static boolean Check;

	@Override
	public void run() {
		System.out.println("가위 : 1, 바위 : 2, 보 : 3");
		
		int computer = (int)(Math.random() * 3 + 1);
		
		String user = JOptionPane.showInputDialog("가위 : 1, 바위 : 2, 보 : 3");
		int u = Integer.parseInt(user);
		
		if(u - computer == 1 || u - computer == -2) {
			System.out.println("컴퓨터 : " + computer);
			System.out.println("사용자 : " + u);
			System.out.println("승리!!!");
		}else if(u - computer == 2 || u - computer == -1) {
			System.out.println("컴퓨터 : " + computer);
			System.out.println("사용자 : " + u);
			System.out.println("패배!!!");			
		}else if(u - computer == 0) {
			System.out.println("컴퓨터 : " + computer);
			System.out.println("사용자 : " + u);
			System.out.println("비겼습니다!!");						
		}
		Check = true;
	}
	
}

class CountDown extends Thread{
	@Override
	public void run() {
		for(int i = 5; i >= 0; i--) {
			System.out.println(i);
			
			if(game.Check == true) {
				return;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ThreadTest07.g.interrupt();
		System.out.println("패배!!!");
	}
	
}