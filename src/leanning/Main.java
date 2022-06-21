package leanning;

import java.util.Scanner;

import utill.Create;

public class Main {
	public static void main(String[] args) {
		//Create.run();
		Scanner sc = new Scanner(Create.run());
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		//線形探索時にふたつのロジックのスピードの差が知りたかった・・・
		//paizaロジック
		// int maximum = 6;
		// int minimum = 2;

		// for(int value : a){
		//     maximum = Math.max(maximum, value);
		//     minimum = Math.min(minimum,value);
		// }

		//どこかで見たロジック
		int maximum = a[0];
		int minimum = a[0];
		for (int value : a) {
			if (maximum <= value) {
				maximum = value;
			} else if (minimum > value) {
				minimum = value;
			}
		}

		System.out.println(maximum + " " + minimum);
	}
}
