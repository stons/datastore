package vip.codemonkey.datastore.datastore.entity;

import lombok.Data;
import vip.codemonkey.datastore.datastore.common.entity.LongIdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User  extends LongIdEntity {
    private String name;
}
