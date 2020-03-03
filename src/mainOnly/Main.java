package mainOnly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		//変数の宣言

		String title = "***CodeBreaker***";		//タイトル

		String  rule = "隠された3つの数字を当てることができればクリア！\n"		//ルール文
	            + "各数字は1から6の間です。\n"
	            + "3つの数字にダブりはありません。\n"
	            + "入力した数字の、"
	            + "位置と数字が当たっていたら「ヒット」、\n"
	            + "数字だけ当たっていたら「ブロー」とカウントします。\n"
	            + "全部当てたら(3つともヒットになったら)"
	            + "終了です\n\n";

		int[] answer = new int[3];		//答え

		int[] input = new int[3];		//入力内容

		int hit = 0, blow = 0, challenge = 0;


		//タイトルとルールの表示
		System.out.println(title);
		System.out.println(rule);

		//ランダムな３ケタの答えを作成(１～６の数字で重複なし)
		List<Integer> list = new ArrayList<Integer>();

			//１から６をリストに格納
			for(int i = 0; i < 6; i++) {
				list.add(i,i+1);
			}

			//リストをシャッフル
			Collections.shuffle(list);

			//リストから３つを抽出し、answer配列に入れる
			for(int i = 0; i < answer.length; i++) {
				answer[i] = list.get(i);
			}

			//答えの出力
			for(int i = 0; i < 3; i++) {
				System.out.println(answer[i] + "\n");
				}

			//正解するまでループ
			int count = 0;
			 while (true) {
					System.out.println("１から６までの数字を３回入力してください");
		            count++;
		            System.out.println("*** "+count + "回目 ***");

					//数字のinput
					boolean bool = false;
					//数字を３回入力
					for(int i = 0; i < 3; i++) {
						Scanner sc = new Scanner(System.in);
						System.out.print((i + 1) + "回目→");
						int[] num = new int[3];
						num[i] = sc.nextInt();
							//1～6の入力チェック
							do {
								bool = false;

								if(0 < num[i] && num[i] < 7){
									bool = true;
								}
								else {
									System.out.println("1～6の整数を入力してください");
									System.out.print((i + 1) + "回目→");
									num[i] = sc.nextInt();
								}
							}while (bool == false);

						input[i] = num[i];
					}

					//inputした数字を出力
					System.out.println("\n\n********************************");
					System.out.print("あなたが入力した数字は");
					for(int i = 0; i < 3; i++) {
						System.out.print(input[i]);
						}
					System.out.println("です。\n");


					//hitの判定
					//blowの判定
					hit = 0;
					blow = 0;
			        for (int i = 0; i < answer.length; i++) {
			            for (int j = 0; j < answer.length; j++) {
			                if (i == j && input[i] == answer[j]) {
			                    hit++;
			                } else if (input[i] == answer[j]) {
			                    blow++;
			                }
			            }
			        }

					if(hit==3) {
						System.out.println("正解しました！\n********************************");
						break;
					}else {
						System.out.print("hit数：" + hit + "  ");
						System.out.println("blow数：" + blow + "\n********************************\n\n");
					}
		}
	}

}
