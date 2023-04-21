
/**
 * This class represent a full Order
 * which are compose by: burger,drink, and siz
 * @author Pablo Maldonado
 */

import java.util.ArrayList;
import java.util.Arrays;

public class MealOrder {

    private Burger burger;
    private Item drink;
    private Item side;



    /**
     * default Order is: regular burger, a coke, and fries
     */
    public MealOrder(){
        this("regular", "coke","fries");
    }

    /**
     *Contructor to create new MealOrder, creates burger and Items instances
     * @param burgerType Type of burger, ex: "regular","chicken","turkey",...
     * @param drinkType  type of drink, ex: "coke","pepsi", "crush",...
     * @param sideType type of size, ex: "fries","chilli","curly fries"...
     */
    public MealOrder(String burgerType, String drinkType, String sideType){
        burger = new Burger(burgerType, 4.0);
        drink = new Item("drink",drinkType, 1.00);
        side = new Item("side",sideType,1.50);
    }

    /**
     * sum of prices of: Burger + drink + size
     * @return total sum of prices
     */
    public double getTotalPrice(){
        return side.getAdjustPrice() + drink.getAdjustPrice() +
                burger.getAdjustPrice();
    }

    /**
     * print each item and its price and total price at the end
     */
    public void printOrder (){
        burger.printItem();
        drink.printItem();
        side.printItem();
        System.out.println("-".repeat(30));
        Item.printItem("TOTAL PRICE: " , getTotalPrice());

    }

    /**
     * add any number of toppings to burger
     * @param toppingList list of items separated by a ","
     */
    public void addBurgerToppings(String toppingList){
       String[] listArray = toppingList.split(",");
       ArrayList arrayList = new ArrayList<>();
       arrayList.addAll(Arrays.asList(listArray));
       burger.addToppings(arrayList);
    }


    /**
     * setter for drink size
     * @param drinkSize size to set drink
     */
    public void setDrinkSize(Size drinkSize){

        drink.setSize(drinkSize);
    }




}
