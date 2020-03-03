package GUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



//MainOnlyクラスのメソッド化
public class GameEngine {

	//タイトル
	private String title = "***CodeBreaker***";

	//ルール文
	private String  rule = "隠された3つの数字を当てることができればクリア！\n"
            + "各数字は1から6の間です。\n"
            + "3つの数字にダブりはありません。\n"
            + "入力した数字の、"
            + "位置と数字が当たっていたら「ヒット」、\n"
            + "数字だけ当たっていたら「ブロー」とカウントします。\n"
            + "全部当てたら(3つともヒットになったら)"
            + "終了です\n\n";

	//答えを格納する配列
	private int[] answer;

	//入力内容を保持する配列
	private int[] input;

    /** 答えの数字の数。将来的に拡張する事を考慮して作成 */
    private int numberOfAnswers = 3;

    /** 乱数の幅。この場合、1から6までとなる */
    private int widthOfRandom = 6;

	//hit数
	private int hit = 0;

	//blow数
	private int blow = 0;


	/*デフォルトコンストラクタ
	 * numberOfAnswersが３のままのとき*/
	public GameEngine() {
		answer = new int[numberOfAnswers];
		input = new int[numberOfAnswers];
		makeAnswer();
	}


     /* numberOfAnswersを変更し、
     * 解答の数字の数を3以外にしたい場合に使う */
	public GameEngine(int numberOfAnswers) {
		this.numberOfAnswers = numberOfAnswers;
		answer = new int[numberOfAnswers];
		input = new int[numberOfAnswers];
		makeAnswer();
	}


	//解答製作用メソッドmakeAnswers
	public void makeAnswer(){
		List<Integer> list = new ArrayList<Integer>();

		//１から６をリストに格納
		for(int i = 0; i < widthOfRandom; i++) {
			list.add(i,i+1);
		}
		//リストをシャッフル
		Collections.shuffle(list);
		//リストから３つを抽出し、answer配列に入れる
		for(int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		/*//答えの出力
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i] + "\n");
			}*/
	}


	//入力受付用メソッドinputAnswer
    public void inputAnswer(int index, int answer)throws InputException {
		if (index > -1 && index < numberOfAnswers) {
		if (answer > 0 && answer <= widthOfRandom) {
		input[index] = answer;
		} else {
		throw new InputException("入力が答えの範囲外です");
		}
		}	//判定処理用メソッドjudge


}