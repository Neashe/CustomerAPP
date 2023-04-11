public class Address {
    String street;
    String postalCode;
    String city;
    String country;
    String houseNumber;
    String flatNumber;
    Address(){}

    Address(String street,String postalCode, String city, String country, String houseNumber){
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.houseNumber = houseNumber;
        this.flatNumber = null;
    }
    Address(String street,String postalCode, String city, String country, String houseNumber,String flatNumber){
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        String addressString = " ";
        if (this.flatNumber !=null){
            addressString += this.street+" "+this.houseNumber+"/"+this.flatNumber+"\n"+this.postalCode
                    + " "+this.city+", "+this.country;
        }
        else{
            addressString += this.street+" "+this.houseNumber+"\n"+this.postalCode
                    + " "+this.city+", "+this.country;
        }
        return addressString;
    }
}
