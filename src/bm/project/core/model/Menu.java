package bm.project.core.model;

import java.util.ArrayList;

/**
 * The type Menu.
 */
public class Menu{
    /**
     * The No.
     */
    public int No;
    /**
     * The Name.
     */
    public String Name;
    /**
     * The Price.
     */
    public int Price;

    /**
     * Instantiates a new Menu.
     *
     * @param No    the no
     * @param Name  the name
     * @param Price the price
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