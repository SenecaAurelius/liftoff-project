package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent extends User {

    @NotBlank (message = "First Name is required")
    @Size (max = 50, message = "Name is too long")
    private String firstName;

    @NotBlank (message = "Last Name is required")
    @Size (max = 50, message = "Last Name is too long")
    private String lastName;

    @OneToMany(mappedBy = "parent")
    private static List<Child> children = new ArrayList<>();

    @OneToMany(mappedBy = "parentCreator")
    private List<Chore> chores = new ArrayList<>();


    public Parent(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Chore> getChores() {
        return chores;
    }

    public void setChores(List<Chore> chores) {
        this.chores = chores;
    }
}
