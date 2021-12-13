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
     * 주문 번호
     */
    public int OrderNo;
    /**
     * 주문 메뉴 리스트
     */
    public List<OrderMenu> OrderMenus;
    /**
     * 주문 날짜
     */
    public LocalDateTime OrderDate;
    /**
     * 메뉴 완성 여부
     */
    public boolean isMenuCompleted = false;
    /**
     * 서빙 완료 여부
     */
    public boolean isServingCompleted = false;

    /**
     * 생성자
     */
    public Order(){
        OrderMenus =  new ArrayList<>();
    }

    /**
     * 생성자
     *
     * @param orderMenus 주문 메뉴 리스트
     * @param orderNo    주문 번호
     */
    public Order(List<OrderMenu> orderMenus, int orderNo) {
        this.OrderNo = orderNo;
        this.OrderMenus = orderMenus;
        this.OrderDate = LocalDateTime.now();
    }

    /**
     * 주문 완성여부 가져오기
     *
     * @return 주문 완성여부
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
