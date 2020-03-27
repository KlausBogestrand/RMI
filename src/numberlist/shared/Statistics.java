package numberlist.shared;

import java.io.Serializable;

public class Statistics implements Serializable {
    public Statistics(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    private int numberOfPersons;

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}
