/*
 * (C) Copyright 2016 Alejandro Sanchez Acosta.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *     Alejandro Sanchez Acosta <asanchez@neurowork.net>
 */

public class ArrayStringBag implements StringBag {
	public String[] data;
	private int count;
	public static final int CAPACITY = 4;

	/**
   *
   * Create Bag instance
   *
   */
	public ArrayStringBag() {
		this.data = new String[CAPACITY];
		this.count = 0;
	}

	/**
   *
   * Add element to the bag
   *
   */
	public void add(String value) {
		if (count == data.length) {
			this.doubleArrayCapacity();
		}

		this.data[count] = value;
		this.count++;
	}

	/**
   *
   * Remove element from bag
   *
   */
	public void remove(String value) {
		for (int i=0; i<count; i++) {
			if (data[i].equals(value)) {
				data[i] = data[count - 1];
				count--;
				return;
			}
		}
	}

	/**
   *
   * Contains element in the Bag
   *
   * @return true or false if the element is in the bag
   */
	public boolean contains(String value) {
		for (int i = 0; i < count; i++) {
			if (this.data[i].equals(value)) {
				return true;
			}
		}

		return false;
	}

	/**
   *
   * Count elements in the Bag
   *
   * @return the number of elements in the bag
   */
	public int count(String value) {
		int counter = 0;

		for (int i = 0; i < count; i++) {
			if (this.data[i].equals(value)) {
				counter++;
			}
		}

		return counter;
	}

	/**
   *
   * Double bag capacity
   *
   */
	private void doubleArrayCapacity() {
		String[] copy = new String[data.length * 2];

		for (int i = 0; i < count; i++) {
			copy[i] = this.data[i];
		}

		this.data = copy;

		System.out.println("Doubled capacity: "+ data.length * 2);
	}
}