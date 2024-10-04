import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int firstSpace = 0;
		String firstPlayerPiece = "x";
		String secPlayerPiece = "o";
		String rounds = "Y";
		int Player1wins = 0;
		int Player2wins = 0;
		int Player1loss = 0;
		int Player2loss = 0;
		int Draws = 0;
		boolean turn = true;
		String firstPlayerFirstName = "";
		String secPlayerFirstName = "";


		System.out.println("Enter the First and Last Name of the First Player.");
		String FirstPlayer = scan.nextLine();

		while (!FirstPlayer.contains(" ")) {
			System.out.println("Enter the First and Last Name of the First Player.");
			FirstPlayer = scan.nextLine();
		}
		int firstplayerSpace = FirstPlayer.indexOf(" ");
		if (firstplayerSpace >= 0) {
			firstPlayerFirstName = FirstPlayer.substring(0, firstplayerSpace);
		}


		System.out.println("Enter the First and Last Name of the Second Player.");
		String SecPlayer = scan.nextLine();

		while (!SecPlayer.contains(" ")) {
			System.out.println("Enter the First and Last Name of the Second Player.");
			SecPlayer = scan.nextLine();
		}
		int secplayerSpace = SecPlayer.indexOf(" ");
		if (secplayerSpace >= 0) {
			secPlayerFirstName = SecPlayer.substring(0, secplayerSpace);
		}
		System.out.println("Who goes first?");
		String firstPersonToGoFirst = scan.nextLine();
		while (!firstPersonToGoFirst.equals(firstPlayerFirstName) && !firstPersonToGoFirst.equals(secPlayerFirstName)) {
			System.out.println("Please enter the first name of the First or Second Player.");
			System.out.println("Now, who goes first?");
			firstPersonToGoFirst = scan.nextLine();
		}

		if (firstPersonToGoFirst.equals(firstPlayerFirstName)) {
			turn = true;
		}
		if (firstPersonToGoFirst.equals(secPlayerFirstName)) {
			turn = false;
		}

		while (rounds.equals("Y")) {

			int moves = 0;
			int board = 3;
			int repeats = 9;

			String[] Spaces = new String[9];
			int i = 0;
			Spaces[0] = "1";
			Spaces[1] = "2";
			Spaces[2] = "3";
			Spaces[3] = "4";
			Spaces[4] = "5";
			Spaces[5] = "6";
			Spaces[6] = "7";
			Spaces[7] = "8";
			Spaces[8] = "9";


			for (int cols = 0; cols < board; cols++) {
				System.out.println("+---+---+---+");
				for (int w = 3; w > 0; w--) {
					if (i != 9) {
						System.out.print("| " + Spaces[i] + " ");
						i++;
					}
					if (i == 3 || i == 6 || i == 9) {
						System.out.println("|");
						w = 0;
					}
				}
			}

			System.out.print("+---+---+---+");
			System.out.println(" ");


			while (repeats != 0) {
				System.out.println("Which space? (1,2,3,4,5,6,7,8,9)");
				firstSpace = scan.nextInt();

				if (firstSpace == 1 || firstSpace == 2 || firstSpace == 3 || firstSpace == 4 || firstSpace == 5 ||
						firstSpace == 6 || firstSpace == 7 || firstSpace == 8 || firstSpace == 9) {
					if (turn) {
						System.out.println("It's " + secPlayerFirstName + "'s turn");
						Spaces[firstSpace - 1] = firstPlayerPiece;
						repeats--;
						moves++;
						turn = false;

					} else if (!turn) {
						System.out.println("It's " + firstPlayerFirstName + "'s turn");
						Spaces[firstSpace - 1] = secPlayerPiece;
						repeats--;
						moves++;
						turn = true;
					} else {
						System.out.println("Sorry that space is already taken!!!");
						System.out.println("Try again please.");
					}
					for (int rows = 0; rows < 1; rows++) {
						i = 0;
						for (int cols = 0; cols < board; cols++) {
							System.out.println("+---+---+---+");
							for (int w = 3; w > 0; w--) {
								if (i != 9) {
									System.out.print("| " + Spaces[i] + " ");
									i++;
								}
								if (i == 3 || i == 6 || i == 9) {
									System.out.println("|");
									w = 0;
								}
							}
						}
					}
					System.out.println("+---+---+---+");


				} else {
					System.out.println("Your space has to be (1,2,3,4,5,6,7,8,9)!!!");
					System.out.println();
				}


				if (Spaces[0].contains("x") && Spaces[1].contains("x") && Spaces[2].contains("x") ||
						Spaces[3].contains("x") && Spaces[4].contains("x") && Spaces[5].contains("x") ||
						Spaces[6].contains("x") && Spaces[7].contains("x") && Spaces[8].contains("x") ||
						Spaces[0].contains("x") && Spaces[3].contains("x") && Spaces[6].contains("x") ||
						Spaces[1].contains("x") && Spaces[4].contains("x") && Spaces[7].contains("x") ||
						Spaces[2].contains("x") && Spaces[5].contains("x") && Spaces[8].contains("x") ||
						Spaces[0].contains("x") && Spaces[4].contains("x") && Spaces[8].contains("x") ||
						Spaces[2].contains("x") && Spaces[4].contains("x") && Spaces[6].contains("x")) {
					System.out.println();
					System.out.println("Congrats " + FirstPlayer);
					System.out.println();
					for (int rows = 0; rows < 1; rows++) {
						i = 0;
						for (int cols = 0; cols < board; cols++) {
							System.out.println("+---+---+---+");
							for (int w = 3; w > 0; w--) {
								if (i != 9) {
									if(Spaces[i] == firstPlayerPiece){
										Spaces[i] = Spaces[i].toUpperCase();
									}
									System.out.print("| " + Spaces[i] + " ");
									i++;
								}
								if (i == 3 || i == 6 || i == 9) {
									System.out.println("|");
									w = 0;
								}
							}
						}
					}
					System.out.println("+---+---+---+");
					Player1wins++;
					Player2loss++;
					repeats = 0;
				}
				if (Spaces[0].contains("o") && Spaces[1].contains("o") && Spaces[2].contains("o") ||
						Spaces[3].contains("o") && Spaces[4].contains("o") && Spaces[5].contains("o") ||
						Spaces[6].contains("o") && Spaces[7].contains("o") && Spaces[8].contains("o") ||
						Spaces[0].contains("o") && Spaces[3].contains("o") && Spaces[6].contains("o") ||
						Spaces[1].contains("o") && Spaces[4].contains("o") && Spaces[7].contains("o") ||
						Spaces[2].contains("o") && Spaces[5].contains("o") && Spaces[8].contains("o") ||
						Spaces[0].contains("o") && Spaces[4].contains("o") && Spaces[8].contains("o") ||
						Spaces[2].contains("o") && Spaces[4].contains("o") && Spaces[6].contains("o")) {
					System.out.println();
					System.out.println("Congrats " + SecPlayer);
					System.out.println();
					for (int rows = 0; rows < 1; rows++) {
						i = 0;
						for (int cols = 0; cols < board; cols++) {
							System.out.println("+---+---+---+");
							for (int w = 3; w > 0; w--) {
								if (i != 9) {
									if(Spaces[i] == secPlayerPiece){
										Spaces[i] = Spaces[i].toUpperCase();
									}
									System.out.print("| " + Spaces[i] + " ");
									i++;
								}
								if (i == 3 || i == 6 || i == 9) {
									System.out.println("|");
									w = 0;
								}
							}
						}
					}
					System.out.println("+---+---+---+");
					Player2wins++;
					Player1loss++;
					repeats = 0;
				}
				if (moves == 9) {
					System.out.println();
					System.out.println("Draw!!!");
					System.out.println();
					Draws++;
					repeats = 0;
					if (firstPersonToGoFirst.equals(firstPlayerFirstName)) {
						turn = false;
					}
					if (firstPersonToGoFirst.equals(secPlayerFirstName)) {
						turn = true;
					}
				}
			}

			System.out.println(FirstPlayer + " wins " + Player1wins + " losses " + Player1loss );
			System.out.println(SecPlayer + " wins " + Player2wins + " losses " + Player2loss);
			System.out.println("Draws " + Draws);
			System.out.println("Wanna play again? (Y/N)");
			rounds = scan.next();

			while(!rounds.equals("Y") && !rounds.equals("N")) {
				System.out.println("Wanna play again? (Y/N)");
				rounds = scan.next();
			}
		}
	}
}


