package org.example.demo111.dto;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Plan {
    public String name;
    public String description;
    public Date date;

    public Plan() {}

    public Plan(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}' + " в " + getDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        this.date = new Date();
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
