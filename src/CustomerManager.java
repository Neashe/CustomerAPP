import java.util.*;

public class CustomerManager {
    private final ArrayList<Customer> customers;
    private final Set<String> customersID;

    CustomerManager(){
        this.customers = new ArrayList<>();
        this.customersID = new HashSet<>();
    }
    CustomerManager(Customer customer){
        this.customers = new ArrayList<>();
        this.customersID = new HashSet<>();
        this.customers.add(customer);
        this.customersID.add(customer.getIdVAT());
    }
    //1. add customer - can add if there is no customer with given VatID
    public boolean addCustomer(Customer customer){
        if (customersID.contains(customer.getIdVAT())){
            System.out.println("This customer is already added!\n");
            return false;
        }
        this.customers.add(customer);
        this.customersID.add(customer.getIdVAT());
        return true;
    }
    //2. delete customer
    public boolean deleteCustomer(int index){
        index--;
        if (index<0 || index >= customers.size()){
            System.out.println("Please provide valid index\n");
            return false;
        }
        customersID.remove(customers.get(index).getIdVAT());
        customers.remove(index);
        return true;
    }
    //3. upgrade customer
    public boolean upgradeCustomer(int index,String firstname,String lastname,Address address){
        if (index<0 || index >= customers.size()){
            System.out.println("Please provide valid index\n");
            return false;
        }
        Customer customer = this.customers.get(index);
        if (firstname !=null){
            customer.setFirstname(firstname);
        }
        if (lastname != null){
            customer.setLastname(lastname);
        }
        if (address != null){
            updateCustomerAddress(customer.getAddress(),address);
            }
        return true;
        }
    public void updateCustomerAddress(Address oldAddres,Address address)
    {
        if (address.getCity()!=null){
            oldAddres.setCity(address.getCity());
        }
        if (address.getCountry()!=null){
            oldAddres.setCountry(address.getCountry());
        }
        if (address.getFlatNumber()!= null){
            oldAddres.setFlatNumber(address.getFlatNumber());
        }
        if (address.getStreet() != null){
            oldAddres.setStreet(address.getStreet());
        }
        if (address.getHouseNumber() != null){
            oldAddres.setHouseNumber(address.getHouseNumber());
        }
        if (address.getPostalCode() !=null){
            oldAddres.setPostalCode(address.getPostalCode());
        }
    }
    public boolean displayCustomer(int index){
        index--;
        if (index<0 || index >= customers.size()){
            System.out.println("Please provide valid index\n");
            return false;
        }
        System.out.println(customers.get(index));
        return true;
    }
    public boolean displayCustomers(){
        if (customers.size()== 0){
            System.out.println("There are no customers in database");
            return false;
        }
        for (int i = 0;i<customers.size();i++){
            Customer customer = customers.get(i);
            System.out.println((i+1)+". "+customer.getFirstname()+" "+customer.getLastname());
        }
        return true;
    }

}
