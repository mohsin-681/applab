import org.example.Main;

import java.util.ArrayList;
import java.util.*;

import static java.awt.Color.GREEN;
import static org.example.Main.Apple.filter150Apples;
import static org.example.Main.Apple.filterGreenApples;

public class AppleInventory {
    public static void main(String[] args) {
        List<Main.Apple> inventory = new ArrayList<>();
        inventory.add(new Main.Apple("Green", 120));
        inventory.add(new Main.Apple("Red", 180));
        inventory.add(new Main.Apple("Yellow", 160));
        inventory.add(new Main.Apple("Green", 140));
        inventory.add(new Main.Apple("Yellow", 190));
        inventory.add(new Main.Apple("Purple", 299));

        System.out.println("inventory is: " + inventory.toString());

//        List<Main.Apple> greenApples = filterApples(inventory, AppleInventory::isGreenApple);
//        List<Main.Apple> heavyApples = filterApples(inventory, AppleInventory::isHeavyApple);

//        System.out.println("Green Apples: " + greenApples.size());
//        System.out.println("Heavy Apples: " + heavyApples.size());
        List<Main.Apple> greenApples =  filterApples(inventory, (Main.Apple a) -> "Green".equals(a.getColor()));
        System.out.println("Green Apples: " + greenApples.size());
        List<Main.Apple> heavyApples =  filterApples(inventory, (Main.Apple a) -> a.getWeight() < 150);
        System.out.println("heavyApples: " + heavyApples.size());

        List<Main.Apple> greenApples2 = filterGreenApples(inventory, "Yellow");
        System.out.println("Green apples: "+greenApples2);

        List<Main.Apple> apple150 = filter150Apples(inventory, 150);
        System.out.println("150 apples: "+ apple150);
    }



//    public static boolean isGreenApple(Main.Apple apple) {
//        return "Green".equals(apple.getColor());



//    List<Main.Apple> greenApples = filterGreenApples(List<Apple>);


    public static boolean isHeavyApple(Main.Apple apple) {
        return apple.getWeight() > 150;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    static List<Main.Apple> filterApples(List<Main.Apple> inventory, Predicate<Main.Apple> p) {
        List<Main.Apple> result = new ArrayList<>();
        for (Main.Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
