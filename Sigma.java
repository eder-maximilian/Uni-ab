package main;

import java.util.Arrays;

public class Sigma {
	
	/*
	 * Author: Maximilian Eder
	 * Geschrieben für Automaten & Berechenbarkeit
	 */
	
	public static void main(String[] args) {
		
		new Sigma();
		
	}
	
	public Sigma() {
		
		for(int n = 1; n < 8; n++) {
			
			System.out.println("\n\n<-><-><-><-><-> NEW N LOOP: N = " + n + " <-><-><-><-><->");
			
			for(int k = 0; k <= n; k++) {
				
				String inputRaw = "01#";
				
				String[] alphabet = inputRaw.split("");
				
				String[] combi = new String[(int) Math.pow(alphabet.length, n)];
				boolean[] containsk = new boolean[combi.length];
				
				for(int i = 0; i < containsk.length; i++) {
					
					containsk[i] = false;
					
				}
				
				for(int i = 0; i < combi.length; i++) {
					
					newwordloop:
					while(true) {
						
						String temp = "";
						for(int j = 0; j < n; j++) {
							
							int r = (int) (Math.random() * alphabet.length);
							temp += alphabet[r];
							
						}
						if(!doesWordExist(combi, temp)) {
							
							combi[i] = temp;
							
							if(doescontaink(combi[i], alphabet[alphabet.length - 1]) == k) {
								containsk[i] = true;
								
							}
							
							break newwordloop;
							
						}
						
					}
					
				}
				
				if(k == 0) {
					
					Arrays.sort(combi);
					printArray(combi);
					System.out.println("\nInsgesamt " + combi.length +" Wörter.");
					
				} else {
					
					printSelectedArray(combi, containsk);
					
					int am = 0;
					
					for(int i = 0; i < containsk.length; i++) {
						
						if(containsk[i]) {
							
							am++;
							
						}
						
					}
					
					System.out.println("\nIngesamt " + am + " Wörter, die " + k +"-mal den Buchstaben " + alphabet[alphabet.length - 1] + " enthalten.");
					
				}
				
			}
			
		}
		
		
	}

	private int doescontaink(String string, String letterOfk) {

		int amountoflastletter = (string.length() - string.replaceAll(letterOfk, "").length());
		
		return amountoflastletter;
	}

	private void printSelectedArray(String[] base, boolean[] selection) {

		for(int i = 0; i < base.length; i++) {
			
			if(selection[i]) {
				
				System.out.print(base[i] + ", ");
				
			}
			
		}
		
	}

	private void printArray(String[] array) {

		for(int i = 0; i < array.length; i++) {
			
			System.out.print(array[i] + ", ");
			
		}
		
	}

	private boolean doesWordExist(String[] wordlist, String word) {

		for(int i = 0; i < wordlist.length; i++) {
			
			if(word.equalsIgnoreCase(wordlist[i])) {
				
				return true;
				
			}
			
		}
		
		return false;
	}

}
