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

/* 
 * Bag definition
 */
public class Bag<T> implements GenericBag<T> {
	public T[] data;
	private int count;
	public static final int CAPACITY = 4;

	/**
   *
   * Create Bag instance
   *
   */
	public Bag() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[CAPACITY];
		this.data = temp;

		this.count = 0;
	}

	/**
   *
   * Add element to the bag
   *
   */
	public void add(T value) {
		if (this.count == this.data.length)
			this.doubleArrayCapacity();

		this.data[count] = value;
		this.count++;
	}

	/**
   *
   * Remove element from bag
   *
   */
	public void remove(T value) {
		for (int i=0; i<count; i++) {
			if (this.data[i].equals(value)) {
				this.data[i] = this.data[count - 1];
				count--;
				if (this.isTooBig()) 
					this.reduceArray();
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
	public boolean contains(T value) {
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
	public int count(T value) {
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
		@SuppressWarnings("unchecked")
		T[] copy = (T[]) new Object[this.data.length * 2];

		for (int i = 0; i < count; i++) {
			copy[i] = this.data[i];
		}

		this.data = copy;

		System.out.println("Doubled capacity: "+ data.length * 2);
	}

	/*
	 * This method returns true if the number 
	 * of entries in the bag is less than half 
	 * the size of the array and the size of the 
	 * array is greater than 20.
	 *
	 * return @boolean 
	 */
	private boolean isTooBig() {
		if (this.count < this.data.length / 2 && this.data.length > 20) {
			return true;
		}

		return false;
	}

	/* 
	* This method creates a new array that 
	* is three quarters the size of the current 
	* array and then copies the objects in the 
	* bag into the new array.
	*/
	private void reduceArray() { 
		int capacity = this.data.length * 3 / 4;
		System.out.println(capacity);
		T[] copy = (T[]) new Object[capacity];

		for (int i = 0; i < this.count; i++) {
			copy[i] = this.data[i];
		}

		this.data = copy;

		System.out.println("Reduced capacity: "+ data.length);
	}
}