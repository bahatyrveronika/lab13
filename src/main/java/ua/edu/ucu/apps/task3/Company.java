package ua.edu.ucu.apps.task3;

import lombok.Getter;

@Getter
public class Company {
    public String name;
    public String description;
    public String logoLink;

    @Override
    public String toString() {
        return "Company{"
                + "name='" + name + '\''
                + ", description='" + description + '\''
                + ", logoLink='" + logoLink + '\''
                + '}';
    }
}
