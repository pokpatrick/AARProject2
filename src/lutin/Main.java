package lutin;

import java.util.Scanner;

public class Main {
private static Scanner sc;

/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
				"utilisation: \n" +
			"type list : to list all the children\n" +
			"tape goodChildren : for all the good children\n" +
			"type make : to make a present");
		
		sc = new Scanner(System.in);
		System.out.println("Press your command :");
		String str = sc.nextLine();
		
		if(str.equals("list")){
			Client.listChildren();
		}
		
		if(str.equals("goodChildren")){
			Client.goodChildren();
		}
		
		if(str.equals("made")){
			Client.made(Integer.parseInt(args[2]));
		}
		
		System.out.println("bye bye little elf");
		
	}
}