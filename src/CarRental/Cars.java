package CarRental;

public class Cars {
    private String carId;
    private String carBrand;
    private String model;
    private double pricePerDay;
    private int noOfCarsAvailable;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getNoOfCarsAvailable() {
        return noOfCarsAvailable;
    }

    public void setNoOfCarsAvailable(int noOfCarsAvailable) {
        this.noOfCarsAvailable = noOfCarsAvailable;
    }

    public double calculateTotalPrice(int days){
        return pricePerDay*days;
    }
}
