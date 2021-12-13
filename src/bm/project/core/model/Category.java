package bm.project.core.model;

import java.util.List;

/**
 * The type Category.
 */
public class Category {
    /**
     * 카테고리 번호
     */
    public int CategoryNo;
    /**
     * 카테고리 이름
     */
    public String CategoryName;
    /**
     * 메뉴 리스트
     */
    public List<Menu> MenuList;

    /**
     * 생성자
     */
    public Category(){
    }

    /**
     * 생성자
     *
     * @param categoryNo   카테고리 번호
     * @param categoryName 카테고리 이름
     * @param menuList     메뉴 리스트
     */
    public Category(int categoryNo, String categoryName, List<Menu> menuList){
        this.CategoryNo = categoryNo;
        this.CategoryName = categoryName;
        this.MenuList = menuList;
    }
}
