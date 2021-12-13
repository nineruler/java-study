package bm.project.core.model;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The type Table.
 */
public class Table {
    /**
     * The Table no.
     */
    public int TableNo;
    /**
     * The Orders.
     */
    public List<Order> Orders; //주문번호, 메뉴, 주문시간

    /**
     * Instantiates a new Table.
     */
    public Table(){ }

    /**
     * Instantiates a new Table.
     *
     * @param tableNo the table no
     * @param orders  the orders
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
