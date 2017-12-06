package jason.springexample.spring5webapp.model;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String postal;

    public Publisher(){
        /*why is this contructor empty??? Does it make Java or Spring cooperate*/
    }

    public Publisher(String name, String street, String city, String state, String postal){
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal = postal;
    }

    public Publisher(String name, String street, String city, String state, String postal, Set <Book> books){
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal = postal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal='" + postal + '\'' +
                '}';
    }
}
