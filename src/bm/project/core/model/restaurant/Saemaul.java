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
     * 고기류
     */
    ArrayList<Menu> MeatMenus = new ArrayList<>();
    /**
     * 식사류
     */
    ArrayList<Menu>  MealMenus = new ArrayList<>();
    /**
     * 새마을 식당 메뉴 리스트
     */
    ArrayList<Category> SaemaulMenuList = new ArrayList<>();

    /**
     * 생성자
     */
    public Saemaul(){

    }

    /**
     * 생성자
     *
     * @param restaurantInfo 레스토랑정보
     */
    public Saemaul(RestaurantInfo restaurantInfo){
        this.restaurantInfo = restaurantInfo;
    }

    /**
     * 초기화
     */
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
     * 고기류 메뉴 추가
     *
     * @param menu 추가할 메뉴
     */
    public void setMeatMenus(Menu menu){
        MeatMenus.add(menu);
    }

    /**
     * 고기류 메뉴 가져오기
     *
     * @return 고기류 메뉴 리스트
     */
    public ArrayList<Menu> getMeatMenus(){
        return MeatMenus;
    }

    /**
     * 식사류 메뉴 추가
     *
     * @param menu 추가할 메뉴
     */
    public void setMealMenus(Menu menu){
        MealMenus.add(menu);
    }

    /**
     * 식사류 메뉴 가져오기
     *
     * @return 식사류 메뉴 리스트
     */
    public ArrayList<Menu> getMealMenus(){
        return MealMenus;
    }

    /**
     * 카테코리 추가
     *
     * @param category 추가할 카테고리
     */
    public void setSaemaulMenu(Category category){
        SaemaulMenuList.add(category);
    }

    /**
     * 카테고리 가져오기
     *
     * @return 새마을 메뉴 리스트
     */
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
