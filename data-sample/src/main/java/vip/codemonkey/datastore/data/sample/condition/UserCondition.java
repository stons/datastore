package vip.codemonkey.datastore.data.sample.condition;

import vip.codemonkey.datastore.data.jpa.condition.LongIdCondition;

import java.io.Serializable;

public class UserCondition extends LongIdCondition implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
