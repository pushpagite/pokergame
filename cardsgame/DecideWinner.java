package cardsgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DecideWinner {
	Scanner scn = new Scanner(System.in);

	// Method for finding the winner with highest points
	public void checkWinner(Player[] playerArr1) {
		Player[] playerArr = selectMode(playerArr1);

		//Cards after mode and Shuffling 
		System.out.println("After selecting mode  shuffled card is");
		for (Player player : playerArr) {
			System.out.println(player.playerName);
			player.showInhandCard();
		}

		//Finding winning player with highest point
		Map<String, Integer> map = new HashMap<>();
		for (Player player : playerArr) {

			int cnt = 0;
			for (int i = 0; i < 3; i++) {
				cnt += player.inHandCard[i].getValue();
			}
			map.put(player.playerName, cnt);

		}

		// Finding Max Key-value pair
		Map.Entry<String, Integer> maxEntry = null;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}

		System.out.println("Winner with maximum points :" + maxEntry.getKey());

	}

	//Select Playing Mode 
	public Player[] selectMode(Player PlayerArr[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Any Card Joker \n2.Low Card Joker \n3.High Card Joker");
		System.out.println("Please select mode");
		int mode = sc.nextInt();
		switch (mode) {
		case 1:
			for (int i = 0; i < PlayerArr.length; i++) {
				System.out.println("hello " + PlayerArr[i].playerName + " your turn ");
				PlayerArr[i].showInhandCard();
				System.out.println("Enter whcich card you want to make as joker 1-3");
				int no = sc.nextInt();
				PlayerArr[i] = replaceCard(PlayerArr[i], no);

			}
			break;
		case 2:
			System.out.println("you have enterd  Low Card Joker mode");
			for (int i = 0; i < PlayerArr.length; i++) {
				System.out.println("hello " + PlayerArr[i].playerName + " your turn ");
				PlayerArr[i].showInhandCard();

				//Finding card with Maximum Priority
				int no = 0;
				int minindex = PlayerArr[i].inHandCard[0].getValue();
				System.out.println("maxindex" + minindex);
				for (int j = 0; j < PlayerArr[i].inHandCard.length; j++) {
					if (minindex > PlayerArr[i].inHandCard[j].getValue()) {
						no = j;
					}

				}
				no++;
				System.out.println("Number " + no);
				System.out.println("Min Index " + no);

				PlayerArr[i] = replaceCard(PlayerArr[i], no);
				System.out.println("Cards after replaced");
				PlayerArr[i].showInhandCard();
			}

			break;

		case 3:
			System.out.println("You have enterd  hign  Card Joker mode");
			for (int i = 0; i < PlayerArr.length; i++) {
				System.out.println("hello " + PlayerArr[i].playerName + " your turn ");
				PlayerArr[i].showInhandCard();
				System.out.println("Enter whcich card you want to make as joker 1-3");

				//Finding card with Minimum Priority
				int no = 0;
				int maxindex = PlayerArr[i].inHandCard[0].getValue();
				System.out.println("maxindex" + maxindex);
				for (int j = 0; j < PlayerArr[i].inHandCard.length; j++) {
					if (maxindex < PlayerArr[i].inHandCard[j].getValue()) {
						no = j;
					}

				}
				no++;
				System.out.println("Number " + no);
				System.out.println("maxindex " + no);

				PlayerArr[i] = replaceCard(PlayerArr[i], no);
				System.out.println("Cards after replaced");
				PlayerArr[i].showInhandCard();
			}
			break;

		default:
			System.out.println("You have enter wrong mode..");
			break;
		}
		return PlayerArr;

	}

	
	//Swapping the joker card with card entered by enter
	public Player replaceCard(Player player, int no) {
		System.out.println("Enter card no(1-3) which you want to replace ?");
		int cardno = scn.nextInt();
		player.inHandCard[no - 1] = player.inHandCard[cardno - 1];
		return player;
	}

	
	
	// Finding Same Number Card
	public boolean checkSameNumberCard(Player playerArr[]) {
		boolean flag = true;
		for (Player player : playerArr) {
			flag = true;
			for (int i = 0; i < 3; i++) {
				for (int j = 1; j < 3; j++) {
					if (player.inHandCard[i].getValue() != player.inHandCard[j].getValue()) {
						flag = false;
						break;

					}
				}

			}
		}
		return flag;

	}

	
	// Checking Same Color
	public boolean checkSameColor(Player playerArr[]) {
		boolean flag = true;
		for (Player player : playerArr) {
			flag = true;
			for (int i = 0; i < 3; i++) {
				for (int j = 1; j < 3; j++) {
					if (!(player.inHandCard[i].getCardSuit().equals(player.inHandCard[j].getCardSuit()))) {
						flag = false;
						break;
					}
				}

			}
		}
		return flag;

	}
	

	// Finding Sequence without Color
	public boolean checkSequenceWithoutColor(Player player) {
		boolean flag = true;

		ArrayList<Integer> al = new ArrayList<Integer>();
		for (Card card : player.inHandCard) {
			al.add(card.getValue());
		}

		System.out.println(al);
		flag = true;
		for (int i = 0; i < 2; i++) {

			if (!(al.get(i + 1) - al.get(i) == 1)) {
				flag = false;
				break;
			}

		}

		return flag;

	}

}
