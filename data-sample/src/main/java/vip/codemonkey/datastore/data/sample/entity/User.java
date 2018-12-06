package vip.codemonkey.datastore.data.sample.entity;

import vip.codemonkey.datastore.data.jpa.entity.LongIdEntity;

import javax.persistence.Entity;

@Entity
public class User extends LongIdEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
