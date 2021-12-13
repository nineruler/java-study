package bm.project.core.model;

/**
 * The type Order menu.
 */
public class OrderMenu {
    /**
     * The Menu.
     */
    public Menu Menu;
    /**
     * The Count.
     */
    public int Count;
    /**
     * The Menu price.
     */
    public int MenuPrice;
    /**
     * The Is menu completed.
     */
    public boolean isMenuCompleted = false;
    /**
     * The Is serving completed.
     */
    public boolean isServingCompleted = false;


    /**
     * Instantiates a new Order menu.
     *
     * @param menu  the menu
     * @param count the count
     */
    public OrderMenu(Menu menu, int count){
        this.Menu = menu;
        this.Count = count;
        MenuPrice = menu.Price * count;
    }

    /**
     * Complete order menu.
     */
    public void completeOrderMenu(){
        isMenuCompleted = true;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "Menu=" + Menu +
                ", Count=" + Count +
                ", MenuPrice=" + MenuPrice +
                '}';
    }
}
