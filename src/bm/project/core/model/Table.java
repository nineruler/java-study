package bm.project.core.model;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The type Table.
 */
public class Table {
    /**
     * 테이블 번호
     */
    public int TableNo;
    /**
     * 주문내역
     */
    public List<Order> Orders; //주문번호, 메뉴, 주문시간

    /**
     * 생성자
     */
    public Table(){ }

    /**
     * 생성자
     *
     * @param tableNo 테이블 번호
     * @param orders  주문내역
     */
    public Table(int tableNo, List<Order> orders){
        this.TableNo = tableNo;
        this.Orders = orders;
    }

    @Override
    public java.lang.String toString() {
        return "Table{" +
                "TableNo=" + TableNo +
                "Orders=" + Orders +
                '}';
    }
}
