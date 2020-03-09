package step2;

import java.util.Scanner;

public class MainStep2 {

	public static void main(String[] args) {

		GameEngine ge = new GameEngine();

		//タイトルとルールの出力
		System.out.println(ge.getTitle());
		System.out.println(ge.getRule());

		//チャレンジ回数のカウント
		int count = 0;
		while (true) {
			System.out.println("１から６までの数字を３回入力してください");
            count++;
            System.out.println("*** "+count + "回目 ***");

			//数字をnumberOfAnswers回入力
			for(int i = 0; i < ge.getNumberOfAnswers(); i++) {
				Scanner sc = new Scanner(System.in);
				System.out.print((i + 1) + "回目→");
				try{
					ge.inputAnswer(i, sc.nextInt());
				} catch(InputException e){
					System.err.println(e.getMessage());
					i--;
				}
			}


			if(ge.judge()) {
				System.out.println("\n正解です！！\n" +  count + "回目で正解したあなたは天才かっ！！");
				break;
			}else {
				System.out.print("hit数：" + ge.getHit() + "     ");
				System.out.println("blow数：" + ge.getBlow() + "\n********************************\n\n");
			}

		 }
	}
}
