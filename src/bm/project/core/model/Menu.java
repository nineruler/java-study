package bm.project.core.model;

import java.util.ArrayList;

/**
 * The type Menu.
 */
public class Menu{
    /**
     * 메뉴 번호
     */
    public int No;
    /**
     * 메뉴이름
     */
    public String Name;
    /**
     * 메뉴 가격
     */
    public int Price;

    /**
     * 생성자
     *
     * @param No    메뉴 번호
     * @param Name  메뉴 이름
     * @param Price 메뉴 가격
     */
    public Menu(int No, String Name, int Price){
        this.No = No;
        this.Name = Name;
        this.Price = Price;
    }

    @Override
    public java.lang.String toString() {
        return "Menu{" +
                "No=" + No +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                '}';
    }
}