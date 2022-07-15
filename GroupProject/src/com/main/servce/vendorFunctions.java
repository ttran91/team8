package com.main.servce;

import java.util.Scanner;

public class vendorFunctions {

	public static void VendorMenu() {

		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("Vendor Menu");
			System.out.println("Press 1 to View Customer order");
			System.out.println("Press 2 to Accept or Decline Customer orders");
			System.out.println("Press 3 to Change Menu");
			System.out.println("Press 0 to Log Out");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Logging out...Have a nice day");
				break;
			}
			switch (input) {
			case 1:
				System.out.println("***Customer Orders***");
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
			}

		}
	}

}
