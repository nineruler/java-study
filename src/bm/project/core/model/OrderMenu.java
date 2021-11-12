package bm.project.core.model;

public class OrderMenu {
    public Menu Menu;
    public int Count;
    public int MenuPrice;

    public OrderMenu(Menu menu, int count){
        this.Menu = menu;
        this.Count = count;
        MenuPrice = menu.Price * count;
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
