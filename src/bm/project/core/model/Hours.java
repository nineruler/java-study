package bm.project.core.model;

import java.time.LocalTime;

/**
 * The type Hours.
 */
public class Hours {
    /**
     * 오픈시간
     */
    public LocalTime Open;
    /**
     * 마감시간
     */
    public LocalTime Close;
    /**
     * 오픈 여부
     */
    public boolean isOpened;

    /**
     * 생성자
     *
     * @param open  오픈시간
     * @param close 마감시간
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
