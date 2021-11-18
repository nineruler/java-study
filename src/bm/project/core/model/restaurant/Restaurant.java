package bm.project.core.model.restaurant;

import bm.project.core.model.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurant {
    ArrayList<Menu> menuList = new ArrayList<>();               // 메뉴판
    HashMap<Integer, Order> orderMap = new HashMap<>();         // 주문
    RestaurantInfo restaurantInfo = new RestaurantInfo();       // 식당정보
    ArrayList<Category> menuCategoryList = new ArrayList<>();   // 메뉴 카테고리
    Category category = new Category();                         // 카테고리
    HashMap<Integer, Table> tableMap = new HashMap<>();         // 테이블
    Table table = new Table();                                  // 테이블 객체
    int orderNo = 1;                                            // 주문번호
    int tableMaxCount = 10;                                     // 전체 테이블 수

    public Restaurant() {

    }

    // 생성자
    public Restaurant(RestaurantInfo info, ArrayList<Menu> menus) {
        menuList = menus;
        restaurantInfo = info;
    }

    // 메뉴 세팅
    public void setMenu(ArrayList<Menu> menus) {
        menuList = menus;
    }

    // 카테고리 세팅
    public void setCategory(int categoryNo, String categoryName, ArrayList<Menu> menus) {
        category = new Category(categoryNo, categoryName, menus);
    }

    public Category getCategory() {
        return category;
    }

    public List<Category> getMenu() {
        return menuCategoryList;
    }

    public void printMenu() {

    }

    public Order createOrder(List<OrderMenu> orderMenus) {
        Order order = new Order(orderMenus, orderNo++);
        orderMap.put(order.OrderNo, order);

        return order;
    }

    public Order getOrder(int orderNo) {
        return orderMap.get(orderNo);
    }

    public void addOrder() {

    }

    public void completeOrder(int orderNo) {
        Order order = orderMap.get(orderNo);
        order.isCompleted = true;

        orderMap.put(orderNo, order);

        System.out.println("주문번호" + orderNo + " 완성되었습니다.");
        System.out.println(orderMap.get(orderNo));
    }

    public void setRestaurantInfo(RestaurantInfo restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }

    public RestaurantInfo getRestaurantInfo() {
        return restaurantInfo;
    }

    public void removeOrder(int orderNo) {
        orderMap.remove(orderNo);
    }

    public Order changeOrder(int orderNo, List<OrderMenu> orderMenus) {
        Order order = orderMap.get(orderNo);
        order.OrderMenus = orderMenus;

        System.out.println("주문이 변경되었습니다.");
        System.out.println("변경내역 : " + order.OrderMenus);

        return order;
    }

    public void setTable(int tableNo, Order order) {
        List<Order> orders = new ArrayList<>();
        orders.add(order);

        table = new Table(tableNo, orders);

        if (tableMap.size() <= tableMaxCount) {
            tableMap.put(tableNo, table);
        } else {
            System.out.println("테이블이 가득 찼습니다.");
        }

        System.out.println("남은 테이블 수 : " + getRemainTable());
    }

    public int getRemainTable() {
        return tableMaxCount - tableMap.size();
    }

    public void addTableOrder(int tableNo, Order order) {
        Table table = tableMap.get(tableNo);
        table.Orders.add(order);
        tableMap.put(tableNo, table);
    }

    public void removeTableOrder(int tableNo, int orderNo) {
        Table table = tableMap.get(tableNo);
        System.out.println("테이블 No" + tableNo + "의 주문 " + table.Orders.get(orderNo) + "가 취소되었습니다.");
        table.Orders.remove(orderNo);
    }

    public Table getTable() {
        return table;
    }

    public void printTableInfo(int tableNo) {
        int totalPrice = 0;
        Table table = tableMap.get(tableNo);

        System.out.println("TableNo : " + tableNo);
        System.out.println("주문내역");

        for (Order order : table.Orders) {
            System.out.print("No" + order.OrderNo);
            // 삼항연산자
            // System.out.print("No" + order.OrderNo + (order.Completed ? " 완료" : " 미완료"));

            if (order.isCompleted) {
                System.out.println(" 완료");
            }
            else {
                System.out.println(" 미완료");
            }

            System.out.println("주문시간 : " + order.OrderDate.format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 HH:mm:ss")));

            for (OrderMenu orderMenu : order.OrderMenus) {
                System.out.println(orderMenu.Menu + " " + orderMenu.Count);
                totalPrice += orderMenu.MenuPrice;
            }
        }

        System.out.println("총 금액 : " + totalPrice);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantInfo=" + restaurantInfo +
                '}';
    }
}