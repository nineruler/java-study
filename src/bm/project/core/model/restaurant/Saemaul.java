package bm.project.core.model.restaurant;

import bm.project.core.model.Category;
import bm.project.core.model.Menu;
import bm.project.core.model.RestaurantInfo;

import java.util.ArrayList;

/**
 * The type Saemaul.
 */
public class Saemaul extends Restaurant {
    /**
     * The Meat menus.
     */
    ArrayList<Menu> MeatMenus = new ArrayList<>();
    /**
     * The Meal menus.
     */
    ArrayList<Menu>  MealMenus = new ArrayList<>();
    /**
     * The Saemaul menu list.
     */
    ArrayList<Category> SaemaulMenuList = new ArrayList<>();

    /**
     * Instantiates a new Saemaul.
     */
    public Saemaul(){

    }

    /**
     * Instantiates a new Saemaul.
     *
     * @param restaurantInfo the restaurant info
     */
    public Saemaul(RestaurantInfo restaurantInfo){
        this.restaurantInfo = restaurantInfo;
    }

    /**
     * Initialize.
     */
// 초기화
    public void initialize(){
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "열탄불고기", 9000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "새마을불고기", 9000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "소금구이", 10000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "양념구이", 10000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "항정살", 11000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "오겹살", 11000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "차돌박이", 18000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "훈제막창", 9000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "껍데기", 6000));
        setCategory(1, "고기류", MeatMenus);
        SaemaulMenuList.add(getCategory());

        MealMenus.add(new Menu(MealMenus.size() + 1, "7분돼지김치", 6000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "얼큰김치찌개", 6000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "새마을 된장찌개", 6000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "냉김치말이국수", 5000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "멸치국수", 3000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "계란찜", 3000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "옛날도시락", 3000));
        setCategory(2, "식사류", MealMenus);
        SaemaulMenuList.add(getCategory());
    }

    /**
     * Set meat menus.
     *
     * @param menu the menu
     */
// 고기류에 메뉴 추가
    public void setMeatMenus(Menu menu){
        MeatMenus.add(menu);
    }

    /**
     * Get meat menus array list.
     *
     * @return the array list
     */
// 고기류 메뉴 가져오기
    public ArrayList<Menu> getMeatMenus(){
        return MeatMenus;
    }

    /**
     * Set meal menus.
     *
     * @param menu the menu
     */
// 식사류에 메뉴 추가
    public void setMealMenus(Menu menu){
        MealMenus.add(menu);
    }

    /**
     * Get meal menus array list.
     *
     * @return the array list
     */
// 식사류 메뉴 가져오기
    public ArrayList<Menu> getMealMenus(){
        return MealMenus;
    }

    /**
     * Set saemaul menu.
     *
     * @param category the category
     */
// 카테고리 추가
    public void setSaemaulMenu(Category category){
        SaemaulMenuList.add(category);
    }

    /**
     * Get saemaul menu array list.
     *
     * @return the array list
     */
//카테고리 가져오기
    public ArrayList<Category> getSaemaulMenu(){
        return SaemaulMenuList;
    }

    @Override
    public void printMenu() {
        super.printMenu();

        System.out.println("새마을 식당 메뉴판");

        for (Category category : SaemaulMenuList) {

            System.out.printf("%d.%S%n", category.CategoryNo, category.CategoryName);

            for (Menu menu : category.MenuList)
            {
                System.out.printf("%d.%d.%S : %d원%n", category.CategoryNo, menu.No, menu.Name, menu.Price);
            }

            System.out.println();
        }

        System.out.println();
    }
}
