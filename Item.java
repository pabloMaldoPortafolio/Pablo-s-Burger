
/**
This class represent Items on OrderMeal
@author Pablo Maldonado
 */

public class Item {

    private String type;//type of item: "drink", "side"
    private String name; //name of item
    private double price;//base price of item
    private Size size = Size.REGULAR;//default Size of each item

    /**
     * Constructor for Item
     * @param type type of item: "Drink" or "Size"
     * @param name name of item
     * @param price base set price
     */
    public Item(String type,String name, double price){
        this.type = type;
        this.name = name;
        this.price = price;
    }


    /**
     helper method to print Items
     @return formatted String depending on type variable
     */
    public String getName() {
        if(type.toUpperCase().equals("SIDE") ||  type.toUpperCase().equals("DRINK")){
            return size + " " + name;
        }
        return name;
    }

    /**
    helper class that return price without any changes in size
    @return base price (price without considering the size)
     */
    public double getBasePrice() {
        return price;
    }

    /**
    calculate the price given the size of Item
    size can be: "SMALL", "REGULAR", "LARGE" defined in enum Size
    @return Adjusted price based on the size of the Item
     */
    public double getAdjustPrice(){
        if(size.equals(Size.SMALL)){
            return getBasePrice() - 0.5;
        } else if(size.equals(Size.LARGE)){
            return getBasePrice() + 1;
        } else {
            return getBasePrice();
        }
    }

    /**
    setter for the size, size defined by Enum Size
    @param size to be set
     */
    public void setSize(Size size){
        this.size = size;
    }
    /**
    print formatted Item
    @param name name of Item
    @param price price of item
     */
    public static void printItem(String name, double price){
        System.out.printf("%20s:%6.2f%n",name.toUpperCase(),price);
    }

    /**
    method will call method above to print Adjusted price and name
     */
    public void printItem(){
        printItem(getName(),getAdjustPrice());
    }
}
