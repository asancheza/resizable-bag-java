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
 * Bag Example
 */
public class BagExample {
	public static void main(String[] args) {
		GenericBag<String> b = new Bag<String>();

		b.add("Hello");

		if (!b.contains("Hello")) {
			System.out.println("Contains is broken");
		}

    for (int i = 0; i < 1000; i++) {
      b.add("hello");
    }

    for (int i = 0; i < 1000; i++) {
      b.remove("hello");
    }

    System.out.println("Counts: "+b.count("hello"));

    GenericBag<Integer> b1 = new Bag<Integer>();

		b1.add(1);

		if (!b1.contains(1)) {
			System.out.println("Contains is broken");
		}

    for (int i = 0; i < 1000; i++) {
      b1.add(i);
    }

    System.out.println("Counts: "+b1.count(1));

    for (int i = 0; i < 1000; i++) {
      b1.remove(i);
    }
	}
}