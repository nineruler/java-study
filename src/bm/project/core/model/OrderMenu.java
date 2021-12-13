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
     * 생성자
     *
     * @param menu  메뉴
     * @param count 주문할 메뉴 수
     */
    public OrderMenu(Menu menu, int count){
        this.Menu = menu;
        this.Count = count;
        MenuPrice = menu.Price * count;
    }

    /**
     * 메뉴 완성 여부
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
