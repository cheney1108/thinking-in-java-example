package com.z.unit;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable{
	private static Random rand = new Random(47);
	private static final char[] capitals = "ASDFGHJKQWERTYUIOL".toCharArray();
	private static final char[] lowers = "asdfghjklqwertyui".toCharArray();
	private static final char[] vowels = "aerou".toCharArray();
	private int count;
	public RandomWords(int count) {
		this.count = count;
	}
	@Override
	public int read(CharBuffer cb) throws IOException {
		if(count-- == 0){
			return -1;
		}
		cb.append(capitals[rand.nextInt(capitals.length)]);
		for(int i = 0; i<4; i++) {
			cb.append(lowers[rand.nextInt(lowers.length)]);
			cb.append(vowels[rand.nextInt(vowels.length)]);
		}
		cb.append(" ");
		return 10;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(new RandomWords(10));
		while (s.hasNext()) {
			System.out.println(s.next());
		}
	}
}
