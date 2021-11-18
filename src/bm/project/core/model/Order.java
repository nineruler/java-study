package bm.project.core.model;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    public int OrderNo;
    public List<OrderMenu> OrderMenus;
    public LocalDateTime OrderDate;
    public boolean isCompleted = false;

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
            isCompleted = isCompleted && menu.isCompleted;
        }

        return isCompleted;
    }

    @Override
    public java.lang.String toString() {
        return "Order{" +
                "OrderMenus=" + OrderMenus.toString() +
                ", OrderDate='" + OrderDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + '\'' +
                "Completed=" + isCompleted +
                '}';
    }
}
