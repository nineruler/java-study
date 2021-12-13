package bm.project.core.model;

/**
 * The type Restaurant info.
 */
public class RestaurantInfo {
    /**
     * 레스토랑 이름
     */
    public String Name;
    /**
     * 주소
     */
    public String Address;
    /**
     * 전화번호
     */
    public String PhoneNumber;
    /**
     * 오픈시간
     */
    public Hours OpeningHours;

    /**
     * 생성자
     */
    public RestaurantInfo(){

    }

    /**
     * 생성자
     *
     * @param name        이름
     * @param address     주소
     * @param phoneNumber 전화번호
     * @param open        오픈시간
     * @param close       마감시간
     */
    public RestaurantInfo(String name, String address, String phoneNumber, String open, String close){
        this.Name = name;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.OpeningHours = new Hours(open,close);
    }

    @Override
    public java.lang.String toString() {
        return "RestaurantInfo{" +
                "Address=" + Address +
                ", PhoneNumber='" + PhoneNumber +
                ", Openinghours='" + OpeningHours+'\'' +
                '}';
    }
}
