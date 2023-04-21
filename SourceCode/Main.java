// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        //meal extample
//        MealOrder defaulMeal = new MealOrder();
//        defaulMeal.addBurgerToppings("BACON","CHEESE","MAYO");
//        defaulMeal.setDrinkSize(Size.LARGE);
//        defaulMeal.printOrder();

        MealOrder meal2 = new MealOrder("chicken", "pepsi", "chili");
        meal2.addBurgerToppings("BACON,TOMATO,CHEESE,MAYO,KETCHUP");
        //meal2.setDrinkSize(Size.SMALL);
        meal2.printOrder();

    }
}