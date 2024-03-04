package GeekBrains.JDK.Seminar4.model;

public class Employee {
    private int serviceNumber;
    private String phoneNumber;
    private String name;
    private int seniority;

    public Employee(int serviceNumber, String phoneNumber, String name, int seniority) {
        this.serviceNumber = serviceNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.seniority = seniority;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "serviceNumber=" + serviceNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", seniority=" + seniority +
                '}';
    }
}
