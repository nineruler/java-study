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
     * 메뉴판
     */
    ArrayList<Menu> menuList = new ArrayList<>();
    /**
     * 주문내역
     */
    HashMap<Integer, Order> orderMap = new HashMap<>();
    /**
     * 식당정보
     */
    RestaurantInfo restaurantInfo = new RestaurantInfo();
    /**
     * 메뉴 카테고리
     */
    ArrayList<Category> menuCategoryList = new ArrayList<>();
    /**
     * 카테고리
     */
    Category category = new Category();
    /**
     * 테이블 내역
     */
    HashMap<Integer, Table> tableMap = new HashMap<>();
    /**
     * 테이블 객체
     */
    Table table = new Table();
    /**
     * 주문번호
     */
    int orderNo = 1;
    /**
     * 전체 테이블 수수
     */
    int tableMaxCount = 10;

    /**
     * 생성자
     */
    public Restaurant() {

    }

    /**
     * 생성자
     *
     * @param info 레스토랑 정부
     * @param menus 메뉴 리스트
     */
    public Restaurant(RestaurantInfo info, ArrayList<Menu> menus) {
        menuList = menus;
        restaurantInfo = info;
    }

    /**
     * 메뉴 세팅
     *
     * @param menus 메뉴 리스트
     */
    public void setMenu(ArrayList<Menu> menus) {
        menuList = menus;
    }

    /**
     * 카테고리 세팅
     *
     * @param categoryNo   카테고리 번호
     * @param categoryName 카테고리 이름
     * @param menus        메뉴 리스트
     */
    public void setCategory(int categoryNo, String categoryName, ArrayList<Menu> menus) {
        category = new Category(categoryNo, categoryName, menus);
    }

    /**
     * 카테고리 가져오기
     *
     * @return 카테고리
     */
    public Category getCategory() {
        return category;
    }

    /**
     * 메뉴 가져오기
     *
     * @return 메뉴
     */
    public List<Category> getMenu() {
        return menuCategoryList;
    }

    /**
     * 메뉴 출력
     */
    public void printMenu() {

    }

    /**
     * 주문 생성
     *
     * @param orderMenus 주문메뉴 리스트
     * @return 주문내용
     */
//주문 생성
    public Order createOrder(List<OrderMenu> orderMenus) {
        Order order = new Order(orderMenus, orderNo++);
        orderMap.put(order.OrderNo, order);

        return order;
    }

    /**
     * 주문 가져오기
     *
     * @param orderNo 주문 번호
     * @return 주문번호의 주문내역
     */
    public Order getOrder(int orderNo) {
        return orderMap.get(orderNo);
    }

    /**
     * 주문 추가
     */
    public void addOrder() {

    }

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
    /**
     * 메뉴 조리 완료
     *
     * @param orderNo 주문 번호
     * @param menuNo  완료된 매뉴
     */
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
     * 서빙된 메뉴
     *
     * @param orderNo 주문 번호
     * @param menuNo  서빙된 메뉴
     */
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
     * 레스토랑 정보 세팅
     *
     * @param restaurantInfo 레스톨랑 정보
     */
    public void setRestaurantInfo(RestaurantInfo restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }

    /**
     * 레스토랑 정보 가져오기
     *
     * @return 레스토랑 정보
     */
    public RestaurantInfo getRestaurantInfo() {
        return restaurantInfo;
    }

    /**
     * 주문 취소
     *
     * @param orderNo 주문 번호
     */
    public void removeOrder(int orderNo) {
        orderMap.remove(orderNo);
    }

    /**
     * 주문 변경
     *
     * @param orderNo    주문 번호
     * @param orderMenus 주문 메뉴 리스트
     * @return  변경 후 주문 내용
     */
    public Order changeOrder(int orderNo, List<OrderMenu> orderMenus) {
        Order order = orderMap.get(orderNo);
        order.OrderMenus = orderMenus;
        orderMap.put(orderNo, order);

        System.out.println("주문이 변경되었습니다.");
        System.out.println("변경내역 : " + order.OrderMenus);

        return order;
    }

    /**
     * 테이블 세팅
     *
     * @param tableNo 테이블 번호
     * @param order   테이블의 주문내역
     */
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
     * 잔여 테이블 수 가져오기
     *
     * @return 잔여 테이블 수
     */
    public int getRemainTable() {
        return tableMaxCount - tableMap.size();
    }

    /**
     * 테이블에 주문 추가
     *
     * @param tableNo 테이블 번호
     * @param order   추가할 주문내역
     */
    public void addTableOrder(int tableNo, Order order) {
        Table table = tableMap.get(tableNo);
        table.Orders.add(order);
        tableMap.put(tableNo, table);
    }

    /**
     * 테이블 주문 취소
     *
     * @param tableNo 테이블 번호
     * @param orderNo 취소할 주문 번호
     */
    public void removeTableOrder(int tableNo, int orderNo) {
        Table table = tableMap.get(tableNo);
        System.out.println("테이블 No" + tableNo + "의 주문 " + table.Orders.get(orderNo) + "가 취소되었습니다.");
        table.Orders.remove(orderNo);
    }

    /**
     * 테이블 가져오기
     *
     * @return 테이블 내용
     */
    public Table getTable() {
        return table;
    }

    /**
     * 테이블 정보 출력
     *
     * @param tableNo 테이블 번호
     */
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

   @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantInfo=" + restaurantInfo +
                '}';
    }
}