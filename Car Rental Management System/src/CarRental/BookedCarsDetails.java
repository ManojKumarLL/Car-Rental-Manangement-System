package CarRental;

public class BookedCarsDetails {

    private Cars bCar;
    private CustomerDetails cust;
    private int noDays;

    public BookedCarsDetails(Cars bcar, CustomerDetails cust, int noDays){
            this.bCar=bcar;
            this.cust=cust;
            this.noDays=noDays;
    }

    public Cars getbCar() {
        return bCar;
    }
    public CustomerDetails getCust() {
        return cust;
    }
    public int getNoDays() {
        return noDays;
    }
}
