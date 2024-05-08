package firstProject;
import java.util.*;

class PairOfDice{
	int dice1,dice2;
	PairOfDice(){
		dice1=1;
		dice2=1;
	}
	void DiceRoll() {
		Random ran = new Random();
		dice1 = ran.nextInt(6)+1;
		dice2 = ran.nextInt(6)+1;
	}
	int ReturnD1() {
		return dice1;
	}
	int ReturnD2() {
		return dice2;
	}
}

class Player{
	int totalScore,turnScore,goalScore;
	Player(int num){
		totalScore=0;
		turnScore=0;
		goalScore = num;
	}
	boolean RollTheDice() {
		PairOfDice dice = new PairOfDice();
		dice.DiceRoll();
		System.out.println("Dice: "+ dice.dice1 + " + " + dice.dice2+" = "+(dice.dice1+dice.dice2));
		if(dice.dice1!=1 && dice.dice2!=1) {
			this.turnScore+=(dice.dice1+dice.dice2);
			System.out.println("현 회차 점수: "+turnScore);
			return true;
		}
		else if(dice.dice1==1 && dice.dice2==1) {
			this.totalScore=0;
			this.turnScore=0;
			System.out.println("꽝입니다!!");
			return false;
		}
		else {
			this.turnScore=0;
			System.out.println("꽝입니다!!");
			return false;
		}
	}
	int ReturnTotalScore() {
		return this.totalScore;
	}
	
}
class Game{
	Scanner sc = new Scanner(System.in);
	int goalScore;
	PairOfDice dice;
	Player computer;
	Player user;
	String currPlayer = "computer";
	String con = "";
	boolean endGame=false;
	Game(int goal){
		this.goalScore = goal;
		dice = new PairOfDice();
		computer = new Player(20);
		user = new Player(-1);
	}
	void PlayGame() {
		if(currPlayer.equals("computer")) {
			while(computer.RollTheDice() && !endGame) {
				if(computer.totalScore+ computer.turnScore>=goalScore) {ReturnWinner();endGame=true;break;}
				
				if(computer.goalScore<=computer.turnScore) {
					currPlayer = "user";
					computer.totalScore+=computer.turnScore;
					computer.turnScore=0;
					break;
				}
			}
			currPlayer = "user";
			Turn();
		}
		else {
			if(user.RollTheDice()) {
				if(user.totalScore>=goalScore) {ReturnWinner();endGame=true;return;}
				System.out.println("계속 던지시겠습니까?(y/n): ");
				con = sc.next();
				if(con.equals("Y")||con.equals("y"))PlayGame();
				else {
					currPlayer = "computer";
					user.totalScore+=user.turnScore;
					user.turnScore=0;
					if(user.totalScore>=goalScore) {ReturnWinner();endGame=true;return;}
					Turn();
				}
			}
			else {
				currPlayer = "computer";
				Turn();
			}
		}
		
		
	}
	void Turn() {
		if(endGame)return;
		
		System.out.println("***********************\n");
		if(currPlayer.equals("computer")) {
			System.out.println("컴퓨터 차례...");
		}
		else {
			System.out.println("사용자 차례...");
		}
		System.out.println("현 점수:\n컴퓨터: "+computer.ReturnTotalScore() +"\n사용자: "+user.ReturnTotalScore()+"\n");
		PlayGame();
	}
	void ReturnWinner() {
		System.out.println();
		if(computer.totalScore>user.totalScore) System.out.println("컴퓨터 승리!!");
		else if(computer.totalScore<user.totalScore) System.out.println("사용자 승리!!");
		else System.out.println("무승부 입니다!!");
		
		System.out.println("최종 결과\n컴퓨터: "+computer.totalScore+"\n사용자: "+user.totalScore);
	}
	
}

public class Driver {

	public static void main(String[] args) {
		Game G1 = new Game(50);
		G1.Turn();
	}

}
