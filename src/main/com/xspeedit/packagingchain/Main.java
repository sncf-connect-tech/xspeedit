package com.xspeedit.packagingchain;

import java.util.Scanner;

import com.xspeedit.packagingchain.exception.OptimizedAlgorithmException;
import com.xspeedit.packagingchain.process.OptimizedAlgorithmImpl;

public class Main {

	private static Scanner sc;

	public static void main(String[] args) {
		final OptimizedAlgorithmImpl algo = new OptimizedAlgorithmImpl();
		System.out.println("Chaine d'article en entrée");
		sc = new Scanner(System.in);
		String str = sc.nextLine();
		String outPut = "";
		try {
			outPut = algo.optimize(str);
			System.out.println("chaine d'articles emballés\n"+ outPut);
		} catch (OptimizedAlgorithmException e) {
			System.out.println(e.getMessage());
		}

	}

}
