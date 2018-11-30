package vip.codemonkey.datastore.datastore.condition;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseLongIdCondition implements Serializable {

    protected Long id;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}
