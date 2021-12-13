package bm.project.core.model;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Order.
 */
public class Order {
    /**
     * The Order no.
     */
    public int OrderNo;
    /**
     * The Order menus.
     */
    public List<OrderMenu> OrderMenus;
    /**
     * The Order date.
     */
    public LocalDateTime OrderDate;
    /**
     * The Is menu completed.
     */
    public boolean isMenuCompleted = false;
    /**
     * The Is serving completed.
     */
    public boolean isServingCompleted = false;

    /**
     * Instantiates a new Order.
     */
    public Order(){
        OrderMenus =  new ArrayList<>();
    }

    /**
     * Instantiates a new Order.
     *
     * @param orderMenus the order menus
     * @param orderNo    the order no
     */
    public Order(List<OrderMenu> orderMenus, int orderNo) {
        this.OrderNo = orderNo;
        this.OrderMenus = orderMenus;
        this.OrderDate = LocalDateTime.now();
    }

    /**
     * Gets order completed.
     *
     * @return the order completed
     */
    public boolean getOrderCompleted() {
        for(OrderMenu menu : OrderMenus){
            isMenuCompleted = isMenuCompleted && menu.isMenuCompleted;
        }

        return isMenuCompleted;
    }

    @Override
    public java.lang.String toString() {
        return "Order{" +
                "OrderMenus=" + OrderMenus.toString() +
                ", OrderDate='" + OrderDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + '\'' +
                "Completed=" + isMenuCompleted +
                '}';
    }
}
