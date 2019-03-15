package vip.codemonkey.datastore.data.jpa.condition;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author wang zhengtao
 */

public class Pageable implements Serializable{
    private int page = 1;
    private int size = 10;
    private Sort sort;
    private Sort.Direction direction;
    private String[] properties;

    public org.springframework.data.domain.Pageable pageable(){
        if(Objects.nonNull(sort)){
            return PageRequest.of(page,size,sort);
        }else if(Objects.nonNull(direction) && Objects.nonNull(properties) && properties.length>0){
            return PageRequest.of(page,size,direction,properties);
        }else{
            return PageRequest.of(page,size);
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public String[] getProperties() {
        return properties;
    }

    public void setProperties(String[] properties) {
        this.properties = properties;
    }
}
