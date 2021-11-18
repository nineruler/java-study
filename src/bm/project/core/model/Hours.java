package bm.project.core.model;

import java.time.LocalTime;

public class Hours {
    public LocalTime Open;
    public LocalTime Close;
    public boolean isOpened;

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
