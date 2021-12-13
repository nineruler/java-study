package bm.project.core.model;

/**
 * The type Restaurant info.
 */
public class RestaurantInfo {
    /**
     * The Name.
     */
    public String Name;
    /**
     * The Address.
     */
    public String Address;         //주소
    /**
     * The Phone number.
     */
    public String PhoneNumber;     //전화번호
    /**
     * The Opening hours.
     */
    public Hours OpeningHours;

    /**
     * Instantiates a new Restaurant info.
     */
    public RestaurantInfo(){

    }

    /**
     * Instantiates a new Restaurant info.
     *
     * @param name        the name
     * @param address     the address
     * @param phoneNumber the phone number
     * @param open        the open
     * @param close       the close
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
