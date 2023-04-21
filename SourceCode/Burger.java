/**
 * Burger class used in MealOrder
 * @author Pablo Maldonado
 */

import java.util.ArrayList;

public class Burger extends Item{
    //list of toppings added to the burger
    private ArrayList<Item> toppings = new ArrayList<>();


    /**
     * Constructor of Burger
     * @param name Type of burger, ex: "regular","chicken","turkey",...
     * @param price base price of a burger
     */
    public Burger( String name, double price) {
        super("Burger", name, price); // call super contractor with Burger as type
    }


    /**
     * getter for name, calls Item getName()
     * @return name of burger + " BURGER"
     */
    @Override
    public String getName() {
        return super.getName() + " BURGER";
    }

    /**
     * total price is based in price plus each topping price
     * @return total price base Price of burger + each topping price
     */
    @Override
    public double getAdjustPrice() {
        double total;
        total = getBasePrice();
        for(Item curr : toppings ){
            total += curr.getAdjustPrice();
        }
        return total;
    }

    /**
     * helper method that specify the price of given topping,
     * if topping is not on the list the cost added will be 0.0
     * @param toppingName name of topping
     * @return price of topping
     */
    public double getExtraPrice(String toppingName){
        return switch (toppingName.toUpperCase()){
            case "AVOCADO", "CHEESE","TOMATO" -> 1.0;
            case "BACON", "HAM", "SALAMI" -> 1.5;
            default ->  0.0;
        };
    }


    /**
     * add any number of toppings into the burger
     * @param toppingList ArrayList</String> of toppings to add
     */
    public void addToppings(ArrayList<String> toppingList){
        for(String curr : toppingList){
            toppings.add(new Item ("TOPPING", curr, getExtraPrice(curr)));
        }
    }

    /**
     * print base burger and its price
     * and each topping and their prices
     */
   public void printItemizedList(){
       printItem("BASE BURGER", getBasePrice());
       for (Item curr : toppings){
           curr.printItem();
       }
    }

    /**
     * print list of items and their prices
     */
    @Override
    public void printItem(){
        printItemizedList();
        System.out.println("-".repeat(30));
        super.printItem();
    }

}
