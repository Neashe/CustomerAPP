import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        String mainOptionList = """
                1. Display customers
                2. Add new customer
                3. Delete customer
                4. Exit
                """;
        System.out.println("HI!");
        System.out.println("Welcome to Customer Manager App!");
        System.out.println("What do you want to do?:");
        while(running){
            System.out.println(mainOptionList);
            try {

                    int choice = scanner.nextInt();
                    scanner.nextLine();




            switch (choice){
                case 1:
                    boolean inDisplayMode = true;
                    while (inDisplayMode){
                        if (customerManager.displayCustomers()) {

                            System.out.println("What next?");
                            System.out.println("1. Show selected customer info");
                            System.out.println("2. return");

                            choice = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice) {
                                case 1 -> {
                                    System.out.println("Which one?");
                                    choice = scanner.nextInt();
                                    scanner.nextLine();
                                    if (!customerManager.displayCustomer(choice)) {
                                        System.out.println("Please provide valid index");
                                    }
                                }
                                case 2 -> inDisplayMode = false;
                                default -> System.out.println("I don't understand");
                            }
                        }
                        else{
                        break;}
                    }

                    break;
                case 2:
                    System.out.println("Please provide data below: ");
                    Customer customer = getInfo();
                    if (customer ==null){
                        System.out.println("You need to provide all data!");
                    }
                    else if( customerManager.addCustomer(customer)){
                        System.out.println("Customer succesfully added!");
                    }
                    break;
                case 3:
                    if (customerManager.displayCustomers()) {
                        System.out.println("Which customer should be deleted?(provide number)");
                        int toDelete = scanner.nextInt();
                        scanner.nextLine();
                        if (customerManager.deleteCustomer(toDelete)){
                            System.out.println("Delete operation successfull!");
                        }

                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("I don't understand, please provide number (1-4)");
            }
            }
            catch (InputMismatchException e){
                System.out.println("Only integers are possible");
                break;
            };
        }
    }

    public static Customer getInfo(){
        Scanner scanner = new Scanner(System.in);
        String check ="";

        System.out.println("Firstname: ");
        String firstname = scanner.nextLine();
        if (firstname.equals("")) return null;

        System.out.println("Lastname:");
        String lastname = scanner.nextLine();
        if (lastname.equals("")) return null;

        System.out.println("Vat ID:");
        String vatID = scanner.nextLine();
        if (vatID.equals("")) return null;

        System.out.println("Country: ");
        String country = scanner.nextLine();
        if (country.equals("")) return null;

        System.out.println("City: ");
        String city = scanner.nextLine();
        if (city.equals("")) return null;

        System.out.println("Street: ");
        String street = scanner.nextLine();
        if (street.equals("")) return null;

        System.out.println("Postal code:");
        String postalCode = scanner.nextLine();
        if (postalCode.equals("")) return null;

        System.out.println("House number: ");
        String houseNumber = scanner.nextLine();
        if(houseNumber.equals("")) return null;

        System.out.println("Flat number:");
        String flatNumber = scanner.nextLine();
        if (flatNumber.equals("")) return  null;


        Address address = new Address(street,postalCode,city,country,houseNumber,flatNumber);
        return new Customer(firstname,lastname,address,vatID);
    }
}
