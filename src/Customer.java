public class Customer {
private int id;
private  String fullName;
private String numberPhone;

    public Customer(int id, String fullName, String numberPhone) {
        this.id = id;
        this.fullName = fullName;
        this.numberPhone = numberPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void printInfo(){
        System.out.println("ID: " + id +
                "\nName: " + fullName +
                "\nPhone number: " + numberPhone);
    }
}


