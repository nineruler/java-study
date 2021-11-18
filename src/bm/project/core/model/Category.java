package bm.project.core.model;

import java.util.List;

public class Category {
    public int CategoryNo;
    public String CategoryName;
    public List<Menu> MenuList;

    public Category(){

    }

    public Category(int categoryNo, String categoryName, List<Menu> menuList){
        this.CategoryNo = categoryNo;
        this.CategoryName = categoryName;
        this.MenuList = menuList;
    }
}
