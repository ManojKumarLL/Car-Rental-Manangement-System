package CarRental;

public class CarDatas {
    public static void main(String[] args) {
          Cars suzuki=new Cars();
             suzuki.setCarId("Car-001");
             suzuki.setCarBrand("Suzuki");
             suzuki.setModel("Ertiga");
             suzuki.setNoOfCarsAvailable(2);
             suzuki.setPricePerDay(3000);

          Cars toyota=new Cars();
             toyota.setCarId("Car-002");
             toyota.setCarBrand("Toyota");
             toyota.setModel("Etios");
             toyota.setNoOfCarsAvailable(4);
             toyota.setPricePerDay(2000);

          Cars ford=new Cars();
             ford.setCarId("Car-003");
             ford.setCarBrand("Ford");
             ford.setModel("Figo");
             ford.setNoOfCarsAvailable(1);
             ford.setPricePerDay(1800);

          Cars tata=new Cars();
             tata.setCarId("Car-004");
             tata.setCarBrand("Tata");
             tata.setModel("Punch");
             tata.setNoOfCarsAvailable(5);
             tata.setPricePerDay(2250);

    CarRentalList crl=new CarRentalList();
       crl.addcars(suzuki);
       crl.addcars(toyota);
       crl.addcars(ford);
       crl.addcars(tata);

       crl.options();

    }
}
