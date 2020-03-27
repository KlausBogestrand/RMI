package numberlist.shared;

import java.io.Serializable;

public class Person implements Serializable {
    public Person(String navn) {
        this.navn = navn;
    }

    private String navn;

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
