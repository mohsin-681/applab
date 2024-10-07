package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    public static class Apple {
        public String color;
        public int weight;

        public Apple(String color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public int getWeight() {
            return weight;
        }
        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    '}';
        }

        public static List<Apple> filterGreenApples(List<Main.Apple> inventory, String color) {
            List<Main.Apple> result = new ArrayList<>();
            for(Main.Apple apple: inventory) {
                if(apple.getColor().equals(color)) {
                    result.add(apple);
                }
            }
            System.out.println("The result is : "+ result);
            return result;

        }

        public static List<Main.Apple> filter150Apples(List<Main.Apple> inventory, int weight) {
            List<Main.Apple> result = new ArrayList<>();
            for(Main.Apple apple: inventory) {
                if(apple.getWeight() > weight) {
                    result.add(apple);
                }
            }
            return result;
        }
    }
}