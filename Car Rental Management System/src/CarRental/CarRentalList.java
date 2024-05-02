package CarRental;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CarRentalList {
    private List<Cars> car;
    private List<CustomerDetails> custDetails;
    private List<BookedCarsDetails> bookdCars;

    public CarRentalList(){
        car= new ArrayList<>();
        custDetails=new ArrayList<>();
        bookdCars=new ArrayList<>();
    }

    public void addcars(Cars carss){
        car.add(carss);
    }
    public void addCustomers(CustomerDetails custo){
        custDetails.add(custo);
    }
    public void bookTheCar(Cars carr, CustomerDetails custt, int days){
            if(carr.getNoOfCarsAvailable() > 0){
                 carr.setNoOfCarsAvailable(carr.getNoOfCarsAvailable()-1);
                 bookdCars.add(new BookedCarsDetails(carr,custt,days));
            }
            else System.out.println("Car Not Available to Book");
    }
    public void returnTheCar(Cars carr, BookedCarsDetails bookdcardets2Brtnd){
        carr.setNoOfCarsAvailable(carr.getNoOfCarsAvailable()+1);                 // bookdcardets2Brtnd.getbCar().setNoOfCarsAvailable(bookdcardets2Brtnd.getbCar().getNoOfCarsAvailable()+1);
        bookdCars.remove(bookdcardets2Brtnd);
    }

    public void options(){
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("  ==========|  Hello, Welcome to our Car Rental Service  |======== ");
            System.out.println("Select 1 option from below ");
            System.out.println(" 1. Rent a Car");
            System.out.println(" 2. Return the Car");
            System.out.println(" 3. Available Cars Details");
            System.out.println(" 4. Exit ");

            System.out.println(" Enter you Choice : ");
            int choice=sc.nextInt();
            sc.nextLine();

            if(choice==1){
                System.out.println("<==== For Renting a Car please fill the below details ====>");

                System.out.print(" Enter Your Name : ");
                String cusName=sc.nextLine();

                System.out.println(" Enter the Car Id which you want : ");
                String carId=sc.nextLine();

                System.out.println(" Number of Days you want car for rent : ");
                int days=sc.nextInt();

                CustomerDetails custo =new CustomerDetails("Customer-" + (custDetails.size()), cusName);
                addCustomers(custo);

                Optional<Cars> carOpted= car.stream()
                  .filter(c -> c.getCarId().equalsIgnoreCase(carId)  && c.getNoOfCarsAvailable() > 0)
                  .findAny();
               if(carOpted.isEmpty()){
                   System.out.println("Sorry,Right Now The Car you selected is not Available.  <<- Please do check other Available Cars ->>");
                   options();
                   return;
               }
               Cars selectedCar=carOpted.get();
                  System.out.println("     ===Booking Details Verification=== ");
                  System.out.println("Customer-ID: "+ custo.getId());
                  System.out.println("Customer-Name: "+ custo.getName());
                  System.out.println("Car-Brand: "+ selectedCar.getCarBrand() + " and Model: "+selectedCar.getModel());
                  System.out.println("No.of Days Rented: "+ days);
                  System.out.println("Price-Details: "+ selectedCar.calculateTotalPrice(days));

                System.out.println("Confirm Your Booking (Yes/No): ");
                String confirmation=sc.next();
                   if(confirmation.equalsIgnoreCase("Yes")){
                         bookTheCar(selectedCar,custo,days);
                         System.out.println("Car is Booked Successfully. Have a nice day!");
                   }
                   else { System.out.println("Booking is Cancelled."); }

            }
            else if (choice==2) {
                System.out.println("=== To Return the Car Please Fill the below Informations ===");
                System.out.println("Enter the Car Id which you want to return :");
                String rtnCarId=sc.nextLine();

                Optional<Cars>  car2ReturnList= car.stream()
                        .filter( c-> c.getCarId().equalsIgnoreCase(rtnCarId))
                        .findAny();
                if(car2ReturnList.isEmpty()) {
                    System.out.println("Please provide valid details.");
                    options();
                    return;
                }
                Cars car2bReturned = car2ReturnList.get();
                BookedCarsDetails bookedCar2return = bookdCars.stream()
                         .filter( b -> b.getbCar()==car2bReturned).findFirst()
                         .orElse(null);
                if(bookedCar2return == null ){
                    System.out.println("Entered Car Information is not valid. Please provide valid detaisl!");
                    options();
                    return;
                }
                CustomerDetails custOfRetnCar=bookedCar2return.getCust();
                returnTheCar(car2bReturned,bookedCar2return);
                System.out.println("Car is Returned Successfully by Customer :"+ custOfRetnCar.getName());
            }
            else if(choice==3){
                    System.out.println(" === Available Cars ===");
                    car.stream()
                       .filter( c-> c.getNoOfCarsAvailable() > 0)
                       .forEach( car-> System.out.println( "CarId: " + car.getCarId() +" - "+ car.getCarBrand()  +" - "+ car.getModel()  +" - "+ car.getNoOfCarsAvailable() ) );
            }
            else if(choice==4){
                System.out.println("It's Our Great Time With Our Valuable Customer! Visit Us Again!");
                break;
            }
            else{
                System.out.println("Please Select Valid Option");
            }
        }
    }
}
