package Model.BEAN;

public class Bill {
    private String userName;
    private String phoneNumber;
    private String address;
    private String location;
    private int price;
    private int numParticipants;
    private String bill;
private int Id;
    public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

	// Constructor
    public Bill() {
    }

    // Setter methods
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    // Getter methods
    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public String getBill() {
        return bill;
    }
}
