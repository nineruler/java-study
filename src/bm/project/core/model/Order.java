package bm.project.core.model;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    public int OrderNo;
    public List<OrderMenu> OrderMenus;
    public LocalDateTime OrderDate;
    public boolean isMenuCompleted = false;
    public boolean isServingCompleted = false;

    public Order(){
        OrderMenus =  new ArrayList<>();
    }

    public Order(List<OrderMenu> orderMenus, int orderNo) {
        this.OrderNo = orderNo;
        this.OrderMenus = orderMenus;
        this.OrderDate = LocalDateTime.now();
    }

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
