package bm.project.core.model;

import java.util.List;

/**
 * The type Category.
 */
public class Category {
    /**
     * The Category no.
     */
    public int CategoryNo;
    /**
     * The Category name.
     */
    public String CategoryName;
    /**
     * The Menu list.
     */
    public List<Menu> MenuList;

    /**
     * Instantiates a new Category.
     */
    public Category(){
    }

    /**
     * Instantiates a new Category.
     *
     * @param categoryNo   the category no
     * @param categoryName the category name
     * @param menuList     the menu list
     */
    public Category(int categoryNo, String categoryName, List<Menu> menuList){
        this.CategoryNo = categoryNo;
        this.CategoryName = categoryName;
        this.MenuList = menuList;
    }
}
