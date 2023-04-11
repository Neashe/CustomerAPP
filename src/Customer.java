import java.util.Date;

public class Customer {
    private String firstname;
    private String lastname;
    private Address address;
    private final Date creationDate;
    private final String idVAT;

    Customer(String firstname,String lastname, Address address,String idVAT){
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.idVAT =idVAT;
        this.creationDate = new Date();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Address getAddress() {
        return address;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public void setAddress(Address address){
        this.address = address;
    }

    public String getIdVAT() {
        return idVAT;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Customer info:\n");
        builder.append(firstname).append(" ").append(lastname).append("\n");
        builder.append("Vat ID: ").append(idVAT).append("\n");
        builder.append(address).append("\n");
        builder.append("Created at: ").append(creationDate);

        return builder.toString();

    }
}
