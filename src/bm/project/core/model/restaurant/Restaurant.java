package bm.project.core.model.restaurant;

import bm.project.core.model.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Restaurant.
 */
public class Restaurant {
    /**
     * The Menu list.
     */
    ArrayList<Menu> menuList = new ArrayList<>();               // 메뉴판
    /**
     * The Order map.
     */
    HashMap<Integer, Order> orderMap = new HashMap<>();         // 주문
    /**
     * The Restaurant info.
     */
    RestaurantInfo restaurantInfo = new RestaurantInfo();       // 식당정보
    /**
     * The Menu category list.
     */
    ArrayList<Category> menuCategoryList = new ArrayList<>();   // 메뉴 카테고리
    /**
     * The Category.
     */
    Category category = new Category();                         // 카테고리
    /**
     * The Table map.
     */
    HashMap<Integer, Table> tableMap = new HashMap<>();         // 테이블
    /**
     * The Table.
     */
    Table table = new Table();                                  // 테이블 객체
    /**
     * The Order no.
     */
    int orderNo = 1;                                            // 주문번호
    /**
     * The Table max count.
     */
    int tableMaxCount = 10;                                     // 전체 테이블 수

    /**
     * Instantiates a new Restaurant.
     */
    public Restaurant() {

    }

    /**
     * Instantiates a new Restaurant.
     *
     * @param info  the info
     * @param menus the menus
     */
// 생성자
    public Restaurant(RestaurantInfo info, ArrayList<Menu> menus) {
        menuList = menus;
        restaurantInfo = info;
    }

    /**
     * Sets menu.
     *
     * @param menus the menus
     */
// 메뉴 세팅
    public void setMenu(ArrayList<Menu> menus) {
        menuList = menus;
    }

    /**
     * Sets category.
     *
     * @param categoryNo   the category no
     * @param categoryName the category name
     * @param menus        the menus
     */
// 카테고리 세팅
    public void setCategory(int categoryNo, String categoryName, ArrayList<Menu> menus) {
        category = new Category(categoryNo, categoryName, menus);
    }

    /**
     * Gets category.
     *
     * @return the category
     */
//카테고리 가져오기
    public Category getCategory() {
        return category;
    }

    /**
     * Gets menu.
     *
     * @return the menu
     */
//카테고리 메뉴 가져오기
    public List<Category> getMenu() {
        return menuCategoryList;
    }

    /**
     * Print menu.
     */
//메뉴 프린트
    public void printMenu() {

    }

    /**
     * Create order order.
     *
     * @param orderMenus the order menus
     * @return the order
     */
//주문 생성
    public Order createOrder(List<OrderMenu> orderMenus) {
        Order order = new Order(orderMenus, orderNo++);
        orderMap.put(order.OrderNo, order);

        return order;
    }

    /**
     * Gets order.
     *
     * @param orderNo the order no
     * @return the order
     */
//주문 가져오기
    public Order getOrder(int orderNo) {
        return orderMap.get(orderNo);
    }

    /**
     * Add order.
     */
//주문 추가
    public void addOrder() {

    }

    /**
     * Complete menu.
     *
     * @param orderNo the order no
     * @param menuNo  the menu no
     */
//주문 완료
//    public void completeOrder(int orderNo) {
//        Order order = orderMap.get(orderNo);
//        order.isCompleted = true;
//
//        orderMap.put(orderNo, order);
//
//        System.out.println("주문번호" + orderNo + " 완성되었습니다.");
//        System.out.println(orderMap.get(orderNo));
//    }
    public void completeMenu(int orderNo, int menuNo){
        Order order = orderMap.get(orderNo);
        List<OrderMenu> orderMenus = order.OrderMenus;
        OrderMenu orderMenu = orderMenus.get(menuNo-1);
        orderMenu.isMenuCompleted  = true;
        orderMenus.set(menuNo-1, orderMenu);

        int CountCompleted = 0;
        for(OrderMenu ordermenu : orderMenus) {
            if(ordermenu.isMenuCompleted) CountCompleted++;
        }
        if(orderMenus.size() == CountCompleted) order.isMenuCompleted = true;
        orderMap.put(orderNo,order);
    }

    /**
     * Serve menu.
     *
     * @param orderNo the order no
     * @param menuNo  the menu no
     */
//메뉴 서빙여부
    public void serveMenu(int orderNo, int menuNo){
        Order order = orderMap.get(orderNo);
        List<OrderMenu> orderMenus = order.OrderMenus;
        OrderMenu orderMenu = orderMenus.get(menuNo-1);
        orderMenu.isServingCompleted  = true;
        orderMenus.set(menuNo-1, orderMenu);

        int CountCompleted = 0;
        for(OrderMenu ordermenu : orderMenus) {
            if(ordermenu.isServingCompleted) CountCompleted++;
        }
        if(orderMenus.size() == CountCompleted) order.isServingCompleted = true;
        orderMap.put(orderNo,order);
    }


    /**
     * Sets restaurant info.
     *
     * @param restaurantInfo the restaurant info
     */
//레스토랑 정보 세팅
    public void setRestaurantInfo(RestaurantInfo restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }

    /**
     * Gets restaurant info.
     *
     * @return the restaurant info
     */
//레스토랑 정보 가져오기
    public RestaurantInfo getRestaurantInfo() {
        return restaurantInfo;
    }

    /**
     * Remove order.
     *
     * @param orderNo the order no
     */
//주문 취소
    public void removeOrder(int orderNo) {
        orderMap.remove(orderNo);
    }

    /**
     * Change order order.
     *
     * @param orderNo    the order no
     * @param orderMenus the order menus
     * @return the order
     */
//주문 변경
    public Order changeOrder(int orderNo, List<OrderMenu> orderMenus) {
        Order order = orderMap.get(orderNo);
        order.OrderMenus = orderMenus;
        orderMap.put(orderNo, order);

        System.out.println("주문이 변경되었습니다.");
        System.out.println("변경내역 : " + order.OrderMenus);

        return order;
    }

    /**
     * Sets table.
     *
     * @param tableNo the table no
     * @param order   the order
     */
//테이블 세팅
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

    /**
     * Gets remain table.
     *
     * @return the remain table
     */
//현재 잔여 테이블 수
    public int getRemainTable() {
        return tableMaxCount - tableMap.size();
    }

    /**
     * Add table order.
     *
     * @param tableNo the table no
     * @param order   the order
     */
//테이블에 주문 추가
    public void addTableOrder(int tableNo, Order order) {
        Table table = tableMap.get(tableNo);
        table.Orders.add(order);
        tableMap.put(tableNo, table);
    }

    /**
     * Remove table order.
     *
     * @param tableNo the table no
     * @param orderNo the order no
     */
//테이블 주문 취소
    public void removeTableOrder(int tableNo, int orderNo) {
        Table table = tableMap.get(tableNo);
        System.out.println("테이블 No" + tableNo + "의 주문 " + table.Orders.get(orderNo) + "가 취소되었습니다.");
        table.Orders.remove(orderNo);
    }

    /**
     * Gets table.
     *
     * @return the table
     */
//테이블 가져오기
    public Table getTable() {
        return table;
    }

    /**
     * Print table info.
     *
     * @param tableNo the table no
     */
//테이블 정보 프린트
    public void printTableInfo(int tableNo) {
        int totalPrice = 0;
        Table table = tableMap.get(tableNo);

        System.out.println("TableNo : " + tableNo);
        System.out.println("주문내역");

        for (Order order : table.Orders) {
            System.out.println("No" + order.OrderNo +"\n"+ (order.isMenuCompleted ? "조리 완료" : "조리 미완료")
            +" & "+(order.isServingCompleted ? "서빙 완료" : "서빙 미완료"));

            System.out.println("주문시간 : " + order.OrderDate.format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 HH:mm:ss")));

            for (OrderMenu orderMenu : order.OrderMenus) {
                System.out.println(orderMenu.Menu + " " + orderMenu.Count
                +" & "+ (orderMenu.isMenuCompleted ? "조리 완료" : "조리 미완료")+
                " & " + (orderMenu.isServingCompleted ? "서빙 완료" : "서빙 미완료"));
                totalPrice += orderMenu.MenuPrice;
            }
        }

        System.out.println("총 금액 : " + totalPrice);
    }

    //번호표 출력 만들기기

   @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantInfo=" + restaurantInfo +
                '}';
    }
}