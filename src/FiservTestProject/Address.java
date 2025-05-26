package FiservTestProject;


import java.util.Objects;

public class Address {
    String startDate;
    String endDate;

    Address() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(startDate, address.startDate) && Objects.equals(endDate, address.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }
}
