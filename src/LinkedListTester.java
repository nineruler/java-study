import java.util.Comparator;
import java.util.Scanner;

public class LinkedListTester {
    static Scanner stdIn = new Scanner(System.in);

    //데이터(회원번호 + 이름)
    static class Data {
        static final int NO = 1;   //번호를 입력받습니까?
        static final int NAME = 2; //이름을 입력받습니까?

        private Integer no; //회원번호
        private String name; //이름

        public String toString() {
            return "(" + no + ") " +name;    //문자열 반환
        }

        //데이터를 입력합니다
        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if((sw & NO) == NO) {
                System.out.print("번호 : ");
                no = stdIn.nextInt();
            }
            if((sw & NAME) == NAME) {
                System.out.print("이름 : ");
                name = stdIn.next();
            }
        }
        //회원번호로 순서를 메기는 comparator
        public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data>{
            public int compare(Data d1, Data d2) {
                return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
            }
        }
        //이름으로 순서를 메기는 comparator
        public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

        private static class NameOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return d1.name.compareTo(d2.name);
            }
        }
    }

    //메뉴 열거형
    enum Menu{
        ADD_FIRST(  "머리에 노드를 삽입"),
        ADD_LAST(   "꼬리에 노드를 삽입"),
        RMV_FIRST(  "머리 노드를 삭제"),
        RMV_LAST(   "꼬리 노드를 삭제"),
        RMV_CRNT(   "선택 노드를 삭제"),
        CLEAR(      "모든 노드를 삭제"),
        SEARCH_NO(  "번호로 검색"),
        SEARCH_NAME("이름으로 검색"),
        NEXT(       "선택 노드를 하나 뒤쪽으로 이동"),
        PRINT_CRNT( "선택 노드를 출력"),
        DUMP(       "모든 노드를 출력"),
        TERMINATE(  "종료");

        private final String message;

        static Menu MenuAt(int idx){  //서수가 idx인 열거를 반환
            for(Menu m : Menu.values()){
                if(m.ordinal() == idx) return m;
            }
            return null;
        }

        Menu(String string) {      //생성자
            message = string;
        }

        String getMessage() {      //출력할 문자열을 반환
            return message;
        }
    }

    static Menu SelectMenu() {
        int key;
        do{
            for(Menu m : Menu.values()) {
                System.out.printf("(%d) %s ", m.ordinal(), m.getMessage());
                if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal()) {
                    System.out.println();
                }
            }
                System.out.print(" : ");
                key = stdIn.nextInt();
        } while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }
}
