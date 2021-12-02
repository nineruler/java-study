package bm.project.core.model.restaurant;

import bm.project.core.model.Menu;
import bm.project.core.model.RestaurantInfo;

import java.util.ArrayList;

public class Hongkong extends Restaurant{
    ArrayList<Menu> HongkongMenus = new ArrayList<>();

    public Hongkong(){

    }

    public Hongkong(RestaurantInfo info){
        this.restaurantInfo = info;
    }

    //초기설정
    public void initialize(){
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "짜장면", 4500));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "짜장면곱빼기", 5500));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "짬뽕", 5500));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "짬뽕곱빼기", 6500));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "짜장밥", 6500));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "짬뽕밥", 6000));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "고추짬뽕", 6500));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "고추짬뽕밥", 7000));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "볶음짬뽕", 6500));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "탕수육 소", 11000));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "탕수육 중", 13000));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "탕수육 대", 16000));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "깐풍기 소", 12000));
        HongkongMenus.add(new Menu(HongkongMenus.size() + 1, "깐풍기 대", 18000));
    }

    //홍콩반점 메뉴 추가
    public void setHokongMenu(Menu menu){
        HongkongMenus.add(menu);
    }

    //홍콩반점 메뉴 가져오기
    public ArrayList<Menu> getHongkongMenus(){
        return HongkongMenus;
    }

    public void printMenu(){
        super.printMenu();

        System.out.println("홍콩반점 메뉴판");

        for(Menu menu : HongkongMenus){
            System.out.format("%d %S %d\n",menu.No,menu.Name,menu.Price);
        }

        System.out.println();
    }
}
