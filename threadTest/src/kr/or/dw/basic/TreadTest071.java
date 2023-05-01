package kr.or.dw.basic;

import javax.swing.JOptionPane;

public class TreadTest071 {

	public static void main(String[] args) {
		
		DataInput di = new DataInput();
		Count cd = new Count();
		
		di.start();
		cd.start();


	}

}
class DataInput extends Thread {
	public static boolean inputCheck;
	public static boolean victory = false;
	
	@Override
	public void run() {
		String mzf = null;
		
		do {
			mzf = JOptionPane.showInputDialog("가위 바위 보!!");
		}while(mzf == null || !mzf.equals("가위") && !mzf.equals("바위") && !mzf.equals("보"));
		
		int random = (int)(Math.random() * 3);
		String com = "";
		if(random == 0){
			com = "바위";
		}else if(random == 1) {
			com = "가위";
		}else {
			com = "보";
		}
		inputCheck = true;
		System.out.println("-- 결    과 --");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + mzf);
		if(com.equals(mzf)) {
			System.out.println("  <무승부!!>");
			return;
		}else if(!com.equals(mzf) && com.equals("가위") && mzf.equals("바위")) {
			System.out.println("  <승!!>"); victory = true; return;
		}else if(!com.equals(mzf) && com.equals("바위") && mzf.equals("보")) {
			System.out.println("  <승!!>"); victory = true; return;
		}else if(!com.equals(mzf) && com.equals("보") && mzf.equals("가위")) {
			System.out.println("  <승!!>"); victory = true; return;
		}else {
			System.out.println("  <패!!>"); return;
		}
		
	}
}

class Count extends Thread {

	@Override
	public void run() {
		for(int i = 5; i >= 0; i--){
			System.out.println(i);
			if(DataInput.inputCheck == true) {
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("지정된 시간이 경과했습니다. 당신의 패배입니다!!");
	}
	
}
