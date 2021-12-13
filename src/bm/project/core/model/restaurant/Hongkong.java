package bm.project.core.model.restaurant;

import bm.project.core.model.Menu;
import bm.project.core.model.RestaurantInfo;

import java.util.ArrayList;

/**
 * The type Hongkong.
 */
public class Hongkong extends Restaurant{
    /**
     * The Hongkong menus.
     */
    ArrayList<Menu> HongkongMenus = new ArrayList<>();

    /**
     * Instantiates a new Hongkong.
     */
    public Hongkong(){

    }

    /**
     * Instantiates a new Hongkong.
     *
     * @param info the info
     */
    public Hongkong(RestaurantInfo info){
        this.restaurantInfo = info;
    }

    /**
     * Initialize.
     */
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

    /**
     * Set hokong menu.
     *
     * @param menu the menu
     */
//홍콩반점 메뉴 추가
    public void setHokongMenu(Menu menu){
        HongkongMenus.add(menu);
    }

    /**
     * Get hongkong menus array list.
     *
     * @return the array list
     */
//홍콩반점 메뉴 가져오기
    public ArrayList<Menu> getHongkongMenus(){
        return HongkongMenus;
    }

    //홍콩반점 메뉴 프린트
    public void printMenu(){
        super.printMenu();

        System.out.println("홍콩반점 메뉴판");

        for(Menu menu : HongkongMenus){
            System.out.format("%d %S %d\n",menu.No,menu.Name,menu.Price);
        }

        System.out.println();
    }
}
