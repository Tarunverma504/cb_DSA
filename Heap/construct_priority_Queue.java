/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

/**
 *
 * @author Mind_Coder
 */
import java.util.*;
public class construct_priority_Queue {
    
    public static class Person{
        int age;
        String name;
        int id;
        public Person(int age, String name, int id){
            this.age = age;
            this.name = name;
            this.id = id;
        }
        @Override
        public String toString(){
            return name + "";
        }
    }
    public static void main(String arg[]){
        PriorityQueue<Integer> h = new PriorityQueue<>(Collections.reverseOrder());
        h.add(10);
        h.add(20);
	h.add(30);
	h.add(5);
	h.add(3);
	
	System.out.println(h);
	System.out.println(h.remove());
	System.out.println(h.peek());
	System.out.println(h);
        
        PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2){
                return o1.name.compareTo(o2.name);
            }
        });
        
        pq.add(new Person(10, "ram", 2));
	pq.add(new Person(20, "mohan", 1));
	pq.add(new Person(30, "shyam", 3));
	pq.add(new Person(5, "john", 0));
	pq.add(new Person(3, "abc", 5));
	System.out.println(pq);
    }
}
