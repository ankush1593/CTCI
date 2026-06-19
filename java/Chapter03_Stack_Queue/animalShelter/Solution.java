package CTCI.java.Chapter03_Stack_Queue.animalShelter;

import java.util.LinkedList;

class Animal{
    private String name;
    private int order;

    public Animal(String name){
        this.name = name;
    }

    public void setOrder(int order){
        this.order = order;
    }

    public int getOrder(){
        return this.order;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

public class Solution {
    
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    //enqueue
    public void enqueue(Animal animal){
        animal.setOrder(order++);
        if (animal instanceof Dog){
            dogs.addLast((Dog) animal);
        }else if (animal instanceof Cat){
            cats.addLast((Cat) animal);
        }
    }

    //dequeueAny
    public Animal dequeueAny(){
        if (dogs.isEmpty()){
            return cats.poll();
        }
        if (cats.isEmpty()){
            return dogs.poll();
        }

        if(dogs.peek().getOrder() < cats.peek().getOrder()){
            return dequeueDog();
        }
        return dequeueCat();
    }
    //dequeueDog
    public Animal dequeueDog(){
        if (dogs.isEmpty()){
            throw new RuntimeException("No dogs available.");
        }
        return dogs.poll();
    }
    //dequeueCat
    public Animal dequeueCat(){
        if (cats.isEmpty()){
            throw new RuntimeException("No cats available.");
        }
        return cats.poll();
    }

    public static void main(String[] args) {

        Solution shelter = new Solution();

        shelter.enqueue(new Dog("Dog1")); // order 0
        shelter.enqueue(new Cat("Cat1")); // order 1
        shelter.enqueue(new Dog("Dog2")); // order 2
        shelter.enqueue(new Cat("Cat2")); // order 3

        System.out.println("Dequeue Any: " + shelter.dequeueAny().getName()); // Dog1
        System.out.println("Dequeue Cat: " + shelter.dequeueCat().getName()); // Cat1
        System.out.println("Dequeue Dog: " + shelter.dequeueDog().getName()); // Dog2
        System.out.println("Dequeue Any: " + shelter.dequeueAny().getName()); // Cat2
    }
}
