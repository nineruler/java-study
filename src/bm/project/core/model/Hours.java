package bm.project.core.model;

import java.time.LocalTime;

/**
 * The type Hours.
 */
public class Hours {
    /**
     * The Open.
     */
    public LocalTime Open;
    /**
     * The Close.
     */
    public LocalTime Close;
    /**
     * The Is opened.
     */
    public boolean isOpened;

    /**
     * Instantiates a new Hours.
     *
     * @param open  the open
     * @param close the close
     */
    public Hours(String open, String close){
        this.Open = LocalTime.parse(open);
        this.Close = LocalTime.parse(close);
        this.isOpened = Close.isAfter(LocalTime.now());               //지금이 닫은시간 기준으로 지났는지
    }

    @Override
    public java.lang.String toString() {
        return "Hours{" +
                "Open=" + Open.toString() +
                ",Close='" + Close.toString() + '\'' +
                ", OpenState=" + isOpened +
                '}';
    }
}
