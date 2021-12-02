package bm.project.core.model;

public class OrderMenu {
    public Menu Menu;
    public int Count;
    public int MenuPrice;
    public boolean isMenuCompleted = false;
    public boolean isServingCompleted = false;


    public OrderMenu(Menu menu, int count){
        this.Menu = menu;
        this.Count = count;
        MenuPrice = menu.Price * count;
    }

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
