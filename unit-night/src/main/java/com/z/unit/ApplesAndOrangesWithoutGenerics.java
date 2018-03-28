package com.z.unit;

import java.util.ArrayList;

class Apple {
	private static long counnter;
	private final long id = counnter++;
	public long id() {
		return id;
	}
}
class Orange{}

//类名真长
public class ApplesAndOrangesWithoutGenerics {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ArrayList apples = new ArrayList();
		for (int i = 0; i < 3; i++) {
			//这里苹果的容器是不能放橘子的
			apples.add(new Orange());
			for (int j = 0; j < apples.size(); j++) {
				((Apple) apples.get(i)).id();
			}
		}
		
	}
}
