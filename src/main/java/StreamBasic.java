

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;


import java.util.*;

public class StreamBasic {

    public static void main(String... args) {
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

        System.out.println("The answer is: ");
        Dish.menu.stream().filter(d -> !d.isVegetarian()).limit(2).forEach(System.out::println);

        List<Dish> firstTwoMeats = Dish.menu.stream().filter(d -> !d.isVegetarian()).limit(3).collect(toList());
        System.out.println("First " +
                ".0 meats: "+firstTwoMeats);
        // Task 2
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(d -> d * d).collect(toList());
        System.out.println("The square is: "+squares);

        // Task 3


    }



    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : dishes) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }



}