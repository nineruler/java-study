package bm.project;

import bm.project.core.model.*;
import bm.project.core.model.restaurant.Hongkong;
import bm.project.core.model.restaurant.Restaurant;
import bm.project.core.model.restaurant.Saemaul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //새마을식당
        Saemaul saemaul = new Saemaul(new RestaurantInfo("새마을식당", "수원시 무지개로123", "123-4567", "10:00", "22:00"));
        saemaul.initialize();       // 데이터 초기화

        // 메뉴판 출력
        saemaul.printMenu();

        ArrayList<Menu> meatMenus = saemaul.getMeatMenus();     // 고기 메뉴판
        ArrayList<Menu> mealMenus = saemaul.getMealMenus();     // 식사 메뉴판

        List<OrderMenu> orderMenus = new ArrayList<>();
        orderMenus.add(new OrderMenu(meatMenus.get(0), 2));
        orderMenus.add(new OrderMenu(mealMenus.get(1), 1));

        saemaul.createOrder(orderMenus);

        List<OrderMenu> orderMenus2 = new ArrayList<>();
        orderMenus2.add(new OrderMenu(meatMenus.get(1), 3));
        orderMenus2.add(new OrderMenu(mealMenus.get(3), 1));

        saemaul.createOrder(orderMenus2);

        saemaul.setTable(1, saemaul.getOrder(1));

        saemaul.completeMenu(1,1);
        saemaul.completeMenu(1,2);
//        saemaul.completeOrder(1);
//        saemaul.addTableOrder(1, saemaul.getOrder(2));
        saemaul.printTableInfo(1);

        //홍콩반점
//        Hongkong hongkong = new Hongkong(new RestaurantInfo("홍콩반점","수원시 무지개로124","123-5678","10:00","23:00"));
//
//        hongkong.initialize();
//        ArrayList<Menu> hongkongMenus = hongkong.getHongkongMenus();
//
//        hongkong.printMenu();
//
//        List<OrderMenu> hongkongOrderMenus = new ArrayList<>();
//        hongkongOrderMenus.add(new OrderMenu(hongkongMenus.get(0), 1));
//        hongkongOrderMenus.add(new OrderMenu(hongkongMenus.get(1), 2));
//
//        hongkong.createOrder(hongkongOrderMenus);
//
//        List<OrderMenu> hongkongOrderMenus2 = new ArrayList<>();
//        hongkongOrderMenus2.add(new OrderMenu(hongkongMenus.get(2),2));
//        hongkongOrderMenus2.add(new OrderMenu(hongkongMenus.get(0),1));
//        hongkongOrderMenus2.add(new OrderMenu(hongkongMenus.get(10),1));
//
//        hongkong.createOrder(hongkongOrderMenus2);
//
//        hongkong.setTable(1, hongkong.getOrder(0));
//        hongkong.setTable(2, hongkong.getOrder(1));
//
//        hongkong.printTableInfo(0);
    }
}