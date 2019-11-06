package com.revature.list;

public class MyArrayList {

	int[] MyArray = new int[10];
	int capacity = MyArray.length;
	int usage = 0;

	public void add(int val) {

		MyArray[usage] = val;
		usage++;
		if (usage >= capacity) {
			capacity = capacity * 2;
			int[] TempArray = new int[capacity];
			for (int i = 0; i < MyArray.length; i++) {
				TempArray[i] = MyArray[i];
			}
			MyArray = TempArray;
		}

	}

	public void set(int index, int val) {
		if(index < 0 || index > usage) {
			return;
		}
		MyArray[index] = val;

	}

	public void remove(int index) {
		if(index < 0 || index > usage) {
			return;
		}
		for(int i = index; i < usage; i++) {
			MyArray[i] = MyArray[i+1];
		}
		usage--;
		if(usage < capacity / 2) {
			capacity = capacity / 2;
			int[] TempArray = new int[capacity];
			for (int i = 0; i < MyArray.length / 2; i++) {
				TempArray[i] = MyArray[i];
			}
			MyArray = TempArray;
		}

	}

	public int get(int index) {
		if(index < 0 || index > usage) {
			System.out.println("ArrayIndexOutOfBoundsTest");
			return index;
		}
		return MyArray[index];
	}

	@Override
	public String toString() {
		String string = "";
		for(int i = 0; i < usage; i++) {
			string += Integer.toString(MyArray[i]);
		}
		return string;
	}
}
